package com.project.java.models;

import java.sql.Date;

public class BookTransaction {
	private int btid;
	private int bid;
	private int sid;
	private Date dateofissue;
	private Date dateofreturn;
	
	public BookTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookTransaction(int btid, int bid, int sid, Date dateofissue, Date dateofreturn) {
		super();
		this.btid = btid;
		this.bid = bid;
		this.sid = sid;
		this.dateofissue = dateofissue;
		this.dateofreturn = dateofreturn;
	}

	public int getBtid() {
		return btid;
	}
	public void setBtid(int btid) {
		this.btid = btid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Date getDateofissue() {
		return dateofissue;
	}
	public void setDateofissue(Date dateofissue) {
		this.dateofissue = dateofissue;
	}
	public Date getDateofreturn() {
		return dateofreturn;
	}
	public void setDateofreturn(Date dateofreturn) {
		this.dateofreturn = dateofreturn;
	}

	@Override
	public String toString() {
		System.out.printf("%-15d %-15d %-15d %-15s %-15s\n", btid, bid, sid, dateofissue,dateofreturn);
	   	 return "";
	}
	
}
