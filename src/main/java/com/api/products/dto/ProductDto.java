package com.api.products.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ProductDto {
    private Long id;
    private String name;
    private String category;
    private int quantity;
    private Boolean status;

}

  
