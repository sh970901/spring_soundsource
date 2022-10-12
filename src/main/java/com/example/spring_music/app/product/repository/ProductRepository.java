package com.example.spring_music.app.product.repository;

import com.example.spring_music.app.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
