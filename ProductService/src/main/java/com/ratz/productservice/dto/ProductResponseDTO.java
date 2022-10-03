package com.ratz.productservice.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProductResponseDTO {

    private long productId;
    private long price;
    private long quantity;
    private String productName;
}
