package com.capgemini.librarymanagementsystem.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.BooksInventoryBean;
import com.capgemini.librarymanagementsystem.beans.BooksRegistrationBean;
import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Repository
public class LibrarianDaoImplementation implements LibrarianDao {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");

	//ADD STUDENT
	@Override
	public UsersBean registerStudent(UsersBean user) throws CustomException {
		user.setType("Student");
		Random random = new Random();
		user.setId(random.nextInt(10000));
		try {
			EntityManager entityManager = FACTORY.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to add Student");
		}
		return user;
	}// end of registerStudent()

	//DELETE STUDENT
	@Override
	public Boolean deleteStudent(int id) throws CustomException {
		boolean isDeleted = false;
		try {
			EntityManager entityManager = FACTORY.createEntityManager();
			entityManager.getTransaction().begin();
			UsersBean users = entityManager.find(UsersBean.class, id);
			entityManager.remove(users);
			entityManager.getTransaction().commit();
			isDeleted = true;
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to delete the Student");
		}
		return isDeleted;
	}// end of deleteStudent()

	//ADD BOOK
	@Override
	public Boolean addBooks(BooksInventoryBean booksInventory) throws CustomException {
		boolean isAdded = false;
		Random random = new Random();
		booksInventory.setBookId(random.nextInt(10000));
		try {
			EntityManager entityManager = FACTORY.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(booksInventory);
			entityManager.getTransaction().commit();
			isAdded = true;
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to add the book");
		}
		return isAdded;
	}// end of addBooks()

	//DELETE BOOK
	@Override
	public Boolean deleteBook(int bookId) throws CustomException {
		boolean isDeleted = false;
		try {
			EntityManager entityManager = FACTORY.createEntityManager();
			entityManager.getTransaction().begin();
			BooksInventoryBean booksInventory = entityManager.find(BooksInventoryBean.class, bookId);
			entityManager.remove(booksInventory);
			entityManager.getTransaction().commit();
			isDeleted = true;
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to delete the book from BooksInventory");
		}
		return isDeleted;
	}// end of deleteBook()

	//SHOW ALL BOOKS
	@Override
	public List<BooksInventoryBean> showAllBooks() throws CustomException {
		List<BooksInventoryBean> booksInventories = null;
		try {
			EntityManager entityManager = FACTORY.createEntityManager();
			TypedQuery<BooksInventoryBean> query = entityManager.createQuery("FROM BooksInventory", BooksInventoryBean.class);
			booksInventories = query.getResultList();
		} catch (Exception e) {
			throw new CustomException("Failed to fetch the books from BooksInventory");
		}
		return booksInventories;
	}// end of showAllBook()

	//STUDENT INFO
	@Override
	public UsersBean getStudentInfo(int id) throws CustomException {
		UsersBean users = null;
		try {
			EntityManager entityManager = FACTORY.createEntityManager();
			entityManager.getTransaction().begin();
			users = entityManager.find(UsersBean.class, id);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to fetch the Student Info");
		}
		return users;
	}// end of getStudentInfo()


	//VIEW REQUEST
	@Override
	public List<BooksRegistrationBean> viewRequest() throws CustomException {
		List<BooksRegistrationBean> booksRegistrations = null;
		try {
			EntityManager entityManager = FACTORY.createEntityManager();
			TypedQuery<BooksRegistrationBean> typedQuery = entityManager.createQuery("FROM BooksRegistration", BooksRegistrationBean.class);
			booksRegistrations = typedQuery.getResultList();
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to Fetch the Requests");
		}
		return booksRegistrations;
	}// end of viewRequest()

}
