package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.beans.UsersBean;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface LoginService {

	public UsersBean login(UsersBean users) throws CustomException ;
}
