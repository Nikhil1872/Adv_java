package AppDemoMain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import mappingDemo.Student;

public class CompositionFetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//for fetching data u have to change to update  from create in cfg.xml file

		//create service
		
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		
		//read info from hibernate.cfg.xml file
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		
		//actually conn to database
		SessionFactory sf = metadata.getSessionFactoryBuilder().build();
		
		Session session = sf.openSession();
		
		Student st = session.get(Student.class, 101);
		
		System.out.println("[Name: "+st.getSname()+" ,City: "+st.getAddress().getCity()+"]");
	
	    session.close();
	    sf.close();
	}

}
