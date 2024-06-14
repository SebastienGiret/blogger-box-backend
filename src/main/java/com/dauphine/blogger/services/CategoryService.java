package com.dauphine.blogger.services;

import com.dauphine.blogger.exceptions.CategoryNameAlreadyExists;
import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.models.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll();

    List<Category> getAllByName(String name);

    Category getById(UUID id) throws CategoryNotFoundByIdException;

    Category create(String name) throws CategoryNameAlreadyExists;

    Category updateName(UUID id, String name) throws CategoryNotFoundByIdException, CategoryNameAlreadyExists;

    boolean deleteById(UUID id) throws CategoryNotFoundByIdException;
}
