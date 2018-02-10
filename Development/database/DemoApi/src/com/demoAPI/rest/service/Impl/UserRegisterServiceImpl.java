package com.demoAPI.rest.service.Impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoAPI.rest.entity.*;
import com.demoAPI.rest.entity.EmployeeEntity;
import com.demoAPI.rest.entity.Lists;
import com.demoAPI.rest.entity.LoginResponse;
import com.demoAPI.rest.entity.Question;
import com.demoAPI.rest.entity.Questions;
import com.demoAPI.rest.entity.Recent;
import com.demoAPI.rest.entity.RecentQuestions;
//import com.demoAPI.rest.entity.Tags;
//import com.demoAPI.rest.entity.Tags1;
import com.demoAPI.rest.entity.UserEntity;
import com.demoAPI.rest.entity.UserList;
import com.demoAPI.rest.dao.UserRegisterDAO;
import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.service.UserRegisterService;
import com.demoAPI.rest.util.Helper;
import com.demoAPI.rest.dao.HibernateDao;
import com.itextpdf.text.log.SysoCounter;



@Service()
@Transactional(readOnly = false,value="transactionManager", rollbackFor=Exception.class)
public class UserRegisterServiceImpl extends HibernateDao implements UserRegisterService{

	private static final Logger logger = Logger.getLogger(UserRegisterServiceImpl.class);
	@Autowired
	Helper heapler;
	

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	UserRegisterDAO userRegisterDao;
	
	

	
	@Override
	public ResponseDTO getUserRegist(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getUserRegdjf**************");
		ResponseDTO userRegRes = new ResponseDTO();
		UserEntity user=new UserEntity();
		System.out.println("Server: "+userReg.getFname());
	System.out.println("dfjidsjgfkls");
		if(!userReg.getEmailId().isEmpty() && userReg.getEmailId()!= null){
			boolean result = userRegisterDao.checkemailId(userReg);
			boolean resultE = userRegisterDao.checkemailIdE(userReg);
			if(result || resultE){
			//	userRegRes.setReturnCode(1);
				userRegRes.setMessageReturn("This Eamil Already Registered with Snipe");
			}else{
		//	heapler.sendEmail(userReg.getEmailId(), userReg.getFname());
			userRegRes=userRegisterDao.saveUserreg(userReg);
			}
		}else{ 	
		//	userRegRes.setReturnCode(1);
			userRegRes.setMessageReturn("You are not entered e");
			
		}
		return userRegRes;
	}

