package com.jdev.prodready.api.product.repository;

import com.jdev.prodready.api.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
