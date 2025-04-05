package com.project.java.models;

import java.sql.Date;

public class Book {
	private int bid;
	private String bname;
	private String authore;
	private String publication;
	private Date yop;
	private int price;
	private int edition;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bid, String bname, String authore, String publication, Date yop, int price, int edition) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.authore = authore;
		this.publication = publication;
		this.yop = yop;
		this.price = price;
		this.edition = edition;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthore() {
		return authore;
	}
	public void setAuthore(String authore) {
		this.authore = authore;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public Date getYop() {
		return yop;
	}
	public void setYop(Date yop) {
		this.yop = yop;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		System.out.printf("%-15d %-15s %-15s %-15s %-15s %-15d %-15d\n", bid, bname, authore, publication,yop,price,edition);
	 return "";
	
	}
}



