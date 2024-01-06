package org.anudip.hibernateAssignment.app;

import java.util.Scanner;

import org.anudip.hibernateAssignment.bean.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserApp {
	
	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//create sessionfactory
				SessionFactory  factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
				//create session
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();

		
			
		User user1 = new User("Smith", "New York", 70000.00);
		session.save(user1);
		User user2 = new User("Allen", "New York", 75000.00);
		session.save(user2);
		transaction.commit();
		
		System.out.println(session.get(User.class, 1));
		
		session.close();
		
		Session session2 = factory.openSession();
		System.out.println(session2.get(User.class,1));
		System.out.println(session2.get(User.class,2));
		factory.close();
			
		
		
		
	}

}
