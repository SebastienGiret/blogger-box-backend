package com.dauphine.blogger.services;

import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.exceptions.PostNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllByCategoryId(UUID category_id) throws CategoryNotFoundByIdException;

    List<Post> getAllByTitleOrContent(String contentOrTitle) ;

    List<Post> getAll();

    Post getById(UUID id)  throws PostNotFoundByIdException;

    Post create(String title, String content, UUID category) throws CategoryNotFoundByIdException;

    Post update(UUID id, String title, String content) throws PostNotFoundByIdException;

    boolean deleteById(UUID id) throws PostNotFoundByIdException;
}
