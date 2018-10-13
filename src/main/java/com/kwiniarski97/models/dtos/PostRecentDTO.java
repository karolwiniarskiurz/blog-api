package com.kwiniarski97.models.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Set;

public class PostRecentDTO {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String subtitle;
    @Getter
    @Setter
    private String mainImagePath;
    @Getter
    @Setter
    private String mainImageThumbnailPath;
    @Getter
    @Setter
    private String body;
    @Getter
    @Setter
    private Timestamp creationDate;
    @Getter
    @Setter
    private Timestamp publishDate;
    @Getter
    @Setter
    private long views;
    @Getter
    @Setter
    private long score;
    @Getter
    @Setter
    private AuthorDTO author;
    @Getter
    @Setter
    private Set<TagDTO> tags;
}
