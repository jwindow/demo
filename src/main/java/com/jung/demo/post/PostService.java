package com.jung.demo.post;

import java.util.List;

public interface PostService {

    public List<Post> findAll();

    public List<PostComment> findAllPostComments();
    
}
