package AppDemoMain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mappingDemo.Address;
import mappingDemo.Student;

public class CompositionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//for fetching data u have to change to create  from update in cfg.xml file

		
		
		//create service
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		//read info fron cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		//actually conn to database
		
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession(); 
		
		Address add = new Address("Fulmogra","Bhandara","441905");
		Student st = new Student(101, "Rahul Waghaye", add);
		
		Transaction tr = session.beginTransaction();
		session.save(st);
		tr.commit();

		System.out.println("Student saved");
		
		session.close();
		sf.close();
		

	}

}
