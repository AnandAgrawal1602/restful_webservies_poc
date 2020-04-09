package com.student.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
   
   @PUT
   @Path("/update/{id}")
   @Consumes("application/json")
   public Response updateStudent(@PathParam("id") int id, Student stu){
       StudentDao dao = new StudentDao();
       int count = dao.updateStudent(id, stu);
       if(count==0){
           return Response.status(Response.Status.BAD_REQUEST).build();
       }
       return Response.ok().build();
   }
   
   @DELETE
   @Path("/delete/{id}")
   @Consumes("application/json")
   public Response deleteStudent(@PathParam("id") int id){
       StudentDao dao = new StudentDao();
       int count = dao.deleteStudent(id);
       if(count==0){
           return Response.status(Response.Status.BAD_REQUEST).build();
       }
       return Response.ok().build();
   }
   
   @GET
   @Path("/stu") 
   @Produces("application/json")
   public List<Student> getStudent() {
       StudentDao dao = new StudentDao();
       List<Student> Students = dao.getStudents();
       return Students;
   }
}