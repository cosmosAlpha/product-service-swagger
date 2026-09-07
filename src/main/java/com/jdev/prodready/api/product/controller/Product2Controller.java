package com.jdev.prodready.api.product.controller;

import com.jdev.prodready.api.product.entity.Product2;
import com.jdev.prodready.api.product.repository.Product2Repository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products2")
public class Product2Controller {

    private final Product2Repository product2Repository;

    public Product2Controller(Product2Repository product2Repository) {
        this.product2Repository = product2Repository;
    }

    @GetMapping
    private List<Product2> getAll() {
        return product2Repository.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    private Product2 addProduct(@RequestBody Product2 product) {
        return product2Repository.save(product);
    }
}
