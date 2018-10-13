package com.kwiniarski97.models.domain;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String subtitle;
    private String mainImagePath;
    private String mainImageThumbnailPath;
    @Column(columnDefinition="TEXT")
    private String body;
    private Timestamp creationDate;
    private Timestamp publishDate;
    private long views;
    private long score;
    private boolean deleted;
    private long authorId;

    @ManyToOne
    @JoinColumn(name = "authorId", nullable = false, insertable=false, updatable=false)
    private Author author;

    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = { @JoinColumn(name = "post_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    Set<Tag> tags;

    public Post() {
    }

    public Post(long id, String title, String subtitle, String mainImagePath, String mainImageThumbnailPath, String body, Timestamp creationDate, Timestamp publishDate, long views, long score, long authorId) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.mainImagePath = mainImagePath;
        this.mainImageThumbnailPath = mainImageThumbnailPath;
        this.body = body;
        this.creationDate = creationDate;
        this.publishDate = publishDate;
        this.views = views;
        this.score = score;
        this.authorId = authorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }


    public String getMainImagePath() {
        return mainImagePath;
    }

    public void setMainImagePath(String mainImagePath) {
        this.mainImagePath = mainImagePath;
    }


    public String getMainImageThumbnailPath() {
        return mainImageThumbnailPath;
    }

    public void setMainImageThumbnailPath(String mainImageThumbnailPath) {
        this.mainImageThumbnailPath = mainImageThumbnailPath;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public java.sql.Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.sql.Timestamp creationDate) {
        this.creationDate = creationDate;
    }


    public java.sql.Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(java.sql.Timestamp publishDate) {
        this.publishDate = publishDate;
    }


    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }


    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }


    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
