package bean;

public class address1 {

	String area,city,pincode;
	
	
	public address1() {
		super();
		// TODO Auto-generated constructor stub
	}


	public address1(String area, String city, String pincode) {
		super();
		this.area = area;
		this.city = city;
		this.pincode = pincode;
	}


	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	

}
