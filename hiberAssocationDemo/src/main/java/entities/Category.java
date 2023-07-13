package entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cid;
	@Column
	String cname;
	@Column
	String cdesc;
	
	@OneToMany(mappedBy = "cat")
	@Cascade(value=CascadeType.ALL)
    Set<Product> products;
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int cid, String cname, String cdesc) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cdesc = cdesc;
	}
	
	
	public Category(String cname,String cdesc ,Set<Product> products)
	{
		this.cname=cname;
		this.cdesc=cdesc;
		for(Product p : products)
		{
			p.setCat(this);
			this.products = products;
			
		}
	}
	
	
	public Category(int cat) {
		this.cid=cat;
		// TODO Auto-generated constructor stub
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	
	

}
