package com.student.services;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.student.dao.StudentDao;
import com.student.entity.Student;  

/*
 *  This class is used for student services
 * 
 */
@Path("/StuServices")
public class StudentServices {  
   StudentDao StudentDao = new StudentDao();  
   
   @POST
   @Path("/create")
   @Consumes("application/json")
   public Response addStudent(Student stu){
       stu.setName(stu.getName());
       stu.setAge(stu.getAge());            
       StudentDao dao = new StudentDao();
       dao.addStudent(stu);
       return Response.ok().build();
   }   
}