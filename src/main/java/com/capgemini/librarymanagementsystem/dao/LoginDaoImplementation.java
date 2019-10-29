package com.capgemini.librarymanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Repository
public class LoginDaoImplementation implements LoginDao {
	
	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("TestPersistence");
	static int id;
	
	@Override
	public UsersBean login(UsersBean users) throws CustomException  {
		UsersBean user = null;
		LoginDaoImplementation.id = users.getId();
		try {
			EntityManager manager = FACTORY.createEntityManager();
			Query query = manager.createQuery("FROM Users WHERE id= :id and password=:pswd");
			query.setParameter("id", LoginDaoImplementation.id);
			query.setParameter("pswd", users.getPassword());
			user = (UsersBean)query.getSingleResult();
		} catch (Exception e) {
			throw new CustomException("Login Failed");
		}
		return user;
	}// end of login()

}
