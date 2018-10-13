package com.kwiniarski97.models.dtos;

import com.kwiniarski97.models.domain.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

public class PostCreateDTO {
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
    private long authorId;

    @Getter
    @Setter
    private Set<TagDTO> tags;

}
