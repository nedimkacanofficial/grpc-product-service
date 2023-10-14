package com.grpc.product.service;

import com.grpc.product.dto.ProductDTO;
import com.grpc.product.entity.Category;
import com.grpc.product.entity.Product;
import com.grpc.product.exception.ProductNotFoundException;
import com.grpc.product.mapper.ProductMapper;
import com.grpc.product.repository.CategoryRepository;
import com.grpc.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final Logger logger= LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Transactional(readOnly = true)
    public List<ProductDTO> getAll() {
        logger.debug("Request to get all Product");
        List<Product> productList=this.productRepository.findAll();
        return ProductMapper.toDTOList(productList);
    }
    @Transactional(readOnly = true)
    public ProductDTO getById(Long id) {
        logger.debug("Request to get one Customer productId: {}",id);
        Product product=this.productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Path Id: " + id.toString()));
        return ProductMapper.toDTO(product);
    }
    public ProductDTO add(ProductDTO productDTO) {
        logger.debug("Request to save Product : {}", productDTO);
        Category category=this.categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(()->new ProductNotFoundException("Category Id: " + productDTO.getCategoryId().toString()));
        Product product=ProductMapper.toEntity(productDTO,category);
        Product saveProduct=this.productRepository.save(product);
        return ProductMapper.toDTO(saveProduct);
    }
}
