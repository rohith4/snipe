package com.demoAPI.rest.service.Impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoAPI.rest.entity.Answered;
import com.demoAPI.rest.entity.EmployeeEntity;
import com.demoAPI.rest.entity.Questions;
import com.demoAPI.rest.entity.Recent;
import com.demoAPI.rest.entity.Tags;
import com.demoAPI.rest.entity.UserEntity;
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
		logger.info("******UserRegisterServiceImpl.getUserReg**************");
		ResponseDTO userRegRes = new ResponseDTO();
		System.out.println("Server: "+userReg.getFname());
	
		if(!userReg.getEmailId().isEmpty() && userReg.getEmailId()!= null){
			boolean result = userRegisterDao.checkemailId(userReg);
			if(result){
				//userRegRes.setReturnCode(1);
				userRegRes.setMessageReturn("This Eamil Already Registered with DEMOAPI");
			}else{
			heapler.sendEmail(userReg.getEmailId(), userReg.getFname());
			userRegRes=userRegisterDao.saveUserreg(userReg);
			}
		}else{ 	
			userRegRes.setReturnCode(1);
			userRegRes.setMessageReturn("You are not entered e");
		}
		return userRegRes;
	}

	@Override
	public ResponseDTO getLogin(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getLogin**************");
		ResponseDTO userRegRes = new ResponseDTO();
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
				userRegRes.setReturnCode(0);
				userRegRes.setMessageReturn("Login successfully");
				System.out.println("Login Sussfull");
				
			}else{
				userRegRes.setReturnCode(1);
				userRegRes.setMessageReturn("oooInvalid EmailId/Password");
				System.out.println("Login UnSussfull");
			}
		}else{
			userRegRes.setReturnCode(1);
			userRegRes.setMessageReturn("Invalid EmailId/Password");
			System.out.println("Login UnSussfull");
		}
		return userRegRes;
		
	}
	
	@Override
	public ResponseDTO getUsersList(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getUsersList**************");
		ResponseDTO response=new ResponseDTO();
		List<UserEntity> userList= userRegisterDao.getUserList(userReg);
		if(userList.size()==0){
			response.setReturnCode(1);
			response.setMessageReturn("There is No User Registered with DEMO-API");
		}else{
		response.setReturnCode(0);
	  response.setUserEntity(userList);
		}
		return response;
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
			response.setMessageReturn("No user found for particular MobileNo");
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
			response.setReturnCode(0);
			response.setMessageReturn("Logout successfully");
		}else{
			response.setReturnCode(1);
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
		Questions que=new Questions();
		Criteria crc = session.createCriteria(Questions.class);
		
		que.setQue(userReg.getQue());
		
		
		
	//	user.setLoginStatus("Y");
		session.save(que);
		System.out.println("Saved");
		returnMag = " "+que.getQue()+" "+" Question Submitted Successfully";
		
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
				logger.info("******UserRegisterServiceImpl.Tags**************");
				ResponseDTO userRegRes = new ResponseDTO();
				Session session=currentSession();
				Criteria crt=session.createCriteria(Recent.class);
				Recent rec=new Recent();
				rec.setDate(userReg.getDate());
				rec.setQuestion(userReg.getQuestion());
				rec.setAns(userReg.getAns());
				rec.setFname(userReg.getFname());
				rec.setRating(userReg.getRating());
				rec.setTag(userReg.getTag());
				rec.setUname(userReg.getUname());
			    rec.setAns_status("N");
				
				
				
				
			//	Criteria crq = session.createCriteria(Questions.class);
				
			
				session.save(rec);
				System.out.println("Hi");
				
			//	session.save(tags);
				
				
				
				System.out.println("taghtml"+userReg.getQue());
		
				userRegRes.setMessageReturn("This question is submitted and added to corresponding tags");
				
				
			//	session.save(userReg);
			
		/*	if(!userReg.getTag().isEmpty() && userReg.getTag()!= null){
					boolean result = userRegisterDao.checkTag(userReg);
					if(result){
						//userRegRes.setReturnCode(1);
						userRegRes.setMessageReturn("This question is answered already");
					}else{
					//heapler.sendEmail(userReg.getEmailId(), userReg.getName());
					userRegRes=userRegisterDao.saveUserreg(userReg);
					}
				}else{ 	
					//userRegRes.setReturnCode(1);
					userRegRes.setMessageReturn("You are not entered e");
				}*/
				return userRegRes;
		
		
		
	//	return null;
	}

	@Override
	public ResponseDTO answered(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		
	
		logger.info("******UserRegisterServiceImpl.Tags**************");
		ResponseDTO userRegRes = new ResponseDTO();
		UserEntity user=new UserEntity();
		
		
		Session session  = currentSession();
		Recent rec=new Recent();
		rec.setDate(userReg.getDate());
		rec.setQuestion(userReg.getQuestion());
		rec.setAns(userReg.getAns());
		rec.setFname(userReg.getFname());
		rec.setRating(userReg.getRating());
		rec.setTag(userReg.getTag());
		rec.setUname(userReg.getUname());
	    //rec.setAns_status("N");
	
		//Criteria crc = session.createCriteria(Answered.class);
		
		//Questions que=new Questions();
		//Session session=currentSession();
		Criteria crc1=session.createCriteria(Questions.class);
	//	que.setQue(userReg.getQue());
	//	Tags tags=new Tags();
		Answered ans=new Answered();
		//EmployeeEntity emp=new EmployeeEntity();
		logger.info("******UserRegisterServiceImpl.ANSWERQUESTIONS**************");
		
		/*boolean result = userRegisterDao.checkemailId(userReg);
		if(result){*/
		String pwd= userRegisterDao.getpwd(userReg);
		System.out.println("Devaraj: "+pwd);
		System.out.println("Devaraj: "+heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId()));
		/*	if(pwd.equals(heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId()))){	
				userRegisterDao.updateLoginStatusY(userReg);
				userRegRes.setReturnCode(0);
				userRegRes.setMessageReturn("You can answer the question");
				ans.setFname(userReg.getFname());
				*/
		//		que.setDate(userReg.getDate());
				System.out.println("date"+userReg.getDate());
			//	session.save(que);
				//session.save(ans);
				if(!userReg.getTag().isEmpty() && userReg.getAns()!= null){
					
					userRegisterDao.updateAnsStatusY(userReg);
					
				}
				
			/*}else{
				userRegRes.setReturnCode(1);
				userRegRes.setMessageReturn("Please Login");
			}*/
		/*}else{
			userRegRes.setReturnCode(1);
			userRegRes.setMessageReturn("Please Login");
		}*/
		
		
		
		
