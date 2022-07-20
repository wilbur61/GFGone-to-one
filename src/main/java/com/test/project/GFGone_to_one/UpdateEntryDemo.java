package com.test.project.GFGone_to_one;


import com.geeksforgeeks.entity.Student;
import com.geeksforgeeks.entity.StudentGfgDetail;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEntryDemo {

	public static void main(String[] args)
	{
		System.out.println( "UpdateEntryDemo!" );
			
		File cfgFile = new File("/home/lou1/hibernate.cfg.xml");
		
        SessionFactory factory = new Configuration().configure(cfgFile).buildSessionFactory();  	
    	Session session = factory.openSession();

		// Create session

			session.beginTransaction();

			// Get object with id = 1
			int id = 1;
			Student student
				= session.get(Student.class, id);
			StudentGfgDetail studentGfgDetail
				= student.getStudentGfgDetail();

			// modify the student and its details
			student.setEmail("william@geeksforgeeks.com");
			studentGfgDetail.setNoOfProblemsSolved(50);

			// Update the student object.
			// This will also update the StudentGfgDetail
			// object as we have used CascadeType.ALL
			session.update(student);

			// Commit the transaction
			session.getTransaction().commit();

			System.out.println(
				"Transaction Successfully Completed!");

	}
}

