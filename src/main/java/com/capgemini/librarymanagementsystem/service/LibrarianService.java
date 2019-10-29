package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventoryBean;
import com.capgemini.librarymanagementsystem.beans.BooksRegistrationBean;
import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface LibrarianService {
	
	public UsersBean registerStudent(UsersBean user)throws CustomException;
	public Boolean addBooks(BooksInventoryBean booksInventory) throws CustomException;
	public Boolean deleteBook(int bookId) throws CustomException;
	public List<BooksInventoryBean> showAllBooks() throws CustomException;
	public UsersBean getStudentInfo(int id) throws CustomException;
	public List<BooksRegistrationBean> viewRequest() throws CustomException;
	public Boolean deleteStudent(int id) throws CustomException;
	
	

}
