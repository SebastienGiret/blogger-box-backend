package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllByCategoryId(UUID category_id);

    List<Post> getAll();

    Post getById(UUID id);

    Post create(String title, String content, UUID category_id);

    Post update(UUID id, String title, String content);

    boolean deleteById(UUID id);
}