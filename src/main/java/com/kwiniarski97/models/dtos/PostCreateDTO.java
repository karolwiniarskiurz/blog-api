package com.kwiniarski97.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class PostCreateDTO {
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
    public long authorId;
    @Getter
    @Setter
    public Set<TagDTO> tags;

}
