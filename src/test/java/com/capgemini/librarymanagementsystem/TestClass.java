package com.capgemini.librarymanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.beans.BooksInventoryBean;
import com.capgemini.librarymanagementsystem.dao.AdminDaoImplementation;
import com.capgemini.librarymanagementsystem.dao.LibrarianDaoImplementation;
import com.capgemini.librarymanagementsystem.dao.StudentDaoImplementation;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public class TestClass {
	@Test
	public void deleteLibrarianPass() throws CustomException {
		AdminDaoImplementation adminDaoImplementation = new AdminDaoImplementation();
		boolean expected = adminDaoImplementation.deleteLibrarian(1);
		assertEquals(expected, true);
	}
	@Test
	public void addBooksPass() throws CustomException {
		LibrarianDaoImplementation librarianDaoImplementation = new LibrarianDaoImplementation();
		BooksInventoryBean booksInventoryBean = new BooksInventoryBean();
		booksInventoryBean.setBookId(101);
		booksInventoryBean.setAuthor1("Aisha Choudhury");
		booksInventoryBean.setAuthor2("Niel Choudhury");
		booksInventoryBean.setBookName("My Little Epiphanies");
		booksInventoryBean.setPublisher("T.Deb");
		booksInventoryBean.setYearOfPublication("2012");
		boolean isAdded = librarianDaoImplementation.addBooks(booksInventoryBean);
		assertEquals(isAdded, true);
		}
	@Test
	public void deleteBooksPass() throws CustomException {
		LibrarianDaoImplementation librarianDaoImplementation = new LibrarianDaoImplementation();
		boolean expected = librarianDaoImplementation.deleteBook(101);
		assertEquals(expected, true);
	}
	@Test
	public void deleteStudentPass() throws CustomException {
		LibrarianDaoImplementation librarianDaoImplementation = new LibrarianDaoImplementation();
		boolean expected = librarianDaoImplementation.deleteStudent(1);
		assertEquals(expected, true);
	}
	@Test
	public void requestBookPass() throws CustomException {
		StudentDaoImplementation studentDaoImplementation = new StudentDaoImplementation();
		boolean expected = studentDaoImplementation.requestBook(101);
		assertEquals(expected, true);
	}
}
