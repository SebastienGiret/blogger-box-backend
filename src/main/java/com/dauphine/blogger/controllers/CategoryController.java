package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dto.CreationCategoryRequest;
import com.dauphine.blogger.exceptions.CategoryNameAlreadyExists;
import com.dauphine.blogger.exceptions.CategoryNotFoundByIdException;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(@RequestParam(required = false) String name) {
        final List<Category> categories = name == null || name.isBlank() ? service.getAll() : service.getAllByName(name);
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody CreationCategoryRequest request) throws CategoryNameAlreadyExists {
        final Category category = service.create(request.getName());
        return ResponseEntity.created(URI.create("v1/categories/" + category.getId())).body(category);
    }


    @GetMapping("{id}")
    public ResponseEntity<Category> retrieveCategoryById(@PathVariable UUID id) throws CategoryNotFoundByIdException {
            final Category category = service.getById(id);
            return ResponseEntity.ok(category);
    }


    @PutMapping("{id}")
    public ResponseEntity<Category> updateName(@PathVariable UUID id, @RequestBody String name) throws CategoryNotFoundByIdException, CategoryNameAlreadyExists {
        final Category category = service.updateName(id,name);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable UUID id) throws CategoryNotFoundByIdException{
        final boolean deletion = service.deleteById(id);
        return ResponseEntity.ok(deletion);
    }



}
