package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import model.Contact;

@Transactional
public class ContactDao {
	
	@Autowired
	HibernateTemplate ht;

	
	
	public List<Contact> getAll()
	{
		return ht.loadAll(Contact.class);
		
	}
	
	public int save(Contact s)
	{
		return (int)ht.save(s);
		
	}
	
	public Contact getContact(int id)
	{
		return ht.get(Contact.class,id);
		
	}

}
