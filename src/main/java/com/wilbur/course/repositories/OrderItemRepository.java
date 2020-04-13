package com.wilbur.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilbur.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
