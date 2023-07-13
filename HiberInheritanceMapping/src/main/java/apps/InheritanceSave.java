package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Emp;
import entities.PermanentEmp;
import entities.TemporaryEmp;

public class InheritanceSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create the service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read info from cf.xml file
		
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		
		//actually connection to db
		
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession();
		
		Emp  e1 = new PermanentEmp(101, "Rahul Meena", "Rahul@abc.com", "7054768909", 5000, 200, 500, 100);
		Emp e2 = new TemporaryEmp(102, "Nikhil", "ntalmale@gmail.com", "7038331878", 10000, 500, 105);
		
		Transaction tr = session.beginTransaction();
		session.save(e1);
		session.save(e2);
		
		tr.commit();
		
		System.out.println("emp inserteed");
		session.close();
		sf.close();
		
	}

}
