package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Emp;

@Repository
@Transactional
public interface EmpRepository extends JpaRepository<Emp, Integer> {
	
	@Query("select e from Emp e where e.deptno=:dno")
	public List<Emp> getEmpsFromDept(int dno);
	
	
	

}
