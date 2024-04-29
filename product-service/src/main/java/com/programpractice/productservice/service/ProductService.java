package com.programpractice.productservice.service;

import com.programpractice.productservice.dto.ProductRequest;
import com.programpractice.productservice.dto.ProductResponse;
import com.programpractice.productservice.model.Product;
import com.programpractice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public ProductResponse getProductById(String id) {
        Product product =  productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Not able to find the product with id: %s")
        );
        return  ProductResponse.builder().id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
    public List<ProductResponse> getAllProducts() {
        return  productRepository.findAll().stream().map(this::mapProduct)
                .collect(Collectors.toList());
    }

    private ProductResponse mapProduct(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice()).build();
    }
}
