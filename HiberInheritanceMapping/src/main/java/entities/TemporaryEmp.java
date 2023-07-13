package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="temp")
@PrimaryKeyJoinColumn(name="empid")
public class TemporaryEmp extends Emp {

	@Column
	float extraPay;
	
	@Column
	float taxes;
	
	

	public TemporaryEmp(int empid, String ename, String email, String contactNo, float basic,float extraPay, float taxes) {
		super(empid,ename,email,contactNo,basic);
		this.extraPay = extraPay;
		this.taxes = taxes;
	}



	public float getExtraPay() {
		return extraPay;
	}



	public void setExtraPay(float extraPay) {
		this.extraPay = extraPay;
	}



	public float getTaxes() {
		return taxes;
	}



	public void setTaxes(float taxes) {
		this.taxes = taxes;
	}
	
	
	
	
	
	
}
