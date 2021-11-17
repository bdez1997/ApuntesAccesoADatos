package view;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Casa;

public class FrmPrincipal {
	
	public static void main(String[] args) {
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
		
		SessionFactory conf = new Configuration().configure().buildSessionFactory();
		
		Session session = conf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Casa c = new Casa("Membrillo", 8, 154.25);
		// GUARDAR OBJETO session.save(c);
		session.save(c);
		System.out.println("se ha añadido una casa "+  c.toString());
		
		tx.commit();
		
		session.close();
		
		conf.close();
	}

}
