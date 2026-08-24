package com.jdev.prodready.product_service.controller;

import com.jdev.prodready.product_service.entity.Product;
import com.jdev.prodready.product_service.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    private List<Product> getAll(){
        return productRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    private Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
}
