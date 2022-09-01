package com.talkfree.talkfreebackend.entity;

import java.sql.Date;

public class Comment {

    private String postId;
    private String content;
    private Date date;
    private String userId;

    public Comment() {
    }

    public Comment(String postId, String content, Date date, String userId) {
        this.postId = postId;
        this.content = content;
        this.date = date;
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "postId='" + postId + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", userId='" + userId + '\'' +
                '}';
    }
}
