package com.student.dao;

import java.util.List;

import org.hibernate.Query;
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
	    
	    /*
		 * this method is used for getting all student record from student table
		 */
	    public List<Student> getStudents(){
	        Session session = SessionUtil.getSession();    
	        Query query = session.createQuery("from Student");
	        List<Student> Students =  query.list();
	        session.close();
	        return Students;
	    }
	 
	    /*
		 * this method is used for deleting student record as per given id from student table
		 */
	    public int deleteStudent(int id) {
	        Session session = SessionUtil.getSession();
	        Transaction tx = session.beginTransaction();
	        String hql = "delete from Student where id = :id";
	        Query query = session.createQuery(hql);
	        query.setInteger("id",id);
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);
	        tx.commit();
	        session.close();
	        return rowCount;
	    }
	    
	    /*
		 * this method is used for updating  student record  as per given id
		 */
	    public int updateStudent(int id, Student stu){
	         if(id <=0)  
	               return 0;  
	         Session session = SessionUtil.getSession();
	            Transaction tx = session.beginTransaction();
	            String hql = "update Student set name = :name, age=:age where id = :id";
	            Query query = session.createQuery(hql);
	            query.setInteger("id",id);
	            query.setString("name",stu.getName());
	            query.setInteger("age",stu.getAge());
	            int rowCount = query.executeUpdate();
	            System.out.println("Rows affected: " + rowCount);
	            tx.commit();
	            session.close();
	            return rowCount;
	    }
}

