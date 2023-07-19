package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/saveemp")
	public Emp save(@RequestBody Emp e)
	{
		return eservice.saveEmp(e);
				
	}
	
	//key-value
	@GetMapping("/getemp")
	public Emp getOneEmp(@PathVariable("eid") int empid)
	{
	
		return eservice.getEmp(empid);
	}
	
	@GetMapping("/getempsbydept")
	public List<Emp> getEmpsBydept(int deptno)
	{
		return eservice.getEmps(deptno);
	}
	
	@GetMapping("/updateSal")
	public int updatesal(@RequestParam int empid,@RequestParam("sal") float sal)
	//pls note that if 
	{
		return eservice.updateSal(empid, sal);
	}
	

}