	@Override
	public LoginResponse getLogin(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getLogin**************");
		ResponseDTO userRegRes = new ResponseDTO();
		UserEntity user=new UserEntity();
		Session session  = currentSession();
		Criteria crc = session.createCriteria(UserEntity.class);
	/*	Query query=session.createQuery("select userentity.userRef from UserEntity userentity where userentity.emailId=:email");
		query.setParameter("email", userReg.getEmailId());*/
		LoginResponse lresponse=new LoginResponse();
		
		boolean result = userRegisterDao.checkemailId(userReg);
		if(result)
		{
		String pwd= userRegisterDao.getpwd(userReg);
		System.out.println(": "+pwd);
		System.out.println(": "+userReg.getEmailId());
		System.out.println(" "+heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId()));
			if(pwd.equals(heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId())))
			{	
				userRegisterDao.updateLoginStatusY(userReg);
			//	userRegRes.setReturnCode(0);
			//	lresponse.setMessageReturn("success");
				Query q=session.createQuery("select emp.ueid from EmployeeEntity emp where emp.emailId=:email");
				q.setParameter("email",userReg.getEmailId());
				System.out.println(q);
				//System.out.println(q);
				lresponse.setMessageReturn("");
				lresponse.setReturnCode(1);
				
				
				/*lresponse.setReturnCode(1);
				userRegRes.setMessageReturn("success");*/
				System.out.println("Login Sussfull");
				
			}else{
				//userRegRes.setReturnCode(1);
				userRegRes.setMessageReturn("oooInvalid EmailId/Password");
				System.out.println("Login UnSussfull");
			}
		}else{
			//userRegRes.setReturnCode(1);
			userRegRes.setMessageReturn("Invalid EmailId/Password");
			System.out.println("Login UnSussfull");
		}
		return lresponse;
		
	}
	
	
	
	
	@Override
	public ResponseDTO answered1(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.Answered**************");
		ResponseDTO userRegRes = new ResponseDTO();
		Question que=new Question();
	    que.setAns(userReg.getAns());
		System.out.println("name"+userReg.getAns());
		boolean result = userRegisterDao.checkanswered(userReg);
		
		userRegRes.setMessageReturn("Answered");
		
		return userRegRes;
	}

	
	
	
	
	
	@Override
	public ResponseDTO getrecentQeustion(RequestDTO userReg) {
		// TODO Auto-generated method stub
	
		
		// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getUsersList**************");
				ResponseDTO response=new ResponseDTO();
				List<Question> RecentQ= userRegisterDao.getRecentQ(userReg);
				if(RecentQ.size()==0){
					//response.setReturnCode(1);
					response.setMessageReturn("There is No User Registered with DEMO-API");
				}else{
			//	response.setReturnCode(0);
			  response.setQuestion1(RecentQ);
				}
				return response;
		
	}
	
	
	@Override
	public List<UserEntity> getUsersList(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getUsersList**************");
		Lists list=new Lists();
		ResponseDTO response=new ResponseDTO();
	//	Lists list=new Lists();
		List<UserEntity> userList= userRegisterDao.getUserList(userReg);
		/*if(userList.size()==0){
			//response.setReturnCode(1);
			response.setMessageReturn("There is No User Registered with DEMO-API");
		}else{
	//	response.setReturnCode(0);*/
	//	response.setUserEntity(userList);
		//}
		return userList;
	}
	
	
	@Override
	public ResponseDTO modifyUser(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.modifyUser**************");
		ResponseDTO response=new ResponseDTO();
		int result = userRegisterDao.modifyUser(userReg);
		if(result>1){
			//response.setReturnCode(0);
			response.setMessageReturn("User emailId modified successfully");
		}else{
			//response.setReturnCode(0);
			response.setMessageReturn("No user found for particular MobileNo");
		}
		return response;
	}

	@Override
	public ResponseDTO deleteUser(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.deleteUser**************");
		ResponseDTO response=new ResponseDTO();
		UserEntity user=new UserEntity();
		boolean result = userRegisterDao.checkemailId(userReg);
		if(result){
			userRegisterDao.deleteUser(userReg);
			//response.setReturnCode(0);
			response.setMessageReturn(user.getName()+" user deleted successfully");
		}else{
			//response.setReturnCode(1);
			response.setMessageReturn("No user found for particular EmailId");
		}
		return response;
	}

	@Override
	public ResponseDTO logoutUser(RequestDTO userReg) {
		logger.info("******UserRegisterServiceImpl.logoutUser**************");
		// TODO Auto-generated method stub
		ResponseDTO response=new ResponseDTO();
		boolean result = userRegisterDao.checkemailId(userReg);
		if(result){
			userRegisterDao.updateLoginStatusN(userReg);
		//	response.setReturnCode(0);
			response.setMessageReturn("Logout successfully");
		}else{
			//response.setReturnCode(1);
			response.setMessageReturn("Something went wrong");
		}
		return response;
	}

	@Override
	public ResponseDTO askquestion(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		logger.info("******UserRegisterDAOImpl.saveUserreg**************");
		// TODO Auto-generated method stub
		String returnMag ="";
		ResponseDTO response= new ResponseDTO();
		
		Session session  = currentSession();
		UserEntity user = new UserEntity();
		Question que=new Question();
		Criteria crc = session.createCriteria(Questions.class);
		
		que.setQuestion(userReg.getQuestion());
		que.setTag_name(userReg.getTag_name());
		que.setRatings(userReg.getRating());
		que.setCreatedate(new Date());
		que.setStatus("N");
		
		
		
	//	user.setLoginStatus("Y");
		session.save(que);
		System.out.println("Saved");
		returnMag = " "+que.getQuestion()+" "+" Question Submitted Successfully";
		returnMag="Question Id is"+que.getQ_id()+"";
	//	response.setReturnCode(0);
		response.setMessageReturn(returnMag);
		return response;

		
		
		
		
	}

	@Override
	public ResponseDTO getEmployeeRegist(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getUserRegdjf**************");
				ResponseDTO userRegRes = new ResponseDTO();
				EmployeeEntity user=new EmployeeEntity();
				System.out.println("Server: "+userReg.getFname());
			System.out.println("dfjidsjgfkls");
				if(!userReg.getEmailId().isEmpty() && userReg.getEmailId()!= null){
					boolean resultE = userRegisterDao.checkemailIdE(userReg);
					boolean result = userRegisterDao.checkemailId(userReg);
					if(result || resultE){
					//	userRegRes.setReturnCode(1);
						userRegRes.setMessageReturn("This Eamil Already Registered with Snipe");
					}else{
				//	heapler.sendEmail(userReg.getEmailId(), userReg.getFname());
					userRegRes=userRegisterDao.saveEmprreg(userReg);
					}
				}else{ 	
				//	userRegRes.setReturnCode(1);
					userRegRes.setMessageReturn("You are not entered e");
					
				}
				return userRegRes;

		

	}

	@Override
	public ResponseDTO getTags(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
	
		
	ResponseDTO userRegRes=new ResponseDTO();
	Session session=currentSession();
	Criteria crt=session.createCriteria(Question.class);

Answeres ans=new Answeres();
Question que=new Question();


	que.setCreatedate(new Date());
	

	que.setCreatedate(new Date());

	System.out.println("question is" +userReg.getQuestion());

	session.save(que);
	
		
		userRegRes.setReturnMsg("Saved");
	
	
	
	

	userRegRes.setMessageReturn("This question is submitted and added to corresponding tags");
	return userRegRes;	
		
		
		
	
	}

	@Override
	public ResponseDTO answered(RequestDTO userReg) {
		// TODO Auto-generated method stub
		ResponseDTO response=new ResponseDTO();
		
		List<Question> queList= userRegisterDao.getqueList(userReg);
		response.setQuestion1(queList);
		return response;
		

	}


		
		

	@Override
	public ResponseDTO resetPwd(RequestDTO userReg) {
		// TODO Auto-generated method stub
		ResponseDTO response=new ResponseDTO();
		
		UserEntity user=new UserEntity();
		String email=user.setSendedmail(userReg.getEmailId());
		com.demoAPI.rest.service.Impl.send Send=new send();
System.out.println("email"+userReg.getEmailId());
		try
		
		{ 
			Send.otp(email);
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		response.setReturnMsg("OTP sent ");
		return response;
	}

	@Override
	public ResponseDTO getupdatepwd(RequestDTO userReg) {
	
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ResponseDTO deleteEmployee(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.deleteUser**************");
		ResponseDTO response=new ResponseDTO();
	EmployeeEntity user=new EmployeeEntity();
		boolean result = userRegisterDao.checkEmpId(userReg);
		if(result)
		{
			userRegisterDao.deleteEmployee(userReg);
			//response.setReturnCode(0);
			response.setMessageReturn(user.getFname()+" user deleted successfully");
		}else{
			//response.setReturnCode(1);
			response.setMessageReturn("No user found for particular MobileNo");
		}
		return response;
		
		
		
	
	}

	@Override
	public List<Recent> getrecentList(RequestDTO userReg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDTO getPopularq(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		logger.info("******UserRegisterServiceImpl.getUsersList**************");
		ResponseDTO response=new ResponseDTO();
		List<Question> popularlist= userRegisterDao.getPopularQ(userReg);
		//System.out.println(popularlist);
		if(popularlist.size()==0){
			//response.setReturnCode(1);
			response.setMessageReturn("There is No User Registered with DEMO-API");
		}else{
	//	response.setReturnCode(0);
	 response.setQuestion1(popularlist);
		}
		return response;
		
		
	}

	@Override
	public List<EmployeeEntity> getEmployeeList(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		
		logger.info("******UserRegisterServiceImpl.getEmployeeList**************");
		ResponseDTO response=new ResponseDTO();
	//	List<EmployeeEntity> list=new UserList();
		List<EmployeeEntity> empList= userRegisterDao.getEmployeeList(userReg);
		if(empList.size()==0){
			//response.setReturnCode(1);
			response.setMessageReturn("There is No User Registered with DEMO-API");
		}else{
	//	response.setReturnCode(0);
			response.setEmployeeentity(empList);
	//  list.setEmplist(empList);
		}
		return empList;
		
		
		
	}

	@Override
	public List<Question>getrecentQeustionQs(RequestDTO userReg) {
		// TODO Auto-generated method stub
	
		
		logger.info("******UserRegisterServiceImpl.getQuestionsList**************");
		ResponseDTO response=new ResponseDTO();
	//	RecentQuestions recentQs=new RecentQuestions();
		List<Question> recentQ= userRegisterDao.getrecentQuestionQs(userReg);
		if(recentQ.size()==0){
			//response.setReturnCode(1);
			response.setMessageReturn("There is No User Registered with DEMO-API");
		}else{
	//	response.setReturnCode(0);
			response.setQuestion1(recentQ);
		}
		return recentQ;	
		}

	@Override
	public ResponseDTO ContactUs(RequestDTO userReg) {
		// TODO Auto-generated method stub
		String returnMag="";
		ResponseDTO response=new ResponseDTO();
		Session session=currentSession();
		ContactUs contact =new ContactUs();
		Criteria crc = session.createCriteria(ContactUs.class);
		contact.setEmailId(userReg.getEmailId());
		contact.setMessage(userReg.getMessage());
		contact.setName(userReg.getName());
		session.save(contact);
		System.out.println("Saved");
		returnMag = "Congratulations!!"+contact.getName() +" Your message submitted";
	//	response.setReturnCode(0);
		response.setMessageReturn(returnMag);
		return response;

		
//		return null;
	}

	@Override
	public ResponseDTO upDateEmployee(RequestDTO userReg) {
		// TODO Auto-generated method stub
		ResponseDTO response=new ResponseDTO();
		
	//	Response response = CommonUtils.getResponseObject("Update employee data");
		try {
		//	String sql = "UPDATE employee_register SET username=?,email=?,password=?,phoneNumber=? WHERE emp_id=?";
			String hql="update employee set fname=:fname,emailId=:email, pwd=:password,lname=:lname,qualification=:qualification where emailId=:email";

			int res = jdbcTemplate.update(hql,userReg.getFname(),userReg.getLname(),userReg.getEmailId(),userReg.getPwd(),userReg.getQualification());
			

			if (res == 1) {
				response.setMessageReturn("Success");
			} else {
				//response.setStatus(StatusCode.ERROR.name());
			}
		} catch (Exception e) {
			logger.error("Exception in update employee data", e);
		//	response.setStatus(StatusCode.ERROR.name());
		//	response.setErrors(e.getMessage());
		}
		return response;
	//	return null;
	}

	@Override
	public LoginResponse getLoginE(RequestDTO userReg) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getLogin**************");
		ResponseDTO userRegRes = new ResponseDTO();
		EmployeeEntity user=new EmployeeEntity();
		Session session  = currentSession();
		Criteria crc = session.createCriteria(EmployeeEntity.class);
	/*	Query query=session.createQuery("select userentity.userRef from UserEntity userentity where userentity.emailId=:email");
		query.setParameter("email", userReg.getEmailId());*/
		LoginResponse lresponse=new LoginResponse();
		
		boolean result = userRegisterDao.checkemailIdE(userReg);
		if(result)
		{
		String pwd= userRegisterDao.getpwdE(userReg);
		
		System.out.println(": "+pwd);
		System.out.println(": "+userReg.getEmailId());
		//System.out.println(" "+heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId()));
			if(pwd.equals(heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId())))
			{	
				System.out.println("dfjkldsjlk");
			System.out.println(userRegisterDao.updateLoginStatusYE(userReg));
			//	userRegRes.setReturnCode(0);
				lresponse.setMessageReturn("success");
				lresponse.setReturnCode(userRegisterDao.updateLoginStatusYE(userReg));
			//	userRegRes.setMessageReturn("Login successfully"+user.getUserRef());
				System.out.println("Login Sussfull");
				
			}else{
				//userRegRes.setReturnCode(1);
				userRegRes.setMessageReturn("oooInvalid EmailId/Password");
				System.out.println("Login UnSussfull");
			}
		}else{
			//userRegRes.setReturnCode(1);
			userRegRes.setMessageReturn("Invalid EmailId/Password");
			System.out.println("Login UnSussfull");
		}
		return lresponse;
	
	}
	
}
