package com.kwiniarski97.models.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String passwordHash;
    private String passwordSalt;
    private String email;
    private String avatarPath;
    private String description;
    private Role role;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts;

    public Author() {
    }

    public Author(long id, String firstName, String lastName, String nickName, String passwordHash, String passwordSalt, String email, String imagePath, String description) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.email = email;
        this.avatarPath = imagePath;
        this.description = description;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
