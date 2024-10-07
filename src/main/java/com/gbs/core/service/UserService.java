package com.gbs.core.service;

import com.gbs.core.model.User;
import com.gbs.core.datastore.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Log4j2
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 初始化密码加密器

    // 注册用户（包括密码加密）
    public User registerUser(final User userDetails) {
        // 创建新用户
        User newUser = new User();
        if (userDetails.getPhoneNumber() != null && !userDetails.getPhoneNumber().isEmpty()) {
            newUser.setPhoneNumber(userDetails.getPhoneNumber());
            newUser.setRegistrationSource("phone"); // 设置注册来源为手机号
        } else {
            newUser.setUserName(userDetails.getUserName());
            newUser.setRegistrationSource("username"); // 设置注册来源为用户名
        }
        newUser.setNickname(userDetails.getNickname());
        newUser.setAvatarUrl(userDetails.getAvatarUrl());
        newUser.setRegisteredAt(new Date());
        newUser.setLastLoginAt(new Date());
        newUser.setActive(true); // 初始为未激活状态，需通过验证码激活

        // 使用 BCrypt 加密密码
        String encodedPassword = passwordEncoder.encode(userDetails.getPassword());
        newUser.setPassword(encodedPassword); // 存储加密后的密码

        return userRepository.save(newUser);
    }

    // 验证密码是否匹配
    public boolean checkPassword(User user, String rawPassword) {
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }

    // 微信OpenID 注册/登录逻辑
    public User findOrCreateByWeChatOpenId(String openId, JSONObject userInfoJson) {
        User user = userRepository.findByWeChatOpenId(openId);
        if (user == null) {
            user = new User();
            user.setWeChatOpenId(openId);
            user.setNickname(userInfoJson.getString("nickname"));
            user.setAvatarUrl(userInfoJson.getString("headimgurl"));
            user.setRegisteredAt(new Date());
            user.setRegistrationSource("wechat"); // 设置注册来源
            user.setActive(false); // 默认未激活，需通过进一步验证激活
            userRepository.save(user);
        }
        // 更新最后登录时间
        user.setLastLoginAt(new Date());
        userRepository.save(user);
        return user;
    }

    // QQOpenID 注册/登录逻辑
    public User findOrCreateByQQOpenId(String openId, JSONObject userInfoJson) {
        User user = userRepository.findByQqOpenId(openId);
        if (user == null) {
            user = new User();
            user.setQqOpenId(openId);
            user.setNickname(userInfoJson.getString("nickname"));
            user.setAvatarUrl(userInfoJson.getString("figureurl_qq_1"));
            user.setRegisteredAt(new Date());
            user.setRegistrationSource("qq"); // 设置注册来源
            user.setActive(false); // 默认未激活，需通过进一步验证激活
            userRepository.save(user);
        }
        // 更新最后登录时间
        user.setLastLoginAt(new Date());
        userRepository.save(user);
        return user;
    }

    // 手机号注册/登录逻辑
    public User findOrCreateByPhoneNumber(String phoneNumber) {
        User user = userRepository.findByPhoneNumber(phoneNumber);
        if (user == null) {
            user = new User();
            user.setPhoneNumber(phoneNumber);
            user.setRegisteredAt(new Date());
            user.setRegistrationSource("phone");
            user.setActive(true);
            userRepository.save(user);
        }
        // 更新最后登录时间
        user.setLastLoginAt(new Date());
        userRepository.save(user);
        return user;
    }

    // 获取用户信息通过ID
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    // 获取用户信息通过手机号
    public User findByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber);
    }

    // 获取用户信息通过微信OpenID
    public User findByWeChatOpenId(String weChatOpenId) {
        return userRepository.findByWeChatOpenId(weChatOpenId);
    }

    // 获取用户信息通过QQOpenID
    public User findByQQOpenId(String qqOpenId) {
        return userRepository.findByQqOpenId(qqOpenId);
    }

    // 更新用户信息
    public User updateUser(String id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Update user information only if provided in userDetails
            if (userDetails.getNickname() != null) {
                user.setNickname(userDetails.getNickname());
            }
            if (userDetails.getAvatarUrl() != null) {
                user.setAvatarUrl(userDetails.getAvatarUrl());
            }
            if (userDetails.getPlatformRanking() != null) {
                user.setPlatformRanking(userDetails.getPlatformRanking());
            }
            if (userDetails.getActivityPoints() > 0) { // Ensure that activity points are valid
                user.setActivityPoints(userDetails.getActivityPoints());
            }
            // Handle isActive flag carefully (it could be explicitly set to false)
            user.setActive(userDetails.isActive());

            // Handle any other fields as necessary, ensuring null checks or validations
            if (userDetails.getPhoneNumber() != null && !userDetails.getPhoneNumber().isEmpty()) {
                user.setPhoneNumber(userDetails.getPhoneNumber());
            }
            if (userDetails.getWeChatOpenId() != null && !userDetails.getWeChatOpenId().isEmpty()) {
                user.setWeChatOpenId(userDetails.getWeChatOpenId());
            }
            if (userDetails.getQqOpenId() != null && !userDetails.getQqOpenId().isEmpty()) {
                user.setQqOpenId(userDetails.getQqOpenId());
            }

            // Update lastLoginAt if provided
            if (userDetails.getLastLoginAt() != null) {
                user.setLastLoginAt(userDetails.getLastLoginAt());
            }

            // Save the updated user
            return userRepository.save(user);
        } else {
            throw new RuntimeException("未找到用户id: " + id);
        }
    }


    // 删除用户
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
