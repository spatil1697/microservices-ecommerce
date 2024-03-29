package com.ecommerce.orderservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;


@Entity
@Table(name = "T_Orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;


}
