package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="emp")
@Inheritance(strategy = InheritanceType.JOINED)
public class Emp {
	@Id
	int empid;
	@Column
	String ename;
	@Column
	String email;
	@Column
	String contactNo;
	@Column
	float basic;
	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Emp(int empid, String ename, String email, String contactNo, float basic) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.email = email;
		this.contactNo = contactNo;
		this.basic = basic;
	}
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public float getBasic() {
		return basic;
	}
	public void setBasic(float basic) {
		this.basic = basic;
	}
	
	
	
	
	
	
	
	

}
