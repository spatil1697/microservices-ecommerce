package com.ecommerce.inventoryservice.repository;

import com.ecommerce.discoveryserver.inventoryservice.model.*;
import com.ecommerce.inventoryservice.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
