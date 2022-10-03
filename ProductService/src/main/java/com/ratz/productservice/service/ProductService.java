package com.ratz.productservice.service;

import com.ratz.productservice.dto.ProductRequestDTO;
import com.ratz.productservice.dto.ProductResponseDTO;

public interface ProductService {
    long addProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO getProductById(Long id);
}
