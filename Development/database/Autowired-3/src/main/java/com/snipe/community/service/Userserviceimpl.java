package com.snipe.community.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snipe.community.Config.Hibernateutil;
import com.snipe.community.entity.Answeres;
import com.snipe.community.entity.ContactUs;
import com.snipe.community.entity.Employee;
import com.snipe.community.entity.Lists;
import com.snipe.community.entity.LoginResponse;
import com.snipe.community.entity.Question;

import com.snipe.community.entity.Recent;
import com.snipe.community.helper.Helper;
import com.snipe.community.request.Requestdto;
import com.snipe.community.response.Responsedto;
import com.snipe.community.userdao.Userdao;


@Service
@Transactional(readOnly = false,value="transactionManager", rollbackFor=Exception.class)
public class Userserviceimpl extends Hibernateutil implements Userservice {

	
	private static final Logger logger = Logger.getLogger(Userserviceimpl.class);
	@Autowired
	Helper heapler;
	
	
	@Autowired
	private SessionFactory sesionFactory;

	JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	private Userdao userdao;

	public List getUserDetails() {
		return userdao.getUserDetails();
	}

	@Override
	public Responsedto getUserRegist(Requestdto userReg) {
		// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getUserRegdjf**************");
				Responsedto userRegRes = new Responsedto();
				Employee user=new Employee();
				System.out.println("Server: "+userReg.getFname());
			System.out.println("dfjidsjgfkls");
				if(!userReg.getEmailId().isEmpty() && userReg.getEmailId()!= null){
					boolean result = userdao.checkemailId(userReg);
					boolean resultE = userdao.checkemailIdE(userReg);
					if(result || resultE){
					//	userRegRes.setReturnCode(1);
						userRegRes.setMessageReturn("This Eamil Already Registered with Snipe");
					}else{
				//	heapler.sendEmail(userReg.getEmailId(), userReg.getFname());
					userRegRes=userdao.saveUserreg(userReg);
					}
				}else{ 	
				//	userRegRes.setReturnCode(1);
					userRegRes.setMessageReturn("You are not entered e");
					
				}
				return userRegRes;

	}

	
	@Override
	public Responsedto getrecentQeustion(Requestdto userReg) {
		
		// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getUsersList**************");
				Responsedto response=new Responsedto();
				List<Question> RecentQ= userdao.getRecentQ(userReg);
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
	public LoginResponse getLogin(Requestdto userReg) {
		// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getLogin**************");
				Responsedto userRegRes = new Responsedto();
				Employee user=new Employee();
				
			/*	Query query=session.createQuery("select Employee.userRef from Employee Employee where Employee.emailId=:email");
				query.setParameter("email", userReg.getEmailId());*/
				LoginResponse lresponse=new LoginResponse();
				
				boolean result = userdao.checkemailId(userReg);
				if(result)
				{
				String pwd= userdao.getpwd(userReg);
				System.out.println(": "+pwd);
				System.out.println(": "+userReg.getEmailId());
				System.out.println(" "+heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId()));
					if(pwd.equals(heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId())))
					{	
						
						userRegRes=userdao.getLoginuser(userReg);
						userdao.updateLoginStatusY(userReg);
					//	userRegRes.setReturnCode(0);
					//	lresponse.setMessageReturn("success");
					}
				}
				return lresponse;
			
	}

	@Override
	public LoginResponse getLoginE(Requestdto userReg) {
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getLogin**************");
				Responsedto userRegRes = new Responsedto();
				Employee user=new Employee();
				Session session  = sesionFactory.getCurrentSession();
				Criteria crc = session.createCriteria(Employee.class);
			/*	Query query=session.createQuery("select Employee.userRef from Employee Employee where Employee.emailId=:email");
				query.setParameter("email", userReg.getEmailId());*/
				LoginResponse lresponse=new LoginResponse();
				boolean resultE= userdao.checkemailIdE(userReg);
				boolean result = userdao.checkemailIdE(userReg);
				if(result || resultE)
				{
				String pwd= userdao.getpwdE(userReg);
				System.out.println(": "+pwd);
				System.out.println(": "+userReg.getEmailId());
				//System.out.println(" "+heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId()));
					if(pwd.equals(heapler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId())))
					{	
						System.out.println("dfjkldsjlk");
					int ueid=userdao.updateLoginStatusYE(userReg);
					
					Query q=session.createQuery("select emp.ueid from Employee emp where emp.emailId=:email");
					q.setParameter("email",userReg.getEmailId());
					System.out.println(q);
						lresponse.setReturnCode(ueid);
						lresponse.setMessageReturn("success");
						userdao.updateLoginStatusYE(userReg);
					//	userRegRes.setMessageReturn("Login successfully"+user.getUserRef());
						System.out.println("Login Sussfull");
						
					}else{
						userRegRes.setReturnCode(1);
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
	public Responsedto answered1(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.Answered**************");
		Responsedto userRegRes = new Responsedto();
		Question que=new Question();
	    que.setAns(userReg.getAns());
		System.out.println("name"+userReg.getAns());
		boolean result = userdao.checkanswered(userReg);
		System.out.println(result);
		
		
				if(result)
				{	
					Session session=sesionFactory.getCurrentSession();
					
					
					//List<Answeres> ans=new ArrayList<Answeres>();
					Answeres ans=new Answeres();
					Criteria crc1=session.createCriteria(Answeres.class);
					ans.setQuestionid(userReg.getQ_id());
					ans.setAns(userReg.getAns());
					session.saveOrUpdate(ans);
				/*	userRegRes=userdao.getLoginuser(userReg);
					userdao.updateLoginStatusY(userReg);*/
				//	userRegRes.setReturnCode(0);
				//	lresponse.setMessageReturn("success");
				
			}
		//	return lresponse;
		
		
		
		userRegRes.setMessageReturn("Answered");
		
		return userRegRes;
	}

	
	
	
	
	
	/*@Override
	public Responsedto getrecentQeustion(Requestdto userReg) {
		// TODO Auto-generated method stub
	
		
		// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getUsersList**************");
				Responsedto response=new Responsedto();
				List<Question> RecentQ= userdao.getRecentQ(userReg);
				if(RecentQ.size()==0){
					//response.setReturnCode(1);
					response.setMessageReturn("There is No User Registered with DEMO-API");
				}else{
			//	response.setReturnCode(0);
			  response.setQuestion1(RecentQ);
				}
				return response;
		
	}*/
	
	
	@Override
	public List<Employee> getUsersList(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getUsersList**************");
		Lists list=new Lists();
		Responsedto response=new Responsedto();
	//	Lists list=new Lists();
		List<Employee> userList= userdao.getUserList(userReg);
		/*if(userList.size()==0){
			//response.setReturnCode(1);
			response.setMessageReturn("There is No User Registered with DEMO-API");
		}else{
	//	response.setReturnCode(0);*/
	//	response.setEmployee(userList);
		//}
		return userList;
	}
	
	
	@Override
	public Responsedto modifyUser(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.modifyUser**************");
		Responsedto response=new Responsedto();
		int result = userdao.modifyUser(userReg);
		if(result>=1){
			//response.setReturnCode(0);
			response.setMessageReturn("User emailId modified successfully");
		}else{
			//response.setReturnCode(0);
			response.setMessageReturn("No user found for particular EmailId");
		}
		return response;
	}

	@Override
	public Responsedto deleteUser(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.deleteUser**************");
		Responsedto response=new Responsedto();
		Employee user=new Employee();
		boolean result = userdao.checkemailId(userReg);
		if(result){
			userdao.deleteUser(userReg);
			//response.setReturnCode(0);
			response.setMessageReturn(user.getFname()+" user deleted successfully");
		}else{
			//response.setReturnCode(1);
			response.setMessageReturn("No user found for particular EmailId");
		}
		return response;
	}

	@Override
	public Responsedto logoutUser(Requestdto userReg) {
		logger.info("******UserRegisterServiceImpl.logoutUser**************");
		// TODO Auto-generated method stub
		Responsedto response=new Responsedto();
		boolean result = userdao.checkemailId(userReg);
		if(result){
			userdao.updateLoginStatusN(userReg);
		//	response.setReturnCode(0);
			response.setMessageReturn("Logout successfully");
		}else{
			//response.setReturnCode(1);
			response.setMessageReturn("Something went wrong");
		}
		return response;
	}

	@Override
	public Responsedto askquestion(Requestdto userReg) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String date=sdf.format(new Date());
		
		logger.info("******userdaoImpl.saveUserreg**************");
		// TODO Auto-generated method stub
		String returnMag ="";
		Responsedto response= new Responsedto();
		Answeres ans=new Answeres();
		Session session=sesionFactory.getCurrentSession();
		
		
		Employee user = new Employee();
		Question que=new Question();
		Criteria crc = session.createCriteria(Question.class);
		
		que.setQuestion(userReg.getQuestion());
		que.setTag_name(userReg.getTag_name());
		que.setRatings(userReg.getRating());
		que.setCreatedate(date);
		que.setStatus("N");
		ans.setQuestion(que);
		
		
		
		
	//	user.setLoginStatus("Y");
		session.save(ans);
		System.out.println("Saved");
		returnMag = " "+que.getQuestion()+" "+" Question Submitted Successfully";
		returnMag="Question Id is"+que.getQ_id()+"";
	//	response.setReturnCode(0);
		response.setMessageReturn(returnMag);
		return response;

		
		
		
		
	}

	@Override
	public Responsedto getEmployeeRegist(Requestdto userReg) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getUserRegdjf**************");
				Responsedto userRegRes = new Responsedto();
				Employee user=new Employee();
				System.out.println("Server: "+userReg.getFname());
			System.out.println("dfjidsjgfkls");
				if(!userReg.getEmailId().isEmpty() && userReg.getEmailId()!= null){
					boolean resultE = userdao.checkemailIdE(userReg);
					boolean result = userdao.checkemailId(userReg);
					if(result || resultE){
					//	userRegRes.setReturnCode(1);
						userRegRes.setMessageReturn("This Eamil Already Registered with Snipe");
					}else{
				//	heapler.sendEmail(userReg.getEmailId(), userReg.getFname());
					userRegRes=userdao.saveEmprreg(userReg);
					}
				}else{ 	
				//	userRegRes.setReturnCode(1);
					userRegRes.setMessageReturn("You are not entered e");
					
				}
				return userRegRes;

		

	}

	@Override
	public Responsedto getTags(Requestdto userReg) {
		return null;
/*		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
	
		
		Responsedto userRegRes=new Responsedto();
		Session session=sesionFactory.getCurrentSession();
	
	Criteria crt=session.createCriteria(Question.class);

Answeres ans=new Answeres();
Question que=new Question();


	que.setCreatedate( new Date());
	

	que.setCreatedate( new Date());

	System.out.println("question is" +userReg.getQuestion());

	session.save(que);
	
		
		userRegRes.setReturnMsg("Saved");
	
	
	
	

	userRegRes.setMessageReturn("This question is submitted and added to corresponding tags");
	return userRegRes;	
	*/	
		
		
	
	}

	@Override
	public List<Question> answered(Requestdto userReg) {
		// TODO Auto-generated method stub
		Responsedto response=new Responsedto();
		
		List<Question> queList= userdao.getqueList(userReg);
		response.setQuestion1(queList);
		return queList;
		

	}


		
		

	@Override
	public Responsedto resetPwd(Requestdto userReg) {
		// TODO Auto-generated method stub
		Responsedto response=new Responsedto();
		
		Employee user=new Employee();
//		String email=user.setSendedmail(userReg.getEmailId());
		send Send=new send();
System.out.println("email"+userReg.getEmailId());
		try
		
		{ 
		//	Send.otp(email);
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		response.setReturnMsg("OTP sent ");
		return response;
	}

	@Override
	public Responsedto getupdatepwd(Requestdto userReg) {
	
		// TODO Auto-generated method stub
		return null;
	}



	

	@Override
	public List<Question> getPopularq(Requestdto userReg) {
		// TODO Auto-generated method stub
		
		logger.info("******UserRegisterServiceImpl.getUsersList**************");
		Responsedto response=new Responsedto();
		List<Question> popularlist= userdao.getPopularQ(userReg);
		//System.out.println(popularlist);
		if(popularlist.size()==0){
			//response.setReturnCode(1);
			response.setMessageReturn("No questions");
		}else{
	//	response.setReturnCode(0);
	 response.setQuestion1(popularlist);
		}
		return popularlist;
		
		
	}

	@Override
	public List<Employee> getEmployeeList(Requestdto userReg) {
		// TODO Auto-generated method stub
		
		
		logger.info("******UserRegisterServiceImpl.getEmployeeList**************");
		Responsedto response=new Responsedto();
	//	List<Employee> list=new UserList();
		List<Employee> empList= userdao.getEmployeeList(userReg);
		if(empList.size()==0){
			//response.setReturnCode(1);
			response.setMessageReturn("There is No User Registered with DEMO-API");
		}else{
	//	response.setReturnCode(0);
			response.setEmployee(empList);
	//  list.setEmplist(empList);
		}
		return empList;
		
		
		
	}

	@Override
	public List<Question>getrecentQeustionQs(Requestdto userReg) {
		// TODO Auto-generated method stub
	
		
		logger.info("******UserRegisterServiceImpl.getQuestionsList**************");
		Responsedto response=new Responsedto();
	//	RecentQuestions recentQs=new RecentQuestions();
		List<Question> recentQ= userdao.getrecentQuestionQs(userReg);
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
	public Responsedto ContactUs(Requestdto userReg) {
		// TODO Auto-generated method stub
		String returnMag="";
		Responsedto response=new Responsedto();
		Session session=sesionFactory.getCurrentSession();
		
		
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
	public Responsedto upDateEmployee(Requestdto userReg) {
		// TODO Auto-generated method stub
		Responsedto response=new Responsedto();
		
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
	public Responsedto deleteEmployee(Requestdto userReg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responsedto deleteEmployee(int userReg) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
				// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.deleteUser**************");
				Responsedto response=new Responsedto();
				 
				String delete="Record deleted";
			Employee user=new Employee();
				boolean result = userdao.checkempId(userReg);
				if(result)
				{
					userdao.deleteEmployee(userReg);
					response.setReturnCode(0);
					response.setMessageReturn(user.getFname()+" user deleted successfully");
				}else{
					//response.setReturnCode(1);
					//response.setMessageReturn("No user found for particular MobileNo");
					//String	delete1="Record deleted";
				}
				return response;

	}

	@Override
	public List<Answeres> getAnswer(int q_id) {
		// TODO Auto-generated method stub
		
		
		logger.info("******UserRegisterServiceImpl.getUsersList**************");
		Responsedto response=new Responsedto();
		List<Answeres> Answerslist= userdao.getAnsweres(q_id);
		//System.out.println(popularlist);
		if(Answerslist.size()==0){
			//response.setReturnCode(1);
			response.setMessageReturn("No questions");
		}else{
	//	response.setReturnCode(0);
	 //response.setQuestion1();
		}
		return Answerslist;
		
		
		
		//return null;
	}


	

	

	
	
	
}
