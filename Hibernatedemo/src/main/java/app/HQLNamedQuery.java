package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import entities.*;

import entities.Emp;

public class HQLNamedQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read the info hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
						
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
				
		//open the session
		Session session = sf.openSession();
		
		//hql query 
		 
//		 Query q = session.createNamedQuery("getbysal");
//		 q.setParameter("min", 5000.0f);
//		 q.setParameter("max", 10000.0f);
		
		//#####GET BY DEPT//
		Query q = session.createNamedQuery("getbydept");
		q.setParameter("dept", 30);
		
		 
		 List<Object[]> emps = q.getResultList();
		 
		 for(Object[] obj : emps)
		 {
			System.out.println(obj[0]+" "+obj[1]);
		 }

	}

}
