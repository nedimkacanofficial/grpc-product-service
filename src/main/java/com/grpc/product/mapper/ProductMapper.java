package com.grpc.product.mapper;

import com.grpc.product.dto.ProductDTO;
import com.grpc.product.entity.Category;
import com.grpc.product.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static Product toEntity(ProductDTO productDTO, Category category) {
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        return product;
    }
    public static ProductDTO toDTO(Product product) {
        ProductDTO productDTO=new ProductDTO();
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategoryId(product.getCategory().getId());
        return productDTO;
    }
    public static List<ProductDTO> toDTOList(List<Product> productList) {
        return productList.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }
}
