package com.dauphine.blogger.controllers;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category createCategory(@RequestBody String name) {
        return service.create(name);
    }
    @GetMapping
    public List<Category> retrieveAllCategories() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public Category retrieveCategoryById(@PathVariable UUID id) {
        return service.getById(id);
    }


    @PutMapping("{id}")
    public Category updateName(@PathVariable UUID id, @RequestBody String name) {
        return service.updateName(id,name);
    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable UUID id) {
        service.deleteById(id);
    }



}
