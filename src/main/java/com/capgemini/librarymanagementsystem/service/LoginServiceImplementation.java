package com.capgemini.librarymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.dao.LoginDao;
import com.capgemini.librarymanagementsystem.dao.LoginDaoImplementation;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Service
public class LoginServiceImplementation implements LoginService {

	@Autowired
	LoginDao loginDao = new LoginDaoImplementation();
	
	@Override
	public UsersBean login(UsersBean users) throws CustomException {
		return loginDao.login(users);
	}// end of login()

}
