package com.kwiniarski97.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

public class PostRecentDTO {
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
    public String mainImageThumbnailPath;
    @Getter
    @Setter
    public Timestamp publishDate;
    @Getter
    @Setter
    public long score;
    @Getter
    @Setter
    public AuthorDTO author;
}
