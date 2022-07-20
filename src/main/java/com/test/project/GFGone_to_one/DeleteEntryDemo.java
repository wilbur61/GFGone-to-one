package com.test.project.GFGone_to_one;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.geeksforgeeks.entity.Student;
import com.geeksforgeeks.entity.StudentGfgDetail;

public class DeleteEntryDemo {

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
			Student student = session.get(Student.class, id);                 
			                                                                  
			// Delete the student, this will also delete the associated entity
			// as we use CascadeType.ALL                                      
			session.delete(student);                                          
			                                                                  
			// Commit the transaction                                         
			session.getTransaction().commit();                                
			                                                                  
			// close the session                                              
			session.close();    


			System.out.println(
				"Delete Successfully Completed!");

	}
}