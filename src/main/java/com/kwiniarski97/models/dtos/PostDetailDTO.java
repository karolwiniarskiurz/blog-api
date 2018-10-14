package com.kwiniarski97.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

public class PostDetailDTO {
    @Getter
    @Setter
    public long id;
    @Getter
    @Setter
    public String title;
    @Getter
    @Setter
    public String subtitle;
    @Getter
    @Setter
    public String mainImagePath;
    @Getter
    @Setter
    public String mainImageThumbnailPath;
    @Getter
    @Setter
    public String body;
    @Getter
    @Setter
    public Timestamp creationDate;
    @Getter
    @Setter
    public Timestamp publishDate;
    @Getter
    @Setter
    public long views;
    @Getter
    @Setter
    public long score;
    @Getter
    @Setter
    public AuthorDTO author;
    @Getter
    @Setter
    public Set<TagDTO> tags;
}
