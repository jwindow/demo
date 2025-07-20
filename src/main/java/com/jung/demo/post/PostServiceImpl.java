package com.jung.demo.post;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    
    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    public PostServiceImpl(PostRepository postRepository, PostCommentRepository postCommentRepository){
        this.postRepository = postRepository;
        this.postCommentRepository = postCommentRepository;
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public List<PostComment> findAllPostComments() {
        return postCommentRepository.findAll();
    }

    
}
