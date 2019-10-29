package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.BooksInventoryBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;
import com.capgemini.librarymanagementsystem.service.StudentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("student/searchBooks/")
	public List<BooksInventoryBean> searchBook(@RequestBody BooksInventoryBean booksInventory) {
		List<BooksInventoryBean> bookList = null;
		try {
			bookList = service.searchBook(booksInventory);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return bookList;
	}// end of searchBook()
	
	@GetMapping("student/book/requset/{bookId}")
	public Boolean requestBook(@PathVariable("bookId") int bookId) {
		boolean isRequested = false;
		try {
			service.requestBook(bookId);
			isRequested = true;
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isRequested;
	}// end of requestBook()
}
