package app;

import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class saveDemoApp {

	

	public static void main(String[] args) {
		
		//create the service
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
						
				//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
						
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
				
				//open the session
				Session session = sf.openSession();
				
				//Create instance of entity
				Emp e = new Emp(119, "Vinay", 13400, 30);
				
				//start a transaction
				Transaction tr =session.beginTransaction();
				
				//save the instance with hibernate
				session.save(e);
				
				
				tr.commit();
						
				session.close();
				
				sf.close();

	}

}
