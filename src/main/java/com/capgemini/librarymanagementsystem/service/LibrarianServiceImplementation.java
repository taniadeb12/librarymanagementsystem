package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.BooksInventoryBean;
import com.capgemini.librarymanagementsystem.beans.BooksRegistrationBean;
import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.dao.LibrarianDao;
import com.capgemini.librarymanagementsystem.dao.LibrarianDaoImplementation;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Service
public class LibrarianServiceImplementation implements LibrarianService {

	@Autowired
	LibrarianDao librarianDao = new LibrarianDaoImplementation();
	
	@Override
	public Boolean addBooks(BooksInventoryBean booksInventory) throws CustomException {
		return librarianDao.addBooks(booksInventory);
	}// end of addBooks() 

	@Override
	public Boolean deleteBook(int bookId) throws CustomException {
		return librarianDao.deleteBook(bookId);
	}// end of deleteBooks()

	@Override
	public UsersBean registerStudent(UsersBean user) throws CustomException {
		return librarianDao.registerStudent(user);
	}// end of registerStudent()

	@Override
	public List<BooksInventoryBean> showAllBooks() throws CustomException {
		return librarianDao.showAllBooks();
	}// end of showAllBooks()

	@Override
	public UsersBean getStudentInfo(int id) throws CustomException {
		return librarianDao.getStudentInfo(id);
	}// end of getStudentInfo()

	@Override
	public Boolean deleteStudent(int id) throws CustomException {
		return librarianDao.deleteStudent(id);
	}// edn of deleteStudent()

	@Override
	public List<BooksRegistrationBean> viewRequest() throws CustomException {
		return librarianDao.viewRequest();
	}

}
