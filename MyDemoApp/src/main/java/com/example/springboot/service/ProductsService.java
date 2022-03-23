package com.example.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Products;
import com.example.springboot.repository.ProductRepository;

@Service
public class ProductsService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	Products products;
	
	
	public List<Products> getAllProducts(){
		List<Products> prodList =new ArrayList<>();
		productRepository.findAll().forEach(prodList::add);
		return prodList;
	}
	
	public void addProduct(Products prod) {
		productRepository.save(prod);
		
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
