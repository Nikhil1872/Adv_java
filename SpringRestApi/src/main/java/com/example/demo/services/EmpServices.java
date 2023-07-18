package com.example.demo.services;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Emp;
import com.example.demo.repositories.EmpRepository;

@Service
public class EmpServices {
	
	@Autowired
	EmpRepository erepo;
	
	
	public List<Emp> getAll(){
		return erepo.findAll();
	}
	
	public Emp saveEmp(Emp e)
	{
		return erepo.save(e);
	}
	
	public List<Emp> getEmps(int deptno)
	{
		return erepo.getEmpsFromDept(deptno);
		
	}
	

}
