package com.gbs.core.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "guides")
public class Guide {
    @Id
    private String _id;
    private String id;
    private String name;
    private int fk_user;
    private int fk_category;
    private String title;
    private String desc;
    private String text;
    private int likes;
    private int views;
    private String img;
    private String avatar;
    private String published_at;
    private String modified_at;
    private boolean listing;
}
