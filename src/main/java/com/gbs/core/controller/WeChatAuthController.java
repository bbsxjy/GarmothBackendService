package com.gbs.core.controller;

import com.gbs.core.model.User;
import com.gbs.core.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import com.gbs.core.util.JwtTokenProvider;

@RestController
@RequestMapping("/v1/auth")
public class WeChatAuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    private static final String APP_ID = "您的微信AppID";
    private static final String APP_SECRET = "您的微信AppSecret";

    @GetMapping("/wechat")
    public void redirectToWeChat(HttpServletResponse response) throws IOException {
        String redirectUri = URLEncoder.encode("https://yourdomain.com/api/auth/wechat/callback", "UTF-8");
        String wechatAuthUrl = "https://open.weixin.qq.com/connect/qrconnect?appid=" + APP_ID
                + "&redirect_uri=" + redirectUri
                + "&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect";
        response.sendRedirect(wechatAuthUrl);
    }

    @GetMapping("/wechat/callback")
    public void wechatCallback(@RequestParam String code, HttpServletResponse response) throws IOException {
        // 1. 使用 code 获取 access_token
        String tokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APP_ID
                + "&secret=" + APP_SECRET
                + "&code=" + code
                + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String tokenResponse = restTemplate.getForObject(tokenUrl, String.class);
        JSONObject tokenJson = new JSONObject(tokenResponse);
        String accessToken = tokenJson.getString("access_token");
        String openId = tokenJson.getString("openid");

        // 2. 获取用户信息
        String userInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + accessToken + "&openid=" + openId;
        String userInfoResponse = restTemplate.getForObject(userInfoUrl, String.class);
        JSONObject userInfoJson = new JSONObject(userInfoResponse);

        // 3. 创建或更新用户
        User user = userService.findOrCreateByWeChatOpenId(openId, userInfoJson);

        // 4. 生成 JWT 令牌
        String token = jwtTokenProvider.createToken(user.getId().toString());

        // 5. 重定向到前端，携带 token
        response.sendRedirect("https://yourfrontenddomain.com/login-success?token=" + token);
    }
}
