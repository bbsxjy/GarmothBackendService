package com.gbs.core.datastore;

import com.gbs.core.model.ForbiddenWord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForbiddenWordRepository extends MongoRepository<ForbiddenWord, String> {
    // No need for additional methods, basic CRUD is sufficient
}
