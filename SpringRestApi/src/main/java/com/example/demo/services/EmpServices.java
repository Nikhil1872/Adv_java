package com.example.demo.services;

import java.util.List;
import java.util.Optional;

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
	
	public Emp getEmp(int empid)
	{
		Optional<Emp> oemp  = erepo.findById(empid);
		Emp e=null;
		try {
			e=oemp.get();
			
		}catch(Exception f)
		{
			f.printStackTrace();
		}
		
		return e;
		
		//return erepo.findById(empid).get();
	}
	
	public Emp saveEmp(Emp e)
	{
		return erepo.save(e);
	}
	
	public List<Emp> getEmps(int deptno)
	{
		return erepo.getEmpsFromDept(deptno);
		
	}
	
	public int updateSal(int empid,float sal)
	{
		return erepo.updateSal(empid, sal);
	}
	
	
	

}
