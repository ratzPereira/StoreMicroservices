package com.ratz.productservice.service;

import com.ratz.productservice.dto.ProductRequestDTO;

public interface ProductService {
    long addProduct(ProductRequestDTO productRequestDTO);
}
