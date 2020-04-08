package com.student.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.student.entity.Student;
/*
 * This class use as persistent class where getting all data from database.	 
 */
	public class StudentDao {
	    
		/*
		 * this method is used for adding new student record in student table
		 */
	    public void addStudent(Student bean){
	        Session session = SessionUtil.getSession();        
	        Transaction tx = session.beginTransaction();
	        addStudent(session,bean);        
	        tx.commit();
	        session.close();	      
	    }
	    
	    /*
		 * this method calling from addStudent(-)
		 */
	    private void addStudent(Session session, Student bean){
	        Student Student = new Student();	        
	        Student.setName(bean.getName());
	        Student.setAge(bean.getAge());	        
	        session.save(Student);
	    }   
}

