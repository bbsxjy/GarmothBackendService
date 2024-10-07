package com.gbs.core.datastore;

import com.gbs.core.model.Guide;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuideRepository extends MongoRepository<Guide, String> {
    Optional<Guide> findByTitle(String title);
}
