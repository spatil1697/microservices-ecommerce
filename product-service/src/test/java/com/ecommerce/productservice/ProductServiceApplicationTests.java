package com.ecommerce.productservice;

import com.ecommerce.discoveryserver.productservice.dto.*;
import com.ecommerce.discoveryserver.productservice.repository.*;
import com.ecommerce.productservice.dto.*;
import com.ecommerce.productservice.repository.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.testcontainers.containers.MongoDBContainer;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.junit.jupiter.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.testcontainers.junit.jupiter.Container;


import java.math.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer( "mongo:4.4.2");
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private ProductRepository productRepository;


	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateProduct() throws Exception {
		ProductRequest productRequest = getProductRequest();
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String productRequestString = objectWriter.writeValueAsString(productRequest);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
	           .contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, productRepository.findAll().size());

	}
	@Test
	void shouldGetProduct() throws Exception{

		ProductRequest productRequest = getProductRequest();

		mockMvc.perform(MockMvcRequestBuilders.get("/api/product")
						.contentType(MediaType.APPLICATION_JSON)
						.content(String.valueOf(getProductRequest())))
						.andExpect(status().isOk());
	}
	private ProductRequest getProductRequest(){
		return ProductRequest.builder()
				.name("iphone 13")
				.description("iPhone 13")
				.price(BigDecimal.valueOf(1200))
				.build();
	}
}
