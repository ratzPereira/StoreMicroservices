package com.ratz.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
public class ProductRequestDTO {


    private long price;
    private long quantity;
    private String productName;
}
