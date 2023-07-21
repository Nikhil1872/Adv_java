package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
public class CategoryController {
	@Autowired
   CategoryService cserv;
   
	@GetMapping("/getallcat")
	public List<Category> getall()
	{
		return cserv.getall();
	
	}
	
	@PostMapping("/savedata")
	public Category saveData(@RequestBody Category c) {
		return cserv.savecat(c);
	}
	
	@GetMapping("/getonecat")
	public Category savecat(@RequestBody Category cat)
	{
		return cserv.savecat(cat);
	}
	
	
	
   

}
