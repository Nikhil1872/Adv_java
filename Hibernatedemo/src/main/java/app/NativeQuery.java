package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import entities.Emp;

public class NativeQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
						
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
				
		//open the session
		Session session = sf.openSession();
		

	
		Query q = session.createNativeQuery("select * from emp");
		 
		List<Object[]> emps = q.getResultList();
		 
		 for(Object[] obj : emps)
		 {
			System.out.println(obj[0]+" "+obj[1]+" "+obj[2]+" "+obj[3]);
		 }

	}

}
