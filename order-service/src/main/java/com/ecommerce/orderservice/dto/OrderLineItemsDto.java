package com.ecommerce.orderservice.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import java.math.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {
    @JsonIgnore
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
