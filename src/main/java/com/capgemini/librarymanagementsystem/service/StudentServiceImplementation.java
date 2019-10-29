package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.BooksInventoryBean;
import com.capgemini.librarymanagementsystem.dao.StudentDao;
import com.capgemini.librarymanagementsystem.dao.StudentDaoImplementation;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	StudentDao studentDao = new StudentDaoImplementation();
	
	@Override
	public List<BooksInventoryBean> searchBook(BooksInventoryBean booksInventory) throws CustomException {
		return studentDao.searchBook(booksInventory);
	}// end of searchBook()
	
	@Override
	public Boolean requestBook(int bookId) throws CustomException {
		return studentDao.requestBook(bookId);
	}// end of requestBook() 

}
