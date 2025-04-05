package com.project.java.dao;

import java.util.List;

import com.project.java.models.Book;

public interface Bookdao {
		public Book addBook(Book book);
		public Book getBookById(int id);
		public List<Book> getAllBooks();
		public Book updateBook(Book book);
		public boolean deleteBook(int id);

	}


