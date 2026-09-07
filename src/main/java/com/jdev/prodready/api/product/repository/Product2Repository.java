package com.jdev.prodready.api.product.repository;

import com.jdev.prodready.api.product.entity.Product2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product2Repository extends JpaRepository<Product2, Long> {

    List<Product2> findByCol1(String col1);
}
