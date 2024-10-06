package com.gbs.core.interfase;

import com.gbs.core.model.Guide;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideRepository extends MongoRepository<Guide, String> {
}
