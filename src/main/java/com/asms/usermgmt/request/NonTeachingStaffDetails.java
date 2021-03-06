/**
@{author} mallikarjun.guranna
09-Aug-2017
*/
package com.asms.usermgmt.request;

import java.util.Date;

public class NonTeachingStaffDetails {
	/**
	@{author} mallikarjun.guranna
	09-Aug-2017
	*/
	
	
	
	private String designation;
	private String firstName;
	private String middleName;
	private String lastName;
	private boolean flagMakeAdmin;
	private Date dob;
	private String gender;
	private int ageInYears;
	private long contactNo;
	private String qualification;
	
	private String religion;
	private String casteCategory;
	private String photo;
	private String maritalStatus;
	private String spouseName;
	private long spouseContactNo;
	
	private String schoolId;
	private String createdByWadmin;
	private Date creationTime;
	private String status;
	
	private AddressDetails addressDetails;
	
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean getFlagMakeAdmin() {
		return flagMakeAdmin;
	}
	public void setFlagMakeAdmin(boolean flagMakeAdmin) {
		this.flagMakeAdmin = flagMakeAdmin;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAgeInYears() {
		return ageInYears;
	}
	public void setAgeInYears(int ageInYears) {
		this.ageInYears = ageInYears;
	}
	public long getContactNo() {
		return contactNo;
	}
	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getCasteCategory() {
		return casteCategory;
	}
	public void setCasteCategory(String casteCategory) {
		this.casteCategory = casteCategory;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public long getSpouseContactNo() {
		return spouseContactNo;
	}
	public void setSpouseContactNo(long spouseContactNo) {
		this.spouseContactNo = spouseContactNo;
	}
	public String getCreatedByWadmin() {
		return createdByWadmin;
	}
	public void setCreatedByWadmin(String createdByWadmin) {
		this.createdByWadmin = createdByWadmin;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AddressDetails getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}
}
