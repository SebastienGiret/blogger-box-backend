package com.dauphine.blogger.services.impl;


import com.dauphine.blogger.exceptions.CategoryNameAlreadyExists;
import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.repositories.CategoryRepository;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }


    @Override
    public Category create(String name) throws CategoryNameAlreadyExists {
        final boolean alreadyExists = repository.existsByName(name);
        if (alreadyExists) {
            throw new CategoryNameAlreadyExists(name);
        } else {
            Category category = new Category(name);
            return repository.save(category);
        }
    }
    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Category> getAllByName(String name){
        return repository.findAllByName(name);
    }

    @Override
    public Category getById(UUID id) throws CategoryNotFoundByIdException {
        return repository.findById(id).orElseThrow(() ->new CategoryNotFoundByIdException(id));
    }

    @Override
    public Category updateName(UUID id, String name) throws CategoryNotFoundByIdException, CategoryNameAlreadyExists {
        final boolean alreadyExists = repository.existsByName(name);

        Category category = getById(id);
        if (alreadyExists) {
            throw new CategoryNameAlreadyExists(name);
        }
        category.setName(name);
        return repository.save(category);
    }

    @Override
    public boolean deleteById(UUID id) throws CategoryNotFoundByIdException {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            throw new CategoryNotFoundByIdException(id);
        }

    }
}
