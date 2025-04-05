package com.project.java.dao;

import java.util.List;

import com.project.java.models.BookTransaction;

public interface BookTransactiondao {
	public BookTransaction addBookTransaction(BookTransaction bookTransaction);

	public BookTransaction getBookTransactionById(int id);

	public List<BookTransaction> getAllBookTransactions();

	public BookTransaction updateBookTransaction(BookTransaction bookTransaction);

	public boolean deleteBookTransaction(int id);

}
