package com.kwiniarski97.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Post> posts;

    public Tag() {
    }

    public Tag(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
