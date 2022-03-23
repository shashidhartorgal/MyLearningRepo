package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{
	
	

}
