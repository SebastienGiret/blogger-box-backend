package com.dauphine.blogger.services.impl;

import com.dauphine.blogger.dto.CreationPostRequest;
import com.dauphine.blogger.exceptions.CategoryNameAlreadyExists;
import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.exceptions.PostNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.repositories.PostRepository;
import com.dauphine.blogger.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final CategoryRepository categoryRepository;

    public PostServiceImpl(PostRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Post> getAllByCategoryId(UUID category_id) throws CategoryNotFoundByIdException{
        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new CategoryNotFoundByIdException(category_id));
        return repository.findAllByCategoryId(category_id);

    }
    @Override
    public List<Post> getAll(){
        return repository.findAll();
    }

    @Override
    public List<Post> getAllByTitleOrContent(String contentOrTitle){
        return repository.findAllByTitleOrContent(contentOrTitle);
    }

    @Override
    public Post getById(UUID id) throws PostNotFoundByIdException{
        return repository.findById(id).orElseThrow(() -> new PostNotFoundByIdException(id));
    }
    @Override
    public Post create(String title, String content, UUID category_id) throws CategoryNotFoundByIdException {
        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new CategoryNotFoundByIdException(category_id));
        Post post = new Post(title, content, category);
        return repository.save(post);
    }
    @Override
    public Post update(UUID id, String title, String content) throws PostNotFoundByIdException{
        Post post = getById(id);

        post.setTitle(title);
        post.setContent(content);
        return repository.save(post);
    }
    @Override
    public boolean deleteById(UUID id) throws PostNotFoundByIdException {
        boolean exists = repository.existsById(id);
        if (exists) {
            repository.deleteById(id);
            return true;
        } else {
            throw new PostNotFoundByIdException(id);
        }

    }
}
