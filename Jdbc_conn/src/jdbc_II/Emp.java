package jdbc_II;

import java.util.Objects;

public class Emp implements Comparable<Emp>{
	
	private int eid;
	 private String ename;
	 private int deptno;
	 private float sal;
	 
	 

		public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}



		public Emp(int eid, String ename, int deptno, float sal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.deptno = deptno;
		this.sal = sal;
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



		public int getDeptno() {
			return deptno;
		}



		public void setDeptno(int deptno) {
			this.deptno = deptno;
		}



		public float getSal() {
			return sal;
		}



		public void setSal(float sal) {
			this.sal = sal;
		}
		
		


		@Override
		public String toString() {
			return "Emp [eid=" + eid + ", ename=" + ename + ", deptno=" + deptno + ", sal=" + sal + "]";
		}



		@Override
		public int hashCode() {
			return deptno;
		}



		public boolean equals(Emp obj) {
			if (this.deptno == obj.deptno)
				return true;
			else
				return false;
		}



		@Override
		public int compareTo(Emp o) {
			// TODO Auto-generated method stub
			return this.ename.compareToIgnoreCase(o.ename);
				
		}
		



	   
		
	  
		
}



