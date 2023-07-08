package OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class DriverClass {

	private static void insertRest(Session session) {
		Person person = 		new Person();
		Address adrs = new Address();
		adrs.setDistrict("blre");
		adrs.setState("ka");
		
		person.setAge(21);
		person.setName("minal");
		person.setAdrs(adrs);
		
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		
		
	}
	
	private static void readByPersonId(Session session) {
		Person personAdrsObj = session.get(Person.class, 1);
		if(personAdrsObj != null)
			System.out.println(personAdrsObj);
		
		
	}
	
	private static void readByAdrsId(Session session) {
		Address adrsObj = session.get(Address.class, 1);
		if(adrsObj != null)
			System.out.println(adrsObj);
		
		
	}
	public static void main(String[] args) {
		Configuration config=new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Address.class);
		SessionFactory sessionFact = config.buildSessionFactory();
		Session session = sessionFact.openSession();
		insertRest(session);
	//	readByPersonId(session);
		readByAdrsId(session);

	}

}
