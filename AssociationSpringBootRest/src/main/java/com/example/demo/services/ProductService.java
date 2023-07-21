package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo prepo;
	
	public List<Product> getall()
	{
		return prepo.findAll();
	}
	
	
}
