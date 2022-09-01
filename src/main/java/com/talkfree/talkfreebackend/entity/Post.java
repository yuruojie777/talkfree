package com.talkfree.talkfreebackend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "post")
public class Post {

    @Id
    private String Id;
    private String title;
    private String email;
    private String content;
    private String date;
    private List<String> likedBy;
    private List<String> sharedBy;
    private int status;
    private List<String> imageList;
    private List<Comment> comment;


    public Post(){

    }

    public Post(String id, String title, String email, String content, String date, List<String> likedBy, List<String> sharedBy, int status, List<String> imageList, List<Comment> comment) {
        Id = id;
        this.title = title;
        this.email = email;
        this.content = content;
        this.date = date;
        this.likedBy = likedBy;
        this.sharedBy = sharedBy;
        this.status = status;
        this.imageList = imageList;
        this.comment = comment;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(List<String> likedBy) {
        this.likedBy = likedBy;
    }

    public List<String> getSharedBy() {
        return sharedBy;
    }

    public void setSharedBy(List<String> sharedBy) {
        this.sharedBy = sharedBy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getImageList() {
        return imageList;
    }

    public void setImageList(List<String> imageList) {
        this.imageList = imageList;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Post{" +
                "Id='" + Id + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", likedBy=" + likedBy +
                ", sharedBy=" + sharedBy +
                ", status=" + status +
                ", imageList=" + imageList +
                ", comment=" + comment +
                '}';
    }
}
