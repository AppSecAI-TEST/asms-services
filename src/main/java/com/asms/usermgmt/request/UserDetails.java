package com.asms.usermgmt.request;

/* UserDetails class represents the user create request object
 * for user management operations 
 * 
 */

public class UserDetails {

	private String userId;	
	
	private String email;	
	
	private String userPassword;	
	
	private String role;	
	
	private String subRole;
	
	private StudentDetails studentDetails;
	
	private ManagementDetails managementDetails;  

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSubRole() {
		return subRole;
	}

	public void setSubRole(String subRole) {
		this.subRole = subRole;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public ManagementDetails getManagementDetails() {
		return managementDetails;
	}

	public void setManagementDetails(ManagementDetails managementDetails) {
		this.managementDetails = managementDetails;
	}


	
	
	
}
