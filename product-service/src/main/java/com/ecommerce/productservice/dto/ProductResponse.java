package com.ecommerce.productservice.dto;


import lombok.*;

import java.math.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
