package com.kwiniarski97;

import com.kwiniarski97.models.domain.Author;
import com.kwiniarski97.models.domain.Post;
import com.kwiniarski97.models.domain.Tag;
import com.kwiniarski97.models.dtos.*;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean(autowire = Autowire.BY_TYPE, name = "Mapper")
    public DozerBeanMapper MapperConfig() {
        var d = new DozerBeanMapper();
        d.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(PostCreateDTO.class, Post.class);
                mapping(AuthorCreateDTO.class, Author.class);
                mapping(PostRecentDTO.class, Post.class);
                mapping(Author.class, AuthorDTO.class);
                mapping(Tag.class, TagDTO.class);
                mapping(PostDetailDTO.class, Post.class);
            }
        });
        return d;
    }
}
