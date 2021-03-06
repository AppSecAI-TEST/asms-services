package com.asms.usermgmt.service;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.asms.Exception.AsmsException;
import com.asms.common.helper.AsmsHelper;
import com.asms.common.response.FailureResponse;
import com.asms.common.response.SuccessResponse;
import com.asms.common.service.BaseService;
import com.asms.usermgmt.auth.PrivilegesManager;
import com.asms.usermgmt.dao.UserMgmtDao;
import com.asms.usermgmt.entity.User;
import com.asms.usermgmt.helper.PrincipalUser;
import com.asms.usermgmt.helper.Validator;
import com.asms.usermgmt.request.UserDetails;
import com.asms.usermgmt.request.UserRequest;
import com.asms.usermgmt.response.RegistrationResponse;

/*
 * UserMgmtService.java handles user registration, update and delete 
 * functionalities
 */

@Service
@Component
@Path("/user")

public class UserMgmtService extends BaseService {

	@Autowired
	private UserMgmtDao userMgmtDao;

	@Autowired
	private PrivilegesManager privilegesManager;

	@Autowired
	private Validator validator;

	private static final Logger logger = LoggerFactory.getLogger(UserMgmtService.class);

	/*
	 * api : /user/register request type :POST
	 * 
	 * Method : register -> This method does the creation of user object. Input :
	 * UserRequest object outbut: Response object *
	 * 
	 * 
	 */

	@Path("/register")
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response register(@Context HttpServletRequest hRequest, @Context HttpServletResponse hResponse,
			UserRequest userRequest) {
		RegistrationResponse rReponse = new RegistrationResponse();
		try {
			// validate request
			validator.validateRequest(userRequest);
			HttpSession session = hRequest.getSession();
			User user = (User) session.getAttribute("ap_user");
			// authorize

			// check if logged in user has got rights to create user
			PrincipalUser pUser = privilegesManager.isPrivileged(user, userRequest.getUserRole(),
					userRequest.getRequestType());
			if (pUser.isPrivileged()) {
				UserDetails userDetails = userRequest.getUserDetails();
				userDetails.setRole(userRequest.getUserRole());
				String userid =userMgmtDao.registerUser(userDetails, user);
				rReponse.setIsNew("true");
				rReponse.setUserId(userid);
				rReponse.setProgressPercentage(20);
				return Response.status(Status.OK).entity(rReponse).build();

			} else {
				// throw authorization error
			}

			return Response.status(200).entity("success").build();
		} catch (AsmsException ex) {
			// construct failure response
			FailureResponse failureResponse = new FailureResponse(ex);
			return Response.status(Status.EXPECTATION_FAILED).entity(failureResponse).build();
		}
	}
	
	
	//-------------------------------------------
	@Path("/register/additionalDetails")
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response registerAdditionalDetails(@Context HttpServletRequest hRequest, @Context HttpServletResponse hResponse,UserRequest userRequest) {
		RegistrationResponse rReponse = new RegistrationResponse();
		try {
			// validate request
			validator.validateRequest(userRequest);
			HttpSession session = hRequest.getSession();
			User user = (User) session.getAttribute("ap_user");
			// authorize
			
			//check if logged in user has got rights to create user
			PrincipalUser pUser = privilegesManager.isPrivileged(user, userRequest.getUserRole(),
					userRequest.getRequestType());
			if(pUser.isPrivileged()) {
				UserDetails userDetails = userRequest.getUserDetails();
				userDetails.setRole(userRequest.getUserRole());
				String userid =userMgmtDao.registerUser(userDetails,user);
				rReponse.setIsNew("true");
				rReponse.setUserId(userid);
				rReponse.setProgressPercentage(20);
				return Response.status(Status.OK).entity(rReponse).build();

			}else {
				//  throw authorization error
			}
			
			

			return Response.status(200).entity("success").build();
		} catch (AsmsException ex) {
			// construct failure response
			FailureResponse failureResponse = new FailureResponse(ex);
			return Response.status(Status.EXPECTATION_FAILED).entity(failureResponse).build();
		}
	}
	
	
	

	/*
	 * api : /user/login request type :POST
	 * 
	 * Method : login -> This method does login authentication input : UserRequest
	 * object outbut: Response object
	 * 
	 * 
	 */

	@Path("/login")
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response login(@Context HttpServletRequest hRequest, @Context HttpServletResponse hResponse,
			UserDetails userDetails) {
		Response response = null;
		FailureResponse failureResponse = new FailureResponse();
		// get the error code and description from resource bundles
		ResourceBundle messages = AsmsHelper.getMessageFromBundle();
		try {

			SuccessResponse successRespone = new SuccessResponse();

			if (null == userDetails) {
				
				
				failureResponse.setCode(Integer.parseInt(messages.getString("REQUEST_NULL_CODE")));
				failureResponse.setErrorDescription(messages.getString("REQUEST_NULL"));

				return response = Response.status(Status.EXPECTATION_FAILED).entity(failureResponse).build();
			} else {
				boolean result = userMgmtDao.authenticate(hRequest, hResponse, userDetails.getEmail(),
						userDetails.getUserPassword());
				if (result) {
					return Response.status(Status.OK).entity(successRespone).build();
				}else {
					failureResponse.setCode(Integer.parseInt(messages.getString("AUTHENTICATION_FAILED_CODE")));
					failureResponse.setErrorDescription(messages.getString("AUTHENTICATION_FAILED_MSG"));
					return Response.status(Status.EXPECTATION_FAILED).entity(failureResponse).build();
				}
				

			}
		} catch (AsmsException ex) {
			// construct failure response
			return Response.status(Status.EXPECTATION_FAILED).entity(failureResponse).build();
		}
		
	}

}
