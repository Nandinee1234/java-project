package com.project.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.java.dao.Bookdao;
import com.project.java.models.Book;
import com.project.java.models.ConnectionProvider;

public class Bookdaoimpl implements Bookdao {
	Connection connection=ConnectionProvider.getConnection();
	public Book addBook(Book book) {
	 try {
		PreparedStatement ps=connection.prepareStatement("insert into Book(bid,bname,authore,publication,yop,price,edition) values(?,?,?,?,?,?,?)");
		ps.setInt(1, book.getBid());
		ps.setString(2, book.getBname());
		ps.setString(3, book.getAuthore());
		ps.setString(4, book.getPublication());
		ps.setDate(5, book.getYop());
		ps.setInt(6, book.getPrice());
		ps.setInt(7, book.getEdition());
		
		int i=ps.executeUpdate();
		if(i>0)
			System.out.println("Book added succesfully");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Book not added ..somethong went wrong");
		e.printStackTrace();
	}
	  return book;
	}

	public Book getBookById(int id) {
		Book book=new Book();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from book where bid=?");
		     ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				book.setBid(rs.getInt("bid"));
				book.setBname(rs.getString("bname"));
				book.setAuthore(rs.getString("authore"));
				book.setPublication(rs.getString("publication"));
				book.setYop(rs.getDate("yop"));
				book.setPrice(rs.getInt("price"));
				book.setEdition(rs.getInt("edition"));
				return book;
			}
			else
			{
				System.out.println("Sorry there is no book with the given Id");
			   return null;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the book");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList=new ArrayList<>();
		try {
			PreparedStatement ps=connection.prepareStatement("select * from book ");
		   	ResultSet rs=ps.executeQuery();
		   	 
			while(rs.next())
			{	
				Book book=new Book();
				book.setBid(rs.getInt("bid"));
				book.setBname(rs.getString("bname"));
				book.setAuthore(rs.getString("authore"));
				book.setPublication(rs.getString("publication"));
				book.setYop(rs.getDate("yop"));
				book.setPrice(rs.getInt("price"));
				book.setEdition(rs.getInt("edition"));
				bookList.add(book);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Somethong went wrong in getting the books");
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public Book updateBook(Book book) {
		 try {
				PreparedStatement ps=connection.prepareStatement("update book set bname=?,authore=?,publication=?,yop=?,price=?,edition=? where bid=?");
				ps.setInt(7, book.getBid());
				ps.setString(1, book.getBname());
				ps.setString(2, book.getAuthore());
				ps.setString(3, book.getPublication());
				ps.setDate(4, book.getYop());
				ps.setInt(5, book.getPrice());
				ps.setInt(6, book.getEdition());
				int i=ps.executeUpdate();
				if(i>0)
					System.out.println("Book updated succesfully");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Book not updated ..somethong went wrong");
				e.printStackTrace();
			}
			  return book;
	}

	@Override
	public boolean deleteBook(int id) {
		
		try {
			PreparedStatement ps = connection.prepareStatement("delete from book where bid=?");
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0)
			{	
				System.out.println("Book deleted Suucessfully.");
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("Book not deleted ...something went wrong");
			e.printStackTrace();
			return false;
		}
	     
		
	}

}


