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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoAPI.rest.entity.Answeres;
import com.demoAPI.rest.entity.EmployeeEntity;
import com.demoAPI.rest.entity.Lists;
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
	@Autowired
	UserRegisterDAO userRegisterDao;
	
	

	
	@Override
	public ResponseDTO getUserRegist(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getUserRegdjf**************");
		ResponseDTO userRegRes = new ResponseDTO();
		UserEntity user=new UserEntity();
		System.out.println("Server: "+userReg.getFname());
	
		if(!userReg.getEmailId().isEmpty() && userReg.getEmailId()!= null){
			boolean result = userRegisterDao.checkemailId(userReg);
			if(result){
			//	userRegRes.setReturnCode(1);
				userRegRes.setMessageReturn("This Eamil Already Registered with DEMOAPI");
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
	public ResponseDTO getLogin(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getLogin**************");
		ResponseDTO userRegRes = new ResponseDTO();
		UserEntity user=new UserEntity();
		Session session  = currentSession();
		Criteria crc = session.createCriteria(UserEntity.class);
	/*	Query query=session.createQuery("select userentity.userRef from UserEntity userentity where userentity.emailId=:email");
		query.setParameter("email", userReg.getEmailId());*/
		
		
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
				userRegRes.setMessageReturn("Login successfully"+user.getUserRef());
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
		return userRegRes;
		
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
		boolean result = userRegisterDao.modifyUser(userReg);
		if(result){
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
		logger.info("******UserRegisterDAOImpl.saveUserreg**************");
		// TODO Auto-generated method stub
		String returnMag ="";
		ResponseDTO response= new ResponseDTO();
		Session session  = currentSession();
		UserEntity user = new UserEntity();
		EmployeeEntity emp=new EmployeeEntity();
		Criteria crc = session.createCriteria(EmployeeEntity.class);
		emp.setFname(userReg.getFname());
		emp.setLname(userReg.getLname());
		emp.setDob(userReg.getDob());
		emp.setAddress(userReg.getAddress());
		emp.setEmailId(userReg.getEmailId());
		//user.setDob("");
		//user.setName(userReg.getName());
		emp.setMobileNo(userReg.getMobileNo());
		//user.setAddress(userReg.getAddress());
		emp.setPwd(userReg.getPwd());
		emp.setState(userReg.getState());
		emp.setCountry(userReg.getCountry());
		emp.setGender("Male");
		emp.setDate(new Date());
		emp.setPwd(heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId()));
		emp.setLoginStatus("N");
		session.save(emp);
		System.out.println("Saved");
		returnMag = "Congratulations!!"+user.getName() +" Registration successfull";
		
	//	response.setReturnCode(0);
		response.setMessageReturn(returnMag);
		return response;


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
		boolean result = userRegisterDao.checkemailIdE(userReg);
		if(result){
			userRegisterDao.deleteUser(userReg);
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
	public UserList getEmployeeList(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		
		logger.info("******UserRegisterServiceImpl.getEmployeeList**************");
		ResponseDTO response=new ResponseDTO();
		UserList list=new UserList();
		List<EmployeeEntity> empList= userRegisterDao.getEmployeeList(userReg);
		if(empList.size()==0){
			//response.setReturnCode(1);
			response.setMessageReturn("There is No User Registered with DEMO-API");
		}else{
	//	response.setReturnCode(0);
	  list.setEmplist(empList);
		}
		return list;
		
		
		
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
	
}
