package com.project.java.dao;

import java.util.List;

import com.project.java.models.Student;


public interface Studentdao {
		public Student addStudent(Student student);
		public Student getStudentById(int id);
		public List<Student> getAllStudent();
		public Student updateStudent(Student student);
		public Student deleteStudent(int id);

	}


