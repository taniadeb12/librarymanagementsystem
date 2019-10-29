package com.capgemini.librarymanagementsystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public String validateId(String Id) {

		Pattern pattern = Pattern.compile("T(-?[0-9]+)");
		Matcher matcher = pattern.matcher(Id);
		if(matcher.matches()) {
			return Id;
		} else {
			return null;
		}
	}
	public String validateEmail(String emailId) {
		Pattern pattern = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher matcher = pattern.matcher(emailId);
		if(matcher.matches()) {
			return emailId;
		} else {
			return null;
		}
	}
	public String validatePassword(String password) {
		Pattern pattern = Pattern.compile("((?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@!#$%]).{8,10}");
		Matcher matcher = pattern.matcher(password);
		if(matcher.matches()) {
			return password;
		} else {
			return null;
		}
	}
	public Long validateContact(String contactNo) {
		Pattern pattern = Pattern.compile("\\d{10}");
		Matcher matcher = pattern.matcher(contactNo);
		if(matcher.matches()) {
			return Long.parseLong(contactNo);
		} else {
			return null;
		}
	}
}
