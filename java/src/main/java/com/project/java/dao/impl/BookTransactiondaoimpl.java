 package com.project.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.java.dao.BookTransactiondao;
import com.project.java.models.BookTransaction;
import com.project.java.models.ConnectionProvider;

public class BookTransactiondaoimpl implements BookTransactiondao {
	Connection connection=ConnectionProvider.getConnection();
	public BookTransaction addBookTransaction(BookTransaction bookTransaction) {
	 try {
		PreparedStatement ps=connection.prepareStatement("insert into BookTransaction(btid,bid,sid,dateofissue,dateofreturn) values(?,?,?,?,?)");
		ps.setInt(1, bookTransaction.getBtid());
		ps.setInt(2, bookTransaction.getBid());
		ps.setInt(3, bookTransaction.getSid());
		ps.setDate(4,bookTransaction.getDateofissue());
		ps.setDate(5,   bookTransaction.getDateofreturn());
		
		int i=ps.executeUpdate();
		if(i>0)
			System.out.println("BookTransaction added succesfully");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("BookTransaction not added ..somethong went wrong");
		e.printStackTrace();
	}
	  return bookTransaction;
	}

	public BookTransaction getBookTransactionById(int id) {
		BookTransaction bookTransaction=new BookTransaction();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from bookTransaction where btid=?");
		     ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				bookTransaction.setBtid(rs.getInt("btid"));
				bookTransaction.setBid(rs.getInt("bid"));
				bookTransaction.setSid(rs.getInt("sid"));
				bookTransaction.setDateofissue(rs.getDate("dateofissue"));
				bookTransaction.setDateofreturn(rs.getDate("dateofreturn"));
				 
				return bookTransaction;
			}
			else
			{
				System.out.println("Sorry there is no booktransaction with the given Id");
			   return null;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the bookTransaction");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<BookTransaction> getAllBookTransactions() {
		List<BookTransaction> bookTransactionList=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from bookTransaction ");
		   	ResultSet rs=ps.executeQuery();
		   	
			while(rs.next())
			{				
				BookTransaction bookTransaction=new BookTransaction();
				bookTransaction.setBtid(rs.getInt("btid"));
				bookTransaction.setBid(rs.getInt("bid"));
				bookTransaction.setSid(rs.getInt("sid"));
				bookTransaction.setDateofissue(rs.getDate("dateofissue"));
				bookTransaction.setDateofreturn(rs.getDate("dateofreturn"));
				bookTransactionList.add(bookTransaction);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the bookTransactions");
			e.printStackTrace();
		}
		return bookTransactionList;
	}

	@Override
	public BookTransaction updateBookTransaction(BookTransaction bookTransaction) {
		 try {
				PreparedStatement ps=connection.prepareStatement("update bookTransaction set btid=?,bid=?,sid=?,dateofissue=?,dateofreturn=? where btid=?");
				ps.setInt(1, bookTransaction.getBtid());
				ps.setInt(2, bookTransaction.getBid());
				ps.setInt(3, bookTransaction.getSid());
				ps.setDate(4, bookTransaction.getDateofissue());
				ps.setDate(5, bookTransaction.getDateofreturn());
				int i=ps.executeUpdate();
				if(i>0)
					System.out.println("BookTransaction updated succesfully");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("BookTransaction not updated ..somethong went wrong");
				e.printStackTrace();
			}
			  return bookTransaction;
	}

	@Override
	public boolean deleteBookTransaction(int id) {
		
		try {
			PreparedStatement ps = connection.prepareStatement("delete from bookTransaction where btid=?");
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0)
			{	
				System.out.println("BookTransaction deleted Suucessfully.");
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("BookTransaction not deleted ...something went wrong");
			e.printStackTrace();
			return false;
		}
	     
		
	}

}


