package view;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Coche;

public class FrmPrincipal {

	public static void main(String[] args) {
		SessionFactory conf = new Configuration().configure().buildSessionFactory();
		
		Session sesion =conf.openSession();
		
		Transaction tx =sesion.beginTransaction();
		
			
			int id=21;
			
			
			
			//Coche c = sesion.load(Coche.class, id);
			//Coche c= sesion.byId(Coche.class).getReference(id);
			//c.setIdCoche(2);
			//sesion.update(c);
			//sesion.save(c);
			//sesion.delete(c);
			
			List lstCoche =sesion.createQuery("FROM Coche").list();
			
			lstCoche.forEach(c->System.out.println(c));
		
			tx.commit();
			sesion.close();
		conf.close();
	}

}
