package beans;

public class Dept {
	
	int deptid;
	String dname,location;
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(int deptid, String dname, String location) {
		super();
		this.deptid = deptid;
		this.dname = dname;
		this.location = location;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Dept [deptid=" + deptid + ", dname=" + dname + ", location=" + location + "]";
	}
	
	
	
	
	

}
