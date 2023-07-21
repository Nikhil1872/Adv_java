package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entities.Category;

import com.example.demo.repositories.CategoryRepo;


@Service
public class CategoryService {
	@Autowired
	CategoryRepo crepo;
	
	public List<Category> getall()
	{
		return crepo.findAll();
	}
	
	public Category savecat(Category c)
	{
		return crepo.save(c);
	}
	
	public Category getcat(int cid)
	{
		Optional<Category> op =crepo.findById(cid);
		//optional is wiriitten becouse if user send any unavailable category 
		//then he will get errors so avoid it we use optional which can take both null and specified return type  
		
		Category c = null;
		
		try {
			c=op.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	
	
	
	

}
