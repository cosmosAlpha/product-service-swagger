package com.jdev.prodready.api.product.controller;

import com.jdev.prodready.api.product.entity.Product1;
import com.jdev.prodready.api.product.repository.Product1Repository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products1")
public class Product1Controller {

    private final Product1Repository product1Repository;

    public Product1Controller(Product1Repository product1Repository) {
        this.product1Repository = product1Repository;
    }

    @GetMapping
    private List<Product1> getAll() {
        return product1Repository.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    private Product1 addProduct(@RequestBody Product1 product) {
        return product1Repository.save(product);
    }
}
