package com.techie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techie.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);
}
