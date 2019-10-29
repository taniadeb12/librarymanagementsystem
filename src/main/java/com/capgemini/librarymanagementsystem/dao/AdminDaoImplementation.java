package com.capgemini.librarymanagementsystem.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Repository
public class AdminDaoImplementation implements AdminDao {
	
	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");
	
	//ADD LIBRARIAN
	@Override
	public UsersBean addLibrarian(UsersBean users) throws CustomException {
		users.setType("Librarian");
		Random random = new Random();
		users.setId(random.nextInt(10000));
		try {
			EntityManager entityManager = FACTORY.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(users);
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to add Librarian");
		}
		return users;
	}// end of addLibrarian()

	//DELETE LIBRARIAN
	@Override
	public Boolean deleteLibrarian(int id) throws CustomException {
		boolean isDeleted = false;
		try {
			EntityManager entityManager = FACTORY.createEntityManager();
			UsersBean user = entityManager.find(UsersBean.class, id);
			entityManager.getTransaction().begin();
			entityManager.remove(user);
			entityManager.getTransaction().commit();
			isDeleted = true;
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to Delete Librarin");
		}
		return isDeleted;
	}// end of deleteLibrarian()

	//DISPLAY LIBRARIAN
	@Override
	public List<UsersBean> displayLibrarian() throws CustomException {
		List<UsersBean> userList = null;
		 try {
			 EntityManager entityManager = FACTORY.createEntityManager();
			TypedQuery<UsersBean> typedQuery = entityManager.createQuery("FROM Users WHERE type = 'Librarian'", UsersBean.class);
			 userList = typedQuery.getResultList();
		} catch (Exception e) {
			throw new CustomException("No Data Found");
		}
		return userList;
	}// end of displayLibrarian()

}
