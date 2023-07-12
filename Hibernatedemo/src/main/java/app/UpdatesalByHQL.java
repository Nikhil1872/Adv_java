package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class UpdatesalByHQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		//read the info hibernate.cfg.xml file
				Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
								
				//actually conn to database
				SessionFactory sf = metadata.getSessionFactoryBuilder().build();
						
				//open the session
				Session session = sf.openSession();
				
				
				Transaction tx=session.beginTransaction();  
				Query q=session.createQuery("update Emp set salary=:sal where eid=:id");  
				q.setParameter("sal",20000.0f);
				q.setParameter("id",10);  
				  
				int status=q.executeUpdate(); 
				System.out.println("status: "+status);  
				tx.commit();

	}

}
