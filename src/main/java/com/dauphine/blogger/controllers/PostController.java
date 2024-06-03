package com.dauphine.blogger.controllers;


import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {this.service = service;}

    @PostMapping
    public Post createPost(@RequestBody String title, String content, Category category) {
        return service.create(title,content,category);
    }
    @GetMapping("{id}")
    public List<Post> getAllByCategoryId(@PathVariable UUID id) {
        return service.getAllByCategoryId(id);
    }

    @GetMapping("{id}")
    public Post getPostByCategory(@PathVariable UUID id) {
        return service.getById(id);
    }
    @DeleteMapping("{id}")
    public boolean deletePost(@PathVariable UUID id) {
        return service.deleteById(id);
    }
    @PutMapping("{id}")
    public Post updatePost(@PathVariable UUID id,@RequestParam String title, @RequestParam String content) {
        return service.update(id,title,content);
    }
}
