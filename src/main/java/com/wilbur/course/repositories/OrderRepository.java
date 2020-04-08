package com.wilbur.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilbur.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
