package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int pid;
	
	@Column
	String name;
	
	@Column
	float price;
	
	@ManyToOne
	@JoinColumn(name="cid")
	//PROPERTY Mapped with FK
	//datatatype master entity
	
	Category cat;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int pid, String name, float price, int cat) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.cat = new Category(cat);
	}

	public Product(String name ,float price)
	{
		super();
		this.name=name;
		this.price=price;
		
	}
	
	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Category getCat() {
		return cat;
	}


	public void setCat(Category cat) {
		this.cat = cat;
	}
	
	
	
	

}
