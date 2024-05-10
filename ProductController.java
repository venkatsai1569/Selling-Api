package com.example.helloworld.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final Map<String, Product> productMap = new HashMap<>();

    // Create operation for products
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        productMap.put(product.getProdId(), product);
        return product;
    }

    // Read operation for products
    @GetMapping("/{prodId}")
    public Product getProduct(@PathVariable String prodId) {
        return productMap.get(prodId);
    }

    // Update operation for products
    @PutMapping("/{prodId}")
    public Product updateProduct(@PathVariable String prodId, @RequestBody Product product) {
        product.setProdId(prodId);
        productMap.put(prodId, product);
        return product;
    }

    // Delete operation for products
    @DeleteMapping("/{prodId}")
    public void deleteProduct(@PathVariable String prodId) {
        productMap.remove(prodId);
    }
}
