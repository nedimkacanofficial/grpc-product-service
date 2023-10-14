package com.grpc.product.controller;

import com.grpc.product.dto.ProductDTO;
import com.grpc.product.entity.Product;
import com.grpc.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
@RequiredArgsConstructor
public class ProductController {
    private final Logger logger= LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductDTO> productList=this.productService.getAll();
        logger.debug("REST request to get all Posts");
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id) {
        ProductDTO productDTO=this.productService.getById(id);
        logger.debug("REST request to get Product Id {}",id);
        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<ProductDTO> add(@RequestBody ProductDTO productDTO) {
        ProductDTO productDTO1=this.productService.add(productDTO);
        logger.debug("REST request to save Product : {}", productDTO1);
        return new ResponseEntity<>(productDTO1,HttpStatus.CREATED);
    }
}
