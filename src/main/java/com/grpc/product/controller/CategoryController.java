package com.grpc.product.controller;

import com.grpc.product.entity.Category;
import com.grpc.product.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "category")
@RequiredArgsConstructor
public class CategoryController {
    private final Logger logger= LoggerFactory.getLogger(CategoryController.class);
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> add(@RequestBody Category category) {
        Category saveCategory=this.categoryService.add(category);
        logger.debug("REST request to save Category : {}", saveCategory);
        return new ResponseEntity<>(saveCategory, HttpStatus.CREATED);
    }
}
