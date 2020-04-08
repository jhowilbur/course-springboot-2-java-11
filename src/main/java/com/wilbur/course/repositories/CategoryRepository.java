package com.wilbur.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilbur.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
