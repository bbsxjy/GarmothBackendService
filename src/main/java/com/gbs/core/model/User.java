package com.gbs.core.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String phoneNumber;   // 手机号

    @Indexed(unique = true)
    private String weChatOpenId;  // 微信 OpenID

    @Indexed(unique = true)
    private String qqOpenId;      // QQ OpenID

    private String nickname;      // 用户昵称

    private String avatarUrl;     // 头像 URL

    private String userName;      // 加密后的密码

    private String password;      // 加密后的密码

    private Date registeredAt;    // 注册时间

    private Date lastLoginAt;     // 最后登录时间

    private long activityPoints;  // 活动积分

    private String platformRanking; // 头衔

    private boolean isActive;       // 是否激活

    private String registrationSource; // 注册来源（如 "phone", "wechat", "qq"）

    private String[] roles;        // 用户角色 (如 "USER", "ADMIN")

    private boolean isVerified;    // 手机号是否已验证

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", weChatOpenId='" + weChatOpenId + '\'' +
                ", qqOpenId='" + qqOpenId + '\'' +
                ", nickname='" + nickname + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + "[PROTECTED]" + '\'' + // Do not print sensitive data like passwords
                ", registeredAt=" + registeredAt +
                ", lastLoginAt=" + lastLoginAt +
                ", activityPoints=" + activityPoints +
                ", platformRanking='" + platformRanking + '\'' +
                ", isActive=" + isActive +
                ", registrationSource='" + registrationSource + '\'' +
                ", roles=" + (roles != null ? String.join(", ", roles) : "[]") +
                ", isVerified=" + isVerified +
                '}';
    }
}


