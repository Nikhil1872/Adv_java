package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Emp;
import com.example.demo.services.EmpServices;

@RestController
//@CrossOrigin(origins="http://localhost:3000")
public class EmpControllers {
	@Autowired
	EmpServices eservice;
	
	@GetMapping("/getallemps")
	public List<Emp> getAll()
	{
		return eservice.getAll();
	}
	
	
	

}
