package com.ratz.productservice.service.impl;

import com.ratz.productservice.dto.ProductRequestDTO;
import com.ratz.productservice.dto.ProductResponseDTO;
import com.ratz.productservice.exception.ProductServiceCustomException;
import com.ratz.productservice.model.Product;
import com.ratz.productservice.repository.ProductRepository;
import com.ratz.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequestDTO productRequestDTO) {

        log.info("Adding product..");

        Product product = Product.builder()
                .productName(productRequestDTO.getProductName())
                .price(productRequestDTO.getPrice())
                .quantity(productRequestDTO.getQuantity())
                .build();

        productRepository.save(product);
        log.info("Product created and saved!");
        return product.getProductId();
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {

        log.info("Get product by id {}" , id);

        Product product = productRepository.findById(id)
                .orElseThrow( () -> new ProductServiceCustomException("Product not found", "PRODUCT_NOT_FOUND"));

        return ProductResponseDTO.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productId(product.getProductId())
                .build();
    }
}
