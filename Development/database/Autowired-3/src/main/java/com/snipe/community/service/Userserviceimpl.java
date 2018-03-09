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
import org.hibernate.criterion.Restrictions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snipe.community.response.CommonUtils;
import com.snipe.community.response.Response;

import com.snipe.community.Config.Hibernateutil;
import com.snipe.community.constant.StatusCode;
import com.snipe.community.email.send;
import com.snipe.community.entity.Admin;
import com.snipe.community.entity.Answeres;
import com.snipe.community.entity.ContactUs;
import com.snipe.community.entity.Employee;
import com.snipe.community.entity.Lists;
import com.snipe.community.entity.LoginResponse;
import com.snipe.community.entity.Question;

import com.snipe.community.entity.Recent;
import com.snipe.community.entity.ResetPassword;
import com.snipe.community.helper.Helper;
import com.snipe.community.request.Requestdto;
import com.snipe.community.response.Responsedto;
import com.snipe.community.userdao.Userdao;


@Service
@Transactional(readOnly = false,value="transactionManager", rollbackFor=Exception.class)
public class Userserviceimpl extends Hibernateutil implements Userservice {

	
	
	/*@Autowired(required=false)
	EmailServiceImpl emailService;*/
	//private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	
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
	public Response getUserRegist(Requestdto userReg) {
		// TODO Auto-generated method stub
		Response response = new Response();		
		logger.info("******UserRegisterServiceImpl.getUserRegdjf**************");
				try {
				
				Employee user=new Employee();
				System.out.println("Server: "+userReg.getFname());
			System.out.println("dfjidsjgfkls");
				if(!userReg.getEmailId().isEmpty() && userReg.getEmailId()!= null){
					boolean result = userdao.checkemailId(userReg);
				//	boolean resultE = userdao.checkemailIdE(userReg);
					if(result ){
						
						response.setStatus(StatusCode.ERROR.name());
						response.setMessage("User already registered");
						
					} else
					{
						response=userdao.saveUserreg(userReg);
					}
				}
				}catch (Exception ex) {
						logger.info("Exception Service:" + ex.getMessage());
					}
					return response;

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
	public Response getLogin(Requestdto userReg) {
		// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getLogin**************");
				Response response = new Response();
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
						
						response=userdao.getLoginuser(userReg);
						userdao.updateLoginStatusY(userReg);
					
					}
				}
				else
				{
					response.setStatus(StatusCode.ERROR.name());
				}
				
