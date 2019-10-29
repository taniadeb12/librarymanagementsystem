package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.dao.AdminDao;
import com.capgemini.librarymanagementsystem.dao.AdminDaoImplementation;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;
@Service
public class AdminServiceImplementation implements AdminService {
	
	@Autowired
	AdminDao adminDao = new AdminDaoImplementation();
	
	@Override
	public UsersBean addLibrarian(UsersBean users) throws CustomException {
		return adminDao.addLibrarian(users);
	}// end of addLibrarian()

	@Override
	public Boolean deleteLibrarian(int id) throws CustomException {
		return adminDao.deleteLibrarian(id);
	}// end of deleteLibrarian()

	@Override
	public List<UsersBean> displayLibrarian() throws CustomException {
		return adminDao.displayLibrarian();
	}// end of displayLibrarian()

}
