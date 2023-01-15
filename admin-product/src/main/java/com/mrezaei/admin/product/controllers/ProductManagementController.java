package com.mrezaei.admin.product.controllers;

import com.mrezaei.admin.product.dao.ProductRepository;
import com.mrezaei.admin.product.to.ProductEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class ProductManagementController {
    private final ProductRepository productRepository;

    public ProductManagementController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductEntity>> getProductsList() {
        List<ProductEntity> productEntities = new ArrayList<>();
        productRepository.findAll().forEach(productEntities::add);
        return ResponseEntity.status(HttpStatus.OK).body(productEntities);
    }

    @GetMapping("/category/{categoryId}/")
    public ResponseEntity<List<ProductEntity>> getProductsByCategoryList(@PathVariable("categoryId") int categoryId) {
        List<ProductEntity> productEntities = productRepository.findByCategoryId(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(productEntities);
    }

    @GetMapping("{productId}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable("productId") int productId) {
        var optionalProductEntity = productRepository.findById(productId);
        return optionalProductEntity
                .map(productEntity -> ResponseEntity.status(HttpStatus.OK).body(productEntity))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    @PostMapping("/")
    public ResponseEntity<Integer> addProduct(@RequestBody ProductEntity productEntity) {
        productRepository.save(productEntity);
        return ResponseEntity.status(HttpStatus.OK).body(productEntity.getId());
    }

    @PutMapping("{productId}")
    public ResponseEntity<Integer> updateUser(@PathVariable("productId") int productId, @RequestBody ProductEntity productEntity) {
        productRepository.findById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(productEntity.getId());
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("productId") int productId) {
        productRepository.deleteById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
