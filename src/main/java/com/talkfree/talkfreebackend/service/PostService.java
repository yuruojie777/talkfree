package com.talkfree.talkfreebackend.service;

import com.talkfree.talkfreebackend.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PostService {

    List<Post> getPostsByUserEmail(String email);
    List<Post> getAllPosts();
    int addPost(Post post);
    int deletePost(String postId);
    int deleteAllPost();
}
