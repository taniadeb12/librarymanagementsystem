package com.capgemini.librarymanagementsystem.dao;

import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface LoginDao {

	public UsersBean login(UsersBean users) throws CustomException ;
}
