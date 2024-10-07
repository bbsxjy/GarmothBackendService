package com.gbs.core.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Document(collection = "forbiden_words")
public class ForbiddenWord {
    @Id
    private ObjectId id;

    @Field("T_BASE_SENSITIVEWORDS_ID")
    private int sensitiveWordsId;

    @Field("SENSITIVETYPE")
    private String sensitiveType;

    @Field("SENSITIVEWORDS")
    private String sensitiveWords;
}

