package com.jdev.prodready.api.product.repository;

import com.jdev.prodready.api.product.entity.Product1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product1Repository extends JpaRepository<Product1, Long> {

    List<Product1> findByCol1(String col1);
}
