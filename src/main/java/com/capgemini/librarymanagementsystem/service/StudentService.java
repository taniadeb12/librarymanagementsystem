package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventoryBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface StudentService {
	
	public List<BooksInventoryBean> searchBook(BooksInventoryBean booksInventory) throws CustomException;
	public Boolean requestBook(int bookId) throws CustomException;
}
