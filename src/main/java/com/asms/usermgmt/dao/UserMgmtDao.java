package com.asms.usermgmt.dao;

import com.asms.Exception.AsmsException;
import com.asms.usermgmt.entity.Management;
import com.asms.usermgmt.entity.Student;
import com.asms.usermgmt.entity.User;
import com.asms.usermgmt.helper.PrincipalUser;
import com.asms.usermgmt.request.UserDetails;

public interface UserMgmtDao {
	
	public void register(User user);
	
	public String getUserRole(String email) throws AsmsException;
	
	public User getUser(String email) throws AsmsException;
	
	public void registerUser(UserDetails userDetails,User user) throws AsmsException;
	
	public void insertStudent(Student student) throws AsmsException;
	
	public void insertManagement(Management management) throws AsmsException;
	

}
