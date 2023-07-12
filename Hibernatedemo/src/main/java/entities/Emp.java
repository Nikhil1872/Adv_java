package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="emp")
@NamedQuery(name="getbysal",query="select eid,ename from Emp where salary between :min and :max" )
@NamedQuery(name="getbydept",query="select eid,ename,salary from Emp where dept=:dept" )
public class Emp {

	@Id  //id should be only given to primary key
	@Column(name="eid")
	private int eid;
	
	 
	@Column  //not specifying name because table in sql has same  name as variable name
	private String ename;
	
	@Column
	private float salary;
	
	@Column
	private int dept;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int eid, String ename, float salary, int dept) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.dept = dept;
	}



	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}
	
	
	
	
	
	
	
}
