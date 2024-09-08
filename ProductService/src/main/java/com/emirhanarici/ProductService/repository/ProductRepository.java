package com.emirhanarici.ProductService.repository;

import com.emirhanarici.ProductService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
