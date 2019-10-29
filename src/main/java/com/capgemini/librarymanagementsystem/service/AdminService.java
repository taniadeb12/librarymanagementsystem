package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface AdminService {

	public UsersBean addLibrarian(UsersBean users)  throws CustomException;
	public Boolean deleteLibrarian(int id) throws CustomException;
	public List<UsersBean> displayLibrarian() throws CustomException;


}
