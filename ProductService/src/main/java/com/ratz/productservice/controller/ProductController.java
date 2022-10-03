package com.ratz.productservice.controller;

import com.ratz.productservice.dto.ProductRequestDTO;
import com.ratz.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequestDTO productRequestDTO){

        long productId = productService.addProduct(productRequestDTO);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }
}
