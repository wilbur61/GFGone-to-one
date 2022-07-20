package com.test.project.GFGone_to_one;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.geeksforgeeks.entity.Student;
import com.geeksforgeeks.entity.StudentGfgDetail;

/**
 * Hello world!
 *
 */
public class App 
{
 
	public static void main(String[] args)
	{
		 System.out.println( "Hello World!" );
		
		 File cfgFile = new File("/home/lou1/hibernate.cfg.xml");
		 
		 // for windows example NOTE the \\:
		 //File cfgFile = new File("C:\\hibernate.cfg.xml");
		
        SessionFactory factory = new Configuration().configure(cfgFile).buildSessionFactory();  	
    	Session session = factory.openSession();

    
			// Create relevant object.
			Student student = new Student("Vyom", "Yadav",
										"vyom@gmail.com");

			StudentGfgDetail studentGfgDetail
				= new StudentGfgDetail("GFG College", 20);

			student.setStudentGfgDetail(studentGfgDetail);

			// Begin the transaction
			session.beginTransaction();

			// Save the student object.
			// This will also save the StudentGfgDetail
			// object as we have used CascadeType.ALL
			session.save(student);

			// Commit the transaction
			session.getTransaction().commit();

			System.out.println(
				"Transaction Successfully Completed!");

	}
}
