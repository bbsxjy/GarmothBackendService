package com.gbs.core.datastore;

import com.gbs.core.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByWeChatOpenId(String weChatOpenId);
    User findByQqOpenId(String qqOpenId);
    User findByPhoneNumber(String phoneNumber);
    User findByUserName(String userName);
}
