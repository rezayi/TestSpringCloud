package com.mrezaei.admin.product.controllers;

import com.mrezaei.admin.product.dao.CategoryRepository;
import com.mrezaei.admin.product.to.CategoryEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryManagementController {
    private final CategoryRepository categoryRepository;

    public CategoryManagementController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryEntity>> getCategoriesList() {
        List<CategoryEntity> categoryEntities = new ArrayList<>();
        categoryRepository.findAll().forEach(categoryEntities::add);
        return ResponseEntity.status(HttpStatus.OK).body(categoryEntities);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable("categoryId") int categoryId) {
        var optionalCategoryEntity = categoryRepository.findById(categoryId);
        return optionalCategoryEntity
                .map(categoryEntity -> ResponseEntity.status(HttpStatus.OK).body(categoryEntity))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addCategory(@RequestBody CategoryEntity categoryEntity) {
        categoryRepository.save(categoryEntity);
        return ResponseEntity.status(HttpStatus.OK).body(categoryEntity.getId());
    }

    @PutMapping("{categoryId}")
    public ResponseEntity<Integer> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody CategoryEntity categoryEntity) {
        categoryRepository.findById(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(categoryEntity.getId());
    }

    @DeleteMapping("{categoryId}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("categoryId") int categoryId) {
        categoryRepository.deleteById(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
