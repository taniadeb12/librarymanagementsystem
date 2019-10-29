package com.capgemini.librarymanagementsystem.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.BooksInventoryBean;
import com.capgemini.librarymanagementsystem.beans.BooksRegistrationBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Repository
public class StudentDaoImplementation implements StudentDao {
	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");
	
	//SEARCH BOOK
	@Override
	public List<BooksInventoryBean> searchBook(BooksInventoryBean booksInventory) throws CustomException {
		List<BooksInventoryBean> booksInventories = null;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			TypedQuery<BooksInventoryBean> query = manager.createQuery("FROM BooksInventory WHERE bookName = :bName and author1 =:author", BooksInventoryBean.class);
			query.setParameter("bName", booksInventory.getBookName());
			query.setParameter("author", booksInventory.getAuthor1());
			booksInventories = query.getResultList();
		} catch (Exception e) {
			throw new CustomException("Failed to fetch the books from BooksInventory");
		}
		return booksInventories;
	}// end of searchBook()
	
	//REQUEST BOOK
	@Override
	public Boolean requestBook(int bookId) throws CustomException {
		BooksRegistrationBean booksRegistration = new BooksRegistrationBean();
		booksRegistration.setId(LoginDaoImplementation.id);
		booksRegistration.setBookId(bookId);
		booksRegistration.setRegistrationDate(new Date());
		Random random = new Random();
		booksRegistration.setRegistrationId(random.nextInt(10000));
		boolean isRequested = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(booksRegistration);
			manager.getTransaction().commit();
			isRequested = true;
			manager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to Request the Book");
		}
		return isRequested;
	}// end of requestBook()

}
