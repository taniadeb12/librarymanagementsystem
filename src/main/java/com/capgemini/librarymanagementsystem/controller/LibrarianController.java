package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.BooksInventoryBean;
import com.capgemini.librarymanagementsystem.beans.BooksRegistrationBean;
import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;
import com.capgemini.librarymanagementsystem.service.LibrarianService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LibrarianController {

	@Autowired
	LibrarianService service;

	@PostMapping("librarian/addStudent")
	public UsersBean addStudent(@RequestBody UsersBean users) {
		try {
			users = service.registerStudent(users);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return users;
	}// end of addStudent()

	@PostMapping("librarian/addBook")
	public Boolean addBooks(@RequestBody BooksInventoryBean booksInventory) {
		boolean isAdded = false;
		try {
			service.addBooks(booksInventory);
			isAdded = true;
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isAdded;
	}// end of addBooks()

	@DeleteMapping("librarian/deleteBook/{bookId}")
	public Boolean deleteBook(@PathVariable("bookId") int bookId) {
		boolean isDeleted = false;
		try {
			service.deleteBook(bookId);
			isDeleted = true;
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isDeleted;
	}// end of deleteBook()

	@GetMapping("librarian/getAllBooks")
	public List<BooksInventoryBean> showAllBook() {
		List<BooksInventoryBean> bookList = null;
		try {
			bookList = service.showAllBooks();
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return bookList;
	}// end of showAllBooks()
	
	@GetMapping("librarian/getStudent/{id}")
	public UsersBean getStuentInfo(@PathVariable("id")int id) {
		UsersBean users = null;
		try {
			users = service.getStudentInfo(id);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return users;
	}// end of getStudentInfo()
	
	@DeleteMapping("librarian/deleteStudent/{id}")
	public Boolean deleteStudent(@PathVariable("id") int id) {
		boolean isDeleted = false;
		try {
			isDeleted = service.deleteStudent(id);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isDeleted;
	}// end of deleteStudent()

	@GetMapping("librarian/viewRequest")
	public List<BooksRegistrationBean> viewRequests() {
		List<BooksRegistrationBean> booksRegistrations = null;
		try {
			booksRegistrations = service.viewRequest();
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return booksRegistrations;
	}// end of viewRequest()
}

