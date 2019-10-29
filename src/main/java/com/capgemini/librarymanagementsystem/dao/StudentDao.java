package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventoryBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface StudentDao {

	public List<BooksInventoryBean> searchBook(BooksInventoryBean booksInventory) throws CustomException;
	public Boolean requestBook(int bookId) throws CustomException;
}
