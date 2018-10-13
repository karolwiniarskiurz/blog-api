package com.kwiniarski97.services;

import com.kwiniarski97.models.domain.Tag;
import com.kwiniarski97.models.dtos.TagDTO;
import com.kwiniarski97.repository.TagRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TagService {

    @Autowired
    TagRepository repository;

    @Autowired
    Mapper mapper;

    public List<TagDTO> getAvailable() {
        var tags = repository.findAll();
        return tags.stream().map(t -> mapper.map(t, TagDTO.class)).collect(Collectors.toList());
    }

    public long create(TagDTO tagDTO) {
        var tag = mapper.map(tagDTO, Tag.class);
        var entity = repository.save(tag);
        repository.flush();
        return entity.getId();
    }
}
