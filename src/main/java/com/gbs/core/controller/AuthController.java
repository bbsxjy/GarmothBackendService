package com.gbs.core.controller;

import com.gbs.core.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import com.gbs.core.util.JwtTokenProvider;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    @Autowired
    private SmsService smsService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @PostMapping("/send-sms-code")
    public ResponseEntity<?> sendSmsCode(@RequestBody Map<String, String> request) {
        String phoneNumber = request.get("phoneNumber");
        String code = generateCode();
        // 存储验证码到 Redis，设置 5 分钟过期
        redisTemplate.opsForValue().set("SMS_CODE_" + phoneNumber, code, 5, TimeUnit.MINUTES);
        // 发送验证码
        smsService.sendSms(phoneNumber, code);
        return ResponseEntity.ok("验证码已发送");
    }

    @PostMapping("/verify-sms-code")
    public ResponseEntity<?> verifySmsCode(@RequestBody Map<String, String> request) {
        String phoneNumber = request.get("phoneNumber");
        String code = request.get("code");
        String cachedCode = redisTemplate.opsForValue().get("SMS_CODE_" + phoneNumber);

        if (code.equals(cachedCode)) {
            // 验证成功，生成 JWT 令牌
            String token = jwtTokenProvider.createToken(phoneNumber);
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("验证码错误");
        }
    }

    private String generateCode() {
        return String.valueOf((int)((Math.random() * 9 + 1) * 100000));
    }
}