				return response;
			
	}

	@Override
	public Response getLoginE(Requestdto userReg) {
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getLogin**************");
				//Responsedto userRegRes = new Responsedto();
				Response response=new Response();
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
				/*		System.out.println("dfjkldsjlk");
					int ueid=userdao.updateLoginStatusYE(userReg);
					
					Query q=session.createQuery("select emp.ueid from Employee emp where emp.emailId=:email");
					q.setParameter("email",userReg.getEmailId());
					System.out.println(q);
						lresponse.setReturnCode(ueid);
						lresponse.setMessageReturn("success");*/
					
					response.setStatus(StatusCode.SUCCESS.name());
						userdao.updateLoginStatusYE(userReg);
					//	userRegRes.setMessageReturn("Login successfully"+user.getUserRef());
						System.out.println("Login Sussfull");
						
					}else{
						response.setStatus(StatusCode.ERROR.name());
						response.setMessage("Invalid Email or Password");
						
						System.out.println("Login UnSussfull");
					}
				}else{
					//userRegRes.setReturnCode(1);
					response.setMessage("Invalid Email or Password");
					System.out.println("Login UnSussfull");
				}
				
				return response;
			

	}
	
	
	
	
	@Override
	public Response answered1(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.Answered**************");
		Response response = new Response();
	
		Session session=sesionFactory.getCurrentSession();
		Criteria cr=session.createCriteria(Question.class);
	    //que.setAns(userReg.getAns());
		System.out.println("name"+userReg.getAns());
		boolean res=userdao.Isexist(userReg);

		if(res)
		{
		System.out.println(res);
		boolean result = userdao.checkanswered(userReg);
		if(result) {
			cr.add(Restrictions.eq("q_id",userReg.getQ_id()));	
			Question que = (Question)cr.uniqueResult();
			
			que.setStatus("Y");
			session.saveOrUpdate(que);
		}
		
		System.out.println( res);
		
			
					
					
					
					//List<Answeres> ans=new ArrayList<Answeres>();
					Answeres ans=new Answeres();
					Criteria crc1=session.createCriteria(Answeres.class);
					ans.setQuestionid(userReg.getQ_id());
					ans.setAns(userReg.getAns());
					
					session.saveOrUpdate(ans);
					response.setMessage("Answered");
			
			}
				else
				{
					response.setMessage("Question Id is not correct");
				}
		
		
		
		
		//userRegRes.setMessageReturn("Answered");
		
		return response;
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
	public Response modifyUser(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.modifyUser**************");
		Response response=new Response();
		int result = userdao.modifyUser(userReg);
		if(result>=1){
			//response.setReturnCode(0);
			response.setMessage("User emailId modified successfully");
		}else{
			//response.setReturnCode(0);
			response.setMessage("No user found for particular EmailId");
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
	public Response logoutUser(Requestdto userReg) {
		logger.info("******UserRegisterServiceImpl.logoutUser**************");
		// TODO Auto-generated method stub
		Response response=new Response();
		boolean checklogin=userdao.Checklogin(userReg);
		System.out.println(checklogin);
		if(checklogin) 
		{
			
				if(!(userReg.getEmailId()==null)){
						boolean result = userdao.checkemailId(userReg);
						if(result){
								userdao.updateLoginStatusN(userReg);
								response.setMessage("Logout Successfully");
			
						}
						else{
								response.setMessage("Not login!  Please Login");
						}
				 }else {
		
								response.setMessage("Please entre EmailId");
					}
	     }
		else {
		response.setMessage("Please Login");
	}
		
		return response;
	}

	@Override
	public Response askquestion(Requestdto userReg) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String date=sdf.format(new Date());
		Response response= new Response();
		logger.info("******userdaoImpl.saveUserreg**************");
		// TODO Auto-generated method stub
		String returnMag ="";
		
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
		response.setMessage(returnMag);
		return response;

		
		
		
		
	}

	@Override
	public Response getEmployeeRegist(Requestdto userReg) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				logger.info("******UserRegisterServiceImpl.getUserRegdjf**************");
				Response response = new Response();
				Employee user=new Employee();
				System.out.println("Server: "+userReg.getFname());
			System.out.println("dfjidsjgfkls");
				if(!userReg.getEmailId().isEmpty() && userReg.getEmailId()!= null){
					boolean resultE = userdao.checkemailIdE(userReg);
					boolean result = userdao.checkemailId(userReg);
					if(result || resultE){
					//	userRegRes.setReturnCode(1);
						//userRegRes.setMessageReturn("This Eamil Already Registered with Snipe");
						response.setMessage("This Emaild Id already Exist");
					}else{
				//	heapler.sendEmail(userReg.getEmailId(), userReg.getFname());
					response=userdao.saveEmprreg(userReg);
					}
				}else{ 	
				//	userRegRes.setReturnCode(1);
					//userRegRes.setMessageReturn("You are not entered e");
					response.setMessage("You have not entered correctly");
					
				}
				return response;

		

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
	public Response resetPwd(Requestdto userReg) {
		// TODO Auto-generated method stub
Response response=new Response();
		
		Employee user=new Employee();
		String email=user.setSendedmail(userReg.getEmailId());
		send Send=new send();
System.out.println("email"+userReg.getEmailId());
		try
		
		{ 
		Send.otp(userReg.getEmailId());
		
		System.out.println(" It  is Running");
		
		/*System.out.println(st);
		
		
		userdao.updatepwd(userReg,st);*/
		}catch(Exception e)
		{
			System.out.println(e);
		}

		
		
		
		response.setMessage("OTP Sent");
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
		response.setMessageReturn(returnMag);
		return response;

		
	}

	@Override
	public Responsedto upDateEmployee(Requestdto userReg) {

		Responsedto response=new Responsedto();

		try {

			String hql="update employee set fname=:fname,emailId=:email, pwd=:password,lname=:lname,qualification=:qualification where emailId=:email";

			int res = jdbcTemplate.update(hql,userReg.getFname(),userReg.getLname(),userReg.getEmailId(),userReg.getPwd(),userReg.getQualification());
			

			if (res == 1) {
				response.setMessageReturn("Success");
			} else {

			}
		} catch (Exception e) {
			logger.error("Exception in update employee data", e);
		}
		return response;

	}


	@Override
	public Response deleteEmployee(int userReg) {
				logger.info("******UserRegisterServiceImpl.deleteUser**************");
				Response response=new Response();
				 
				String delete="Record deleted";
			Employee user=new Employee();
				boolean result = userdao.checkempId(userReg);
				if(result)
				{
					userdao.deleteEmployee(userReg);
					response.setMessage("user deleted successfully");
				}else{
				
				}
				return response;

	}

	@Override
	public List<Answeres> getAnswer(int q_id) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getUsersList**************");
		Responsedto response=new Responsedto();
		List<Answeres> Answerslist= userdao.getAnsweres(q_id);
		if(Answerslist.size()==0){
			response.setMessageReturn("No questions");
		}else{

		}
		return Answerslist;
	
}

	@Override
	public String resetPassword(Employee resetPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetPassword(ResetPassword resetPassword) {
		// TODO Auto-generated method stub
		try {
			Employee user = userdao.isUserExist(resetPassword);
			if (user != null) {
				String password = CommonUtils.generateRandomId();
				String status = userdao.resetPassword(user.getEmailId(), CommonUtils.encriptString(password));
				if (status.equals(StatusCode.SUCCESS.name())) {
				//	emailService.sendResetPassword(user, password);
				}
				return status;
			} else
				return StatusCode.ERROR.name();

		} catch (Exception e) {
			logger.error("Exception in resetPassword:", e);
			return StatusCode.ERROR.name();
		}
	}

	@Override
	public Response admin(Requestdto userReg) {
		// TODO Auto-generated method stub
		
		
		String returnMag="";
		Response response=new Response();
		Session session=sesionFactory.getCurrentSession();
		
		
		Admin admin =new Admin();
		Criteria crc = session.createCriteria(Admin.class);
		admin.setAdmin(userReg.getAdmin());
	//	admin.setPassword(userReg.getPwd());
		admin.setPassword(heapler.getPasswordEncoded(userReg.getPassword(),userReg.getAdmin()));
		session.save(admin);
		System.out.println("Saved");
		returnMag = "Congratulations!!"+admin.getAdmin() +" Your message submitted";
	//	response.setReturnCode(0);
		response.setMessage(returnMag);
		return response;
		
		
		
	}

	@Override
	public Response getAdmin(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterServiceImpl.getLogin**************");
		Response response=new Response();
		Admin admin=new Admin();
		Session session  = sesionFactory.getCurrentSession();
		Criteria crc = session.createCriteria(Admin.class);
		LoginResponse lresponse=new LoginResponse();
		boolean resultE= userdao.checadmin(userReg);
		
		if(resultE)
		{
		String password= userdao.getpassword(userReg);
		System.out.println(": "+password);
		System.out.println(": "+userReg.getAdmin());
			if(password.equals(heapler.getPasswordEncoded(userReg.getPassword(),userReg.getAdmin())))
			{	

			response.setStatus(StatusCode.SUCCESS.name());
			
				System.out.println("Login Sussfull");
				
			}else{
				response.setStatus(StatusCode.ERROR.name());
				response.setMessage("Invalid Email or Password");
				System.out.println("Login UnSussfull");
			}
		}else{
			response.setMessage("Invalid Email or Password");
			System.out.println("Login UnSussfull");
		}
		
		return response;

	}


	

	

	
	
	
}
