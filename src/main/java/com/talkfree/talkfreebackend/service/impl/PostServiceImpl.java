package com.talkfree.talkfreebackend.service.impl;

import com.talkfree.talkfreebackend.entity.Post;
import com.talkfree.talkfreebackend.repository.PostRepository;
import com.talkfree.talkfreebackend.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostRepository postRepository;

    @Override
    public List<Post> getPostsByUserEmail(String email) {

        return postRepository.findPostsByUserEmail(email);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public int addPost(Post post) {
        if(postRepository.save(post) != null) return 1;
        return 0;
    }

    @Override
    public int deletePost(String postId) {
        if(postRepository.deletePostById(postId) != null) return 1;
        return 0;
    }

    @Override
    public int deleteAllPost() {
        try{
            postRepository.deleteAll();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