//		ResponseDTO userRegRes = new ResponseDTO();
		
		
		return userRegRes;
		

	}

	@Override
	public ResponseDTO getRecentList(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		logger.info("******UserRegisterServiceImpl.getRecentList**************");
		ResponseDTO response=new ResponseDTO();
		List<Recent> recentList= userRegisterDao.getrecentList(userReg);
		if(recentList.size()==0){
			response.setReturnCode(1);
			response.setMessageReturn("There is No Recent Registered with DEMO-API");
		}else{
	//	response.setReturnCode(0);
			try {
			Session session=currentSession();
			Recent rec=new Recent();
		//	Query q=session.createQuery("from recent fname");
			Criteria criteria=session.createCriteria(Recent.class);
		//	count.setProjection(Projections.rowCount());
			 // criteria.setFirstResult(2);
		        criteria.setMaxResults(4);
			
			
			
			System.out.println("Hi from hibernate");
			List<Recent> recentList1=criteria.list();
			
			System.out.println("From date "+rec.getDate()+"todate"+rec.getDate());
		/*//	 Criteria criteria = session.createCriteria(UserTable.class);
			    criteria.addOrder(rec.getDate());
			    criteria.setMaxResults(n);*/

	
		response.setRecent(recentList1);
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		return response;
	}
	
	
	

	

	
}
