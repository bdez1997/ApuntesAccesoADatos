package view;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Coche;

public class FrmPrincipal {

	public static void main(String[] args) {
		org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger("org.hibernate");
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(java.util.logging.Level.OFF);
		
		SessionFactory conf = new Configuration().configure().buildSessionFactory();
		
		Session session = conf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Coche c = new Coche("SEAT", "IBIZA", 1900);
		// GUARDAR OBJETO session.save(c);
		session.save(c);
		System.out.println("se ha borrado un coche "+  c.toString());
		
		tx.commit();
		
		session.close();
		
		conf.close();
	}

}
