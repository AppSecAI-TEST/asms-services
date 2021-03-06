package com.asms.usermgmt.helper;

import java.util.ResourceBundle;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asms.Exception.AsmsException;
import com.asms.Exception.ExceptionHandler;
import com.asms.common.helper.AsmsHelper;
import com.asms.common.helper.Constants;
import com.asms.usermgmt.request.ManagementDetails;
import com.asms.usermgmt.request.NonTeachingStaffDetails;
import com.asms.usermgmt.request.StudentDetails;
import com.asms.usermgmt.request.TeachingStaffDetails;
import com.asms.usermgmt.request.UserRequest;

/*
 * Validator.java does the validation of requests
 * 
 */

@Component
public class Validator {

	@Autowired
	private ExceptionHandler exceptionHandler;

	/*
	 * Method: validateRequest -> validates userRequest for null. Parameters ->
	 * UserRequest throws -> AsmsException
	 */

	public void validateRequest(UserRequest request) throws AsmsException {
		ResourceBundle messages = AsmsHelper.getMessageFromBundle();

		if (null == request) {
			throw exceptionHandler.constructAsmsException(messages.getString("REQUEST_NULL_CODE"),
					messages.getString("REQUEST_NULL"));

		}
		if (null == request.getRequestType() || request.getRequestType().trim().isEmpty()) {
			throw exceptionHandler.constructAsmsException(messages.getString("REQUEST_TYPE_NULL_CODE"),
					messages.getString("REQUEST_TYPE_NULL"));
		}

		
		if (null == request.getUserRole() || request.getUserRole().trim().isEmpty()) {
			throw exceptionHandler.constructAsmsException(messages.getString("LOGGEDINUSER_EMAIL_NULL_CODE"),
					messages.getString("NEW_USER_ROLE_NULL"));

		}
		if (null == request.getUserDetails()) {
			throw exceptionHandler.constructAsmsException(messages.getString("USER_OBJECT_NULL_CODE"),
					messages.getString("USER_OBJECT_NULL"));
		}

		// email validation starts
		if (null == request.getUserDetails().getEmail() || request.getUserDetails().getEmail().trim().isEmpty()) {
			throw exceptionHandler.constructAsmsException(messages.getString("USER_EMAIL_NULL_CODE"),
					messages.getString("USER_EMAIL_NULL"));
		} else {
			EmailValidator emailValidator = EmailValidator.getInstance();
			if (!emailValidator.isValid(request.getUserDetails().getEmail())) {
				throw exceptionHandler.constructAsmsException(messages.getString("EMAIL_INVALID_CODE"),
						messages.getString("EMAIL_INVALID"));
			}
		}
		// email validation ends

		if (request.getUserRole().equalsIgnoreCase(Constants.role_student)) {

			// student validation starts
			StudentDetails studentDetails = request.getUserDetails().getStudenrDetails();

			if (null == studentDetails) {
				throw exceptionHandler.constructAsmsException(messages.getString("STUDENT_DETAILS_NULL_CODE"),
						messages.getString("STUDENT_DETAILS_NULL"));
			} else {
				if (null == studentDetails.getAdmissionNo() || studentDetails.getAdmissionNo().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_ADMISSION_NO_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_ADMISSION_NO_NULL"));

				}
				if (null == studentDetails.getStudentType() || studentDetails.getStudentType().isEmpty()) {
					throw exceptionHandler.constructAsmsException(messages.getString("STUDENT_DETAILS_TYPE_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_TYPE_NULL"));
				}

				if (null == studentDetails.getAdmissionDate()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_ADMISSION_DATE_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_ADMISSION_DATE_NULL"));

				}

				if (null == studentDetails.getStudentClass() || studentDetails.getStudentClass().isEmpty()) {
					throw exceptionHandler.constructAsmsException(messages.getString("STUDENT_DETAILS_CLASS_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_CLASS_NULL"));

				}
				if (null == studentDetails.getStudentSection() || studentDetails.getStudentSection().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_SECTION_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_SECTION_NULL"));

				}
				if (null == studentDetails.getStudentFirstName() || studentDetails.getStudentFirstName().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_FIRSTNAME_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_FIRSTNAME_NULL"));

				}
				if (null == studentDetails.getStudentLastName() || studentDetails.getStudentLastName().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_LASTNAME_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_LASTNAME_NULL"));

				}

				if (null == studentDetails.getStudentDob()) {
					throw exceptionHandler.constructAsmsException(messages.getString("STUDENT_DETAILS_DOB_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_DOB_NULL"));

				}

				if (null == studentDetails.getStudentGender() || studentDetails.getStudentGender().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_GENDER_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_GENDER_NULL"));

				}

				if (null == studentDetails.getStudentIdentificationMarks()
						|| studentDetails.getStudentIdentificationMarks().isEmpty()) {
					throw exceptionHandler.constructAsmsException(messages.getString("STUDENT_DETAILS_IMARK_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_IMARK_NULL"));

				}
				if (studentDetails.getStudentAgeInYears() <= 0) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_AGE_INVALID_CODE"),
							messages.getString("STUDENT_DETAILS_AGE_INVALID"));

				}
				if (null == studentDetails.getStudentBirthplace() || studentDetails.getStudentBirthplace().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_BIRTHPLACE_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_BIRTHPLACE_NULL"));

				}
				if (null == studentDetails.getStudentNationality()
						|| studentDetails.getStudentNationality().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_NATIONALITY_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_NATIONALITY_NULL"));

				}
				if (null == studentDetails.getStudentReligion() || studentDetails.getStudentReligion().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_RELIGION_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_RELIGION_NULL"));

				}
				if (null == studentDetails.getStudentCasteCategory()
						|| studentDetails.getStudentCasteCategory().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_CASTE_CATEGORY_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_CASTE_CATEGORY_NULL"));

				}
				if (null == studentDetails.getStudentSubCaste() || studentDetails.getStudentSubCaste().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_SUB_CASTE_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_SUB_CASTE_NULL"));

				}
				if (null == studentDetails.getStudentMotherTongue()
						|| studentDetails.getStudentMotherTongue().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_MOTHERTOUNGUE_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_MOTHERTOUNGUE_NULL"));

				}
				if (null == studentDetails.getStudentPhoto() || studentDetails.getStudentPhoto().isEmpty()) {
					throw exceptionHandler.constructAsmsException(
							messages.getString("STUDENT_DETAILS_SECTION_NULL_CODE"),
							messages.getString("STUDENT_DETAILS_SECTION_NULL"));

				}

			}

		} else if (request.getUserRole().equalsIgnoreCase(Constants.role_management)) {

			ManagementDetails managementDetails = request.getUserDetails().getManagementDetails();

			if (null == managementDetails)
				throw exceptionHandler.constructAsmsException(
						messages.getString("MGMT_DETAILS_NULL_CODE"),
						messages.getString("MGMT_DETAILS_NULL_CODE"));

			if ((null == managementDetails.getMngmtFirstName()) || (managementDetails.getMngmtFirstName().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("MGMT_DETAILS_MNGMTFIRSTNAME_NULL_CODE"),
						messages.getString("MGMT_DETAILS_MNGMTFIRSTNAME_NULL_MSG"));

			if ((null == managementDetails.getMngmtMiddleName()) || (managementDetails.getMngmtMiddleName().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("MGMT_DETAILS_MNGMTMIDDLENAME_NULL_CODE"),
						messages.getString("MGMT_DETAILS_MNGMTMIDDLENAME_NULL_MSG"));

			if ((null == managementDetails.getMngmtLastName()) || (managementDetails.getMngmtLastName().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("MGMT_DETAILS_MNGMTLASTNAME_NULL_CODE"),
						messages.getString("MGMT_DETAILS_MNGMTLASTNAME_NULL_MSG"));

			if (((null == managementDetails.getMngmtDesignation())
					|| managementDetails.getMngmtDesignation().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("MGMT_DETAILS_MNGMTDESIGNATION_NULL_CODE"),
						messages.getString("MGMT_DETAILS_MNGMTDESIGNATION_NULL_MSG"));

			if ((null == managementDetails.getMngmtContactNo()) || (managementDetails.getMngmtContactNo().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("MGMT_DETAILS_MNGMTCONTACTNO_NULL_CODE"),
						messages.getString("MGMT_DETAILS_MNGMTCONTACTNO_NULL_MSG"));

		
		} else if (request.getUserRole().equalsIgnoreCase(Constants.role_teaching_staff)) {

			TeachingStaffDetails teachingStaffDetails = request.getUserDetails().getTeachingStaffDetails();

			if (null == teachingStaffDetails)
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_DETAILS_NULL_CODE"),
						messages.getString("TEACHING_STAFF_DETAILS_NULL_MSG"));

			if ((null == teachingStaffDetails.getDesignation()) || (teachingStaffDetails.getDesignation().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_DESIGNATION_NULL_CODE"),
						messages.getString("TEACHING_STAFF_DESIGNATION_NULL_MSG"));

			if ((null == teachingStaffDetails.getFirstName()) || (teachingStaffDetails.getFirstName().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_FIRST_NAME_NULL_CODE"),
						messages.getString("TEACHING_STAFF_FIRST_NAME_NULL_MSG"));

			if ((null == teachingStaffDetails.getMiddleName()) || (teachingStaffDetails.getMiddleName().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_MIDDLE_NAME_NULL_CODE"),
						messages.getString("TEACHING_STAFF_NULL_MSG"));

			if (((null == teachingStaffDetails.getLastName()) || teachingStaffDetails.getLastName().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_LAST_NAME_NULL_CODE"),
						messages.getString("TEACHING_STAFF_LAST_NAME_NULL_MSG"));

			if (teachingStaffDetails.isFlagMakeAdmin())
				throw exceptionHandler.constructAsmsException(
						messages.getString("MGMT_DETAILS_MNGMTCONTACTNO_NULL_CODE"),
						messages.getString("MGMT_DETAILS_MNGMTCONTACTNO_NULL_MSG"));

			if ((null == teachingStaffDetails.getDob()) || (teachingStaffDetails.getDob().toString().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_DOB_NULL_CODE"),
						messages.getString("TEACHING_STAFF_DOB_NULL_MSG"));

			if ((null == teachingStaffDetails.getGender()) || (teachingStaffDetails.getGender().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_GENDER_NULL_CODE"),
						messages.getString("TEACHING_STAFF_GENDER_NULL_MSG"));

			if ((0 == teachingStaffDetails.getAgeInYears()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_AGE_IN_YEARS_NULL_CODE"),
						messages.getString("TEACHING_STAFF_AGE_IN_YEARS_NULL_MSG"));

			if (teachingStaffDetails.getContactNo() == 0)
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_CONTACT_NO_NULL_CODE"),
						messages.getString("TEACHING_STAFF_CONTACT_NO_NULL_MSG"));

			if ((null == teachingStaffDetails.getQualification())
					|| (teachingStaffDetails.getQualification().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_QUALIFICATION_NULL_CODE"),
						messages.getString("TEACHING_STAFF_QUALIFICATION_NULL_MSG"));

			if ((null == teachingStaffDetails.getReligion()) || (teachingStaffDetails.getReligion().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_RELIGION_NULL_CODE"),
						messages.getString("TEACHING_STAFF_RELIGION_NULL_MSG"));

			if ((null == teachingStaffDetails.getCasteCategory())
					|| (teachingStaffDetails.getCasteCategory().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_CASTE_CATEGORY_NULL_CODE"),
						messages.getString("TEACHING_STAFF_CASTE_CATEGORY_NULL_MSG"));

			if ((null == teachingStaffDetails.getPhoto()) || (teachingStaffDetails.getPhoto().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_PHOTO_NULL_CODE"),
						messages.getString("TEACHING_STAFF_PHOTO_NULL_MSG"));

			if ((null == teachingStaffDetails.getClassesHandled())
					|| (teachingStaffDetails.getClassesHandled().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_CLASSES_HANDLED_NULL_CODE"),
						messages.getString("TEACHING_STAFF_CLASSES_HANDLED_NULL_MSG"));

			if ((null == teachingStaffDetails.getSubjectsHandled())
					|| (teachingStaffDetails.getSubjectsHandled().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_SUBJECTS_HANDLED_NULL_CODE"),
						messages.getString("TEACHING_STAFF_SUBJECTS_HANDLED_NULL_MSG"));

			if ((null == teachingStaffDetails.getMaritalStatus())
					|| (teachingStaffDetails.getMaritalStatus().isEmpty()))
				throw exceptionHandler.constructAsmsException(
						messages.getString("TEACHING_STAFF_MARITAL_STATUS_NULL_CODE"),
						messages.getString("TEACHING_STAFF_MARITAL_STATUS_NULL_MSG"));

			/*
			 * these two values are not mandatory fields
			 * 
			 * if( ( null == teachingStaffDetails.getSpouseName()
			 * )||(teachingStaffDetails.getSpouseName().isEmpty()) ) throw
			 * exceptionHandler.constructAsmsException(messages.getString(
			 * "MGMT_DETAILS_MNGMTEMAILID_NULL_CODE"),
			 * messages.getString("MGMT_DETAILS_MNGMTEMAILID_NULL_MSG"));
			 * 
			 * if( (teachingStaffDetails.getContactNo() == 0)) throw
			 * exceptionHandler.constructAsmsException(messages.getString(
			 * "MGMT_DETAILS_MNGMTEMAILID_NULL_CODE"),
			 * messages.getString("MGMT_DETAILS_MNGMTEMAILID_NULL_MSG"));
			 */

		} else if (request.getUserRole().equalsIgnoreCase(Constants.role_non_teaching_staff)) {
			NonTeachingStaffDetails nonTeachingStaffDetails = request.getUserDetails().getNonTeachingStaffDetails();
			
			if (null == nonTeachingStaffDetails)
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_DETAILS_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_DETAILS_NULL_MSG"));
			
			if (null == nonTeachingStaffDetails.getDesignation() ||nonTeachingStaffDetails.getDesignation().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_DESIGNATION_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_DESIGNATION_NULL_MSG"));
			
			if (null == nonTeachingStaffDetails.getFirstName() || nonTeachingStaffDetails.getFirstName().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_FIRST_NAME_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_FIRST_NAME_NULL_MSG"));
			
			if (null == nonTeachingStaffDetails.getMiddleName() || nonTeachingStaffDetails.getMiddleName().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_MIDDLE_NAME_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_MIDDLE_NAME_NULL_MSG"));
			
			if (null == nonTeachingStaffDetails.getLastName() || nonTeachingStaffDetails.getLastName().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_LAST_NAME_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_LAST_NAME_NULL_MSG"));
			
			if (nonTeachingStaffDetails.getDob().toString().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_DOB_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_DOB_NULL_MSG"));
			
			if (null == nonTeachingStaffDetails.getGender() || nonTeachingStaffDetails.getGender().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_GENDER_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_GENDER_NULL_MSG"));
			
			if (0 == nonTeachingStaffDetails.getAgeInYears())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_AGE_IN_YEARS_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_AGE_IN_YEARS_NULL_MSG"));
			
			if (0 == nonTeachingStaffDetails.getContactNo())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_CONTACT_NO_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_CONTACT_NO_NULL_MSG"));
			
			if (null == nonTeachingStaffDetails.getQualification() || nonTeachingStaffDetails.getQualification().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_QUALIFICATION_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_QUALIFICATION_NULL_MSG"));
			
			if (null == nonTeachingStaffDetails.getReligion() || nonTeachingStaffDetails.getReligion().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_RELIGION_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_RELIGION_NULL_MSG"));
			
			if (null == nonTeachingStaffDetails.getCasteCategory() || nonTeachingStaffDetails.getCasteCategory().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_CASTE_CATEGORY_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_CASTE_CATEGORY_NULL_MSG"));
			
			if (null == nonTeachingStaffDetails.getPhoto() || nonTeachingStaffDetails.getPhoto().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_PHOTO_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_PHOTO_NULL_MSG"));
			
			if (null == nonTeachingStaffDetails.getMaritalStatus() || nonTeachingStaffDetails.getMaritalStatus().isEmpty())
				throw exceptionHandler.constructAsmsException(
						messages.getString("NON_TEACHING_STAFF_MARITAL_STATUS_NULL_CODE"),
						messages.getString("NON_TEACHING_STAFF_MARITAL_STATUS_NULL_MSG"));
		}
		// invalid role sent
		else{
			throw exceptionHandler.constructAsmsException(messages.getString("ROLE_INVALID_CODE"),
					messages.getString("ROLE_INVALID"));
		}
		}
	}