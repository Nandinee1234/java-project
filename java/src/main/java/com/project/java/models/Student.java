package com.project.java.models;

import java.sql.Date;

public class Student {
	    private int sid;
	    private String sname;
	    private String contact;
	    private String address;
	    private String email;
	    private int age;
	    private Date dob;
	    private String course;

	    // Default constructor
	    public Student() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    // Parameterized constructor
	    public Student(int sid, String sname, String contact, String address, String email, int age, Date dob, String course) {
	        super();
	        this.sid = sid;
	        this.sname = sname;
	        this.contact = contact;
	        this.address = address;
	        this.email = email;
	        this.age = age;
	        this.dob = dob;
	        this.course = course;
	    }

	    // Getters and Setters
	    public int getSid() {
	        return sid;
	    }

	    public void setSid(int sid) {
	        this.sid = sid;
	    }

	    public String getSname() {
	        return sname;
	    }

	    public void setSname(String sname) {
	        this.sname = sname;
	    }

	    public String getContact() {
	        return contact;
	    }

	    public void setContact(String contact) {
	        this.contact = contact;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public Date getDob() {
	        return dob;
	    }

	    public void setDob(Date dob) {
	        this.dob = dob;
	    }

	    public String getCourse() {
	        return course;
	    }

	    public void setCourse(String course) {
	        this.course = course;
	    }

	    @Override
	    public String toString() {
	    	System.out.printf("%-15d %-15s %-15s %-15s %-15s %-15d  %-15s  %-15s\n", sid, sname, contact, address,email,age,dob,course);
	   	 return "";
	    }
	}
