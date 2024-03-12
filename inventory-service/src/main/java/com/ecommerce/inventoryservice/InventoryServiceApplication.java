package com.ecommerce.inventoryservice;

import com.ecommerce.inventoryservice.model.*;
import com.ecommerce.inventoryservice.repository.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.*;
import org.springframework.context.annotation.*;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);}

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
       return args -> {
           Inventory inventory = new Inventory();
           inventory.setSkuCode("iphone_13");
           inventory.setQuantity(50);

           Inventory inventory1 = new Inventory();
           inventory1.setSkuCode("iphone_13_black");
           inventory1.setQuantity(0);

           inventoryRepository.save(inventory);
           inventoryRepository.save(inventory1);
       };
    }

}
