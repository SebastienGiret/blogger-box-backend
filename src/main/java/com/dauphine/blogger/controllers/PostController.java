package com.dauphine.blogger.controllers;


import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {
    @PostMapping
    public String createPost(@RequestBody CreationPostRequest post) {
        return null;
    }
    @GetMapping
    public List<Post> getAllPosts() {
        return null;
    }
    @GetMapping("{id}")
    public Post getPostByCategory(@PathVariable UUID id) {
        return null;
    }
    @DeleteMapping("{id}")
    public void deletePost(@PathVariable UUID id) {
    }
    @PutMapping("{id}")
    public void updatePost(@PathVariable UUID id) {
    }
}
