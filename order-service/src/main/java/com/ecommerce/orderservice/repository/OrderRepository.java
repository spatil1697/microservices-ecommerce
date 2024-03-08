package com.ecommerce.orderservice.repository;

import com.ecommerce.discoveryserver.orderService.model.*;
import com.ecommerce.orderservice.model.*;
import org.springframework.data.jpa.repository.*;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
