package com.ecommerce.orderservice.dto;


import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
