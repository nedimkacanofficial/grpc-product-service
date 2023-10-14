package com.grpc.product.service;

import com.grpc.product.entity.Category;
import com.grpc.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final Logger logger= LoggerFactory.getLogger(CategoryService.class);
    private final CategoryRepository categoryRepository;
    public Category add (Category category) {
        logger.debug("Request to get all Category");
        return this.categoryRepository.save(category);
    }
}
