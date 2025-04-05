package com.project.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.java.dao.Studentdao;
import com.project.java.models.Student;
import com.project.java.models.ConnectionProvider;

public class Studentdaoimpl implements Studentdao {
	Connection connection=ConnectionProvider.getConnection();
	public Student addStudent(Student student) {
	 try {
		PreparedStatement ps=connection.prepareStatement("insert into Student(sid,sname,contact,address,email,age,dob,course) values(?,?,?,?,?,?,?,?)");
		ps.setInt(1, student.getSid());
		ps.setString(2, student.getSname());
		ps.setString(3, student.getContact());
		ps.setString(4, student.getAddress());
		ps.setString(5, student.getEmail());
		ps.setInt(6, student.getAge());
		ps.setDate(7, student.getDob());
		ps.setString(8, student.getCourse());
		
		int i=ps.executeUpdate();
		if(i>0)
			System.out.println("Student added succesfully");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Student not added ..somethong went wrong");
		e.printStackTrace();
	}
	  return student;
	}

	public Student getStudentById(int id) {
		Student student=new Student();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from student where sid=?");
		     ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				student.setSid(rs.getInt("sid"));
				student.setSname(rs.getString("sname"));
				student.setContact(rs.getString("contact"));
				student.setAddress(rs.getString("address"));
				student.setEmail(rs.getString("email"));
				student.setAge(rs.getInt("age"));
				student.setDob(rs.getDate("dob"));
				student.setCourse(rs.getString("course"));
				
				return student;
			}
			else
			{
				System.out.println("Sorry there is no student with the given Id");
			   return null;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the student");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> studentList=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from student ");
		   	ResultSet rs=ps.executeQuery();
		   	
			while(rs.next())
			{			
				Student student =new Student();	
				student.setSid(rs.getInt("sid"));
				student.setSname(rs.getString("sname"));
				student.setContact(rs.getString("contact"));
				student.setAddress(rs.getString("address"));
				student.setEmail(rs.getString("email"));
				student.setAge(rs.getInt("age"));
				student.setDob(rs.getDate("dob"));
				student.setCourse(rs.getNString("Course"));
				studentList.add(student);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the student");
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public Student updateStudent(Student student) {
		 try {
				PreparedStatement ps=connection.prepareStatement("update student SET sname=?,contact=?,address=?,email=?,age=?,dob=?,course=? WHERE sid=?");
				ps.setInt(8, student.getSid());
				ps.setString(1, student.getSname());
				ps.setString(2, student.getContact());
				ps.setString(3, student.getAddress());
				ps.setString(4, student.getEmail());
				ps.setInt(5, student.getAge());
				ps.setDate(6, student.getDob());
				ps.setString(7, student.getCourse());
				
				int i=ps.executeUpdate();
				if(i>0)
					System.out.println("Student updated succesfully");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Student not updated ..something went wrong");
				e.printStackTrace();
			}
			  return student;
	}

	@Override
	public Student deleteStudent(int id) {
		
		try {
			PreparedStatement ps = connection.prepareStatement("delete from student where sid=?");
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0)
			{	
				System.out.println("Student deleted Suucessfully.");
				return null;
			}
		
		} catch (SQLException e) {
			System.out.println("Student not deleted ...something went wrong");
			e.printStackTrace();
			return null;
		}
		return null;
	     
		
	}

}




