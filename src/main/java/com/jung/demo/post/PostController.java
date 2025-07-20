package com.jung.demo.post;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jung.demo.post.dtos.PostDTO;

@RestController
public class PostController {
    private final PostService postService;
    @Autowired
    ModelMapper modelMapper;

    public PostController(PostService postService){
        this.postService = postService;

    }
    @GetMapping("posts")
    public ResponseEntity<List<Post>> findAll(){
        return new ResponseEntity<>(postService.findAll(),HttpStatus.OK);
        
    }
    @GetMapping("/")
    public List<PostDTO> findAllDto(){
        List<Post> posts= postService.findAll();
        return posts.stream().map(p -> modelMapper.map(p, PostDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("postComments")
    public List<PostComment> findAllPostComments(){
        return postService.findAllPostComments();
    }
}
