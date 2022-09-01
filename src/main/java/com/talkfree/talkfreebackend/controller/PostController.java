package com.talkfree.talkfreebackend.controller;

import com.talkfree.talkfreebackend.entity.Post;
import com.talkfree.talkfreebackend.service.PostService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/post")
@CrossOrigin
public class PostController {

    @Resource
    private PostService postService;

    @GetMapping
    public List<Post> getPostByUser(@RequestParam String userId){
        return postService.getPostsByUserEmail(userId);
    }

    @GetMapping("/all")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public int addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @DeleteMapping
    public int deletePost(@RequestParam String postId) {
        return postService.deletePost(postId);
    }

    @DeleteMapping("/all")
    public int deleteAllPost() {
        return postService.deleteAllPost();
    }
}
