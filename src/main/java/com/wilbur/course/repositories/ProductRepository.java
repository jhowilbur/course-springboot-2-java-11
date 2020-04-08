package com.wilbur.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilbur.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
