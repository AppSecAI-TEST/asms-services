package com.asms.usermgmt.dao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asms.Exception.AsmsException;
import com.asms.rolemgmt.entity.Role;
import com.asms.rolemgmt.entity.SubRole;
import com.asms.usermgmt.entity.Management;
import com.asms.usermgmt.entity.NonTeachingStaff;
import com.asms.usermgmt.entity.Student;
import com.asms.usermgmt.entity.TeachingStaff;
import com.asms.usermgmt.entity.User;
import com.asms.usermgmt.request.UserDetails;

public interface UserMgmtDao {
	

	public String getUserRole(String email) throws AsmsException;
	
	public String registerUser(UserDetails userDetails, User user) throws AsmsException;

	public User getUser(String email) throws AsmsException;

	public void insertUser(User user) throws AsmsException;

	public Role getRoleObject(String roleName) throws AsmsException;

	public SubRole getSubRoleObject(String roleName) throws AsmsException;

	public void insertStudent(Student student) throws AsmsException;
	
	public void insertManagement(Management management) throws AsmsException;

	public void insertTeachingStaff(TeachingStaff teachingStaff) throws AsmsException;


	boolean authenticate(HttpServletRequest request, HttpServletResponse response, String email, String password)
			throws AsmsException;
	
	public void insertNonTeachingStaff(NonTeachingStaff nonTeachingStaff) throws AsmsException;
	

}
