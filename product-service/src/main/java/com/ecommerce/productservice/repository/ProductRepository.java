package com.ecommerce.productservice.repository;


import com.ecommerce.productservice.model.*;
import org.springframework.data.mongodb.repository.*;

public interface ProductRepository extends MongoRepository<Product, String> {
}
