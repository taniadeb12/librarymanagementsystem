package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface AdminDao {

	public UsersBean addLibrarian(UsersBean users)  throws CustomException;
	public Boolean deleteLibrarian(int id) throws CustomException;
	public List<UsersBean> displayLibrarian() throws CustomException;
	
	
	
}
