package app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Category;
import entities.Product;

public class AssociationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
								
				//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();	

				Session session = sf.openSession();	// TODO Auto-generated method stub
			
				Transaction tr = session.beginTransaction();
				//Product p1 = new Product(101, "xyz", 100,"abc");
				
				//Category p1 = new Category(1, "Electronics", "All electronics items are here");
				
				Product p1 = new Product(101, "mobile",40000.0f,1);
				
				session.save(p1);
				tr.commit();
				System.out.println("prodiuct updated");
				session.close();
				sf.close();

	}

}
