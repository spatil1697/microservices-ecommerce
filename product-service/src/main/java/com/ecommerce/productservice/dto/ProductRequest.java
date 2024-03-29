package com.ecommerce.productservice.dto;

import lombok.*;

import java.math.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;

}
