package com.gbs.core.controller;

import com.gbs.core.model.ForbiddenWord;
import com.gbs.core.model.User;
import com.gbs.core.service.ForbiddenWordService;
import com.gbs.core.service.UserService;
import com.gbs.core.util.JwtTokenProvider;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Log4j2
@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ForbiddenWordService forbiddenWordService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // 根据用户ID获取用户信息
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.findById(id);
    }

    // 根据手机号获取用户信息
    @GetMapping("/phone/{phoneNumber}")
    public User getUserByPhoneNumber(@PathVariable String phoneNumber) {
        return userService.findByPhoneNumber(phoneNumber);
    }

    // 根据微信OpenID获取用户信息
    @GetMapping("/wechat/{openId}")
    public User getUserByWeChatOpenId(@PathVariable String openId) {
        return userService.findByWeChatOpenId(openId);
    }

    // 根据QQ OpenID获取用户信息
    @GetMapping("/qq/{openId}")
    public User getUserByQQOpenId(@PathVariable String openId) {
        return userService.findByQQOpenId(openId);
    }

    // 注册新用户
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User userDetails) {
        try {
            String username = sanitizeInput(userDetails.getUserName());
            String phoneNumber = sanitizeInput(userDetails.getPhoneNumber());
            String password = userDetails.getPassword();

            if (username != null && !isValidUserName(username)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("用户名格式不正确或有敏感词，请检查！");
            }

            if (phoneNumber != null && !isValidPhoneNumber(phoneNumber)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("手机号格式不正确，请检查！");
            }

            if (password != null && !isValidPassword(password)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("密码格式不正确，请检查！");
            }

            // 根据传入的手机号或用户名动态判断是否存在
            if (userDetails.getPhoneNumber() != null && !userDetails.getPhoneNumber().isEmpty()) {
                User existingUserByPhoneNumber = userService.findByPhoneNumber(userDetails.getPhoneNumber());
                if (existingUserByPhoneNumber != null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("手机号已被注册");
                }
            }

            if (userDetails.getUserName() != null && !userDetails.getUserName().isEmpty()) {
                User existingUserByUserName = userService.findByUserName(username);
                if (existingUserByUserName != null) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("用户名已被注册");
                }
            }

            // 调用 UserService 的 registerUser 方法完成用户注册
            User newUser = userService.registerUser(userDetails);
            return ResponseEntity.ok(newUser);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("注册失败: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        try {
            String phoneNumber = sanitizeInput(loginRequest.get("phoneNumber"));
            String username = sanitizeInput(loginRequest.get("userName"));
            String password = loginRequest.get("password");

            if ((phoneNumber == null || phoneNumber.isEmpty()) && (username == null || username.isEmpty())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("手机号或用户名不能为空");
            }

            if (password == null || password.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("密码不能为空");
            }

            // 根据手机号或用户名查找用户
            User user = null;
            if (phoneNumber != null && !phoneNumber.isEmpty()) {
                if (!isValidPhoneNumber(phoneNumber)) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("手机号格式不正确");
                }
                user = userService.findByPhoneNumber(phoneNumber);
            }

            if (username != null && !username.isEmpty()) {
                if (!isValidUserName(username)) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("用户名格式不正确或有敏感词，请检查！");
                }
                user = userService.findByUserName(username);
            }

            if (user == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("用户不存在，请检查！");
            }

            // 检查用户是否已激活
            if (!user.isActive()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("非活跃用户！");
            }

            // 验证密码是否正确
            boolean isPasswordValid = userService.checkPassword(user, password);
            if (!isPasswordValid) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("密码错误，请检查！");
            }

            // 更新最后登录时间
            user.setLastLoginAt(new Date());
            userService.updateUser(user.getId(), user);

            // 生成 JWT 并返回给前端，保持登录
            String token = jwtTokenProvider.createToken(user.getId());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("登录失败: " + e.getMessage());
        }
    }

    @PostMapping("/check-username")
    public ResponseEntity<?> checkUserNameAvailability(@RequestBody Map<String, String> request) {
        try {
            String username = sanitizeInput(request.get("username"));

            if (username == null || username.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("用户名不能为空");
            }

            if (!isValidUserName(username)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("用户名格式不正确");
            }

            // 检查用户名是否已存在
            User existingUser = userService.findByUserName(username);
            boolean isAvailable = (existingUser == null);

            // 返回结果
            Map<String, Object> response = Collections.singletonMap("available", isAvailable);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("检查用户名失败: " + e.getMessage());
        }
    }

    // 更新用户信息
    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    // 输入清理方法
    private String sanitizeInput(String input) {
        if (input == null) {
            return null;
        }
        // 移除 HTML 标签和特殊字符
        return input.replaceAll("[<>\"'%;)(&+]", "");
    }

    // 用户名验证
    private boolean isValidUserName(String username) {
        if (username == null) {
            return false;
        }
        // 仅允许字母、数字、下划线和短横线，长度为3到16位
        if (!username.matches("^[a-zA-Z0-9_-]{3,16}$")) {
            return false;
        }

        // 将用户名转换为小写，避免大小写问题
        String lowerUsername = username.toLowerCase();

        // 禁止使用的用户名列表
        Set<String> forbiddenUsernames = new HashSet<>(Arrays.asList(
                "admin", "administrator", "root", "superuser", "system", "manager",
                "operator", "supervisor", "sysadmin", "moderator", "support",
                "helpdesk", "security", "guest", "test", "user", "null", "void", "master",
                "owner", "账户", "管理员", "超级用户", "系统", "版主", "客服", "管理"
        ));

        if (forbiddenUsernames.contains(lowerUsername)) {
            return false;
        }

        List<ForbiddenWord> forbiddenWords = forbiddenWordService.getForbiddenWords();

        for (ForbiddenWord word : forbiddenWords) {
            if (lowerUsername.contains(word.getSensitiveWords().toLowerCase())) {
                return false;
            }
        }

        // 敏感词列表
        String[] sensitiveWords = {
                "password", "passwd", "pwd", "admin", "god", "sex", "porn",
        };

        for (String word : sensitiveWords) {
            if (lowerUsername.contains(word.toLowerCase())) {
                return false;
            }
        }

        return true;
    }

    // 手机号验证
    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        // 简单的手机号格式验证
        return phoneNumber.matches("^1[3-9]\\d{9}$");
    }

    // 密码验证
    private boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        // 至少8位，包括字母和数字
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }
}
