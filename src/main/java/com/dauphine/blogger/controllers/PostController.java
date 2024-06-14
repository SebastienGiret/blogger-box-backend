package com.dauphine.blogger.controllers;


import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {this.service = service;}

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody CreationPostRequest postRequest) {
        final Post post = service.create(postRequest.getTitle(),postRequest.getContent(),postRequest.getCategory_id());
        return ResponseEntity.created(URI.create("v1/posts/" + post.getCategory_id())).body(post);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAll(@RequestParam(required = false) String contentOrTitle) {
        final List<Post> posts = (contentOrTitle == null) ? service.getAll() : service.getAllByTitleOrContent(contentOrTitle);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Post>> getPostByCategory(@PathVariable UUID id) {
        try {
            final List<Post> posts = service.getAllByCategoryId(id);
            return ResponseEntity.ok(posts);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable UUID id) {
        final Boolean deletion = service.deleteById(id);
        return ResponseEntity.ok(deletion);
    }
    @PutMapping("{id}")
    public ResponseEntity<Post> updatePost(@PathVariable UUID id,@RequestBody CreationPostRequest postRequest) {
        final Post post = service.update(id, postRequest.getTitle(), postRequest.getContent());
        return ResponseEntity.ok(post);
    }
}
