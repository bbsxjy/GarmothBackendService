package com.gbs.core.controller;

import com.gbs.core.model.User;
import com.gbs.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import com.gbs.core.util.JwtTokenProvider;


@RestController
@RequestMapping("/v1/auth")
public class QQAuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    private static final String APP_ID = "您的QQ AppID";
    private static final String APP_KEY = "您的QQ AppKey";

    @GetMapping("/qq")
    public void redirectToQQ(HttpServletResponse response) throws IOException {
        String redirectUri = URLEncoder.encode("https://yourdomain.com/api/auth/qq/callback", "UTF-8");
        String qqAuthUrl = "https://graph.qq.com/oauth2.0/authorize?response_type=code"
                + "&client_id=" + APP_ID
                + "&redirect_uri=" + redirectUri
                + "&state=STATE";
        response.sendRedirect(qqAuthUrl);
    }

    @GetMapping("/qq/callback")
    public void qqCallback(@RequestParam String code, HttpServletResponse response) throws IOException {
        // 1. 使用 code 获取 access_token
        String tokenUrl = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code"
                + "&client_id=" + APP_ID
                + "&client_secret=" + APP_KEY
                + "&code=" + code
                + "&redirect_uri=" + URLEncoder.encode("https://yourdomain.com/api/auth/qq/callback", "UTF-8");
        RestTemplate restTemplate = new RestTemplate();
        String tokenResponse = restTemplate.getForObject(tokenUrl, String.class);
        String accessToken = extractAccessToken(tokenResponse);

        // 2. 获取 openid
        String openIdUrl = "https://graph.qq.com/oauth2.0/me?access_token=" + accessToken;
        String openIdResponse = restTemplate.getForObject(openIdUrl, String.class);
        String openId = extractOpenId(openIdResponse);

        // 3. 获取用户信息
        String userInfoUrl = "https://graph.qq.com/user/get_user_info?access_token=" + accessToken
                + "&oauth_consumer_key=" + APP_ID
                + "&openid=" + openId;
        String userInfoResponse = restTemplate.getForObject(userInfoUrl, String.class);
        JSONObject userInfoJson = new JSONObject(userInfoResponse);

        // 4. 创建或更新用户
        User user = userService.findOrCreateByQQOpenId(openId, userInfoJson);

        // 5. 生成 JWT 令牌
        String token = jwtTokenProvider.createToken(user.getId().toString());

        // 6. 重定向到前端，携带 token
        response.sendRedirect("https://yourfrontenddomain.com/login-success?token=" + token);
    }

    private String extractAccessToken(String response) {
        // 解析 access_token
        Map<String, String> params = Arrays.stream(response.split("&"))
                .map(param -> param.split("="))
                .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
        return params.get("access_token");
    }

    private String extractOpenId(String response) {
        // 解析 openid
        String json = response.substring(response.indexOf("{"), response.indexOf("}") + 1);
        JSONObject jsonObject = new JSONObject(json);
        return jsonObject.getString("openid");
    }
}
