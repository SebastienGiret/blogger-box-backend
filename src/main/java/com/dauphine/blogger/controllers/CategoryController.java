package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationCategoryRequest;
import com.dauphine.blogger.models.Category;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final List<Category> temporaryCategories;

    public CategoryController() {
        temporaryCategories = new ArrayList<>();
        temporaryCategories.add(new Category(UUID.randomUUID(),"my first category"));
        temporaryCategories.add(new Category(UUID.randomUUID(),"my second category"));
        temporaryCategories.add(new Category(UUID.randomUUID(),"my third category"));
    }

    @PostMapping
    public String create(@RequestBody CreationCategoryRequest category) {
        return category.getName();
    }
    @GetMapping
    public List<Category> getAll() {
        return temporaryCategories;
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable UUID id) {
        return null;
    }


    @PutMapping("{id}")
    public String update(@PathVariable UUID id) {
        return null;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable UUID id) {
        return false;
    }



}
