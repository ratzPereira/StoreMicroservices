package com.ratz.productservice.controller;

import com.ratz.productservice.dto.ProductRequestDTO;
import com.ratz.productservice.dto.ProductResponseDTO;
import com.ratz.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id){

        ProductResponseDTO productResponseDTO = productService.getProductById(id);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
    }
}
