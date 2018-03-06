package com.snipe.community.userdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.snipe.community.Config.Hibernateutil;
import com.snipe.community.Userdetails.Userdetails;
import com.snipe.community.constant.StatusCode;
import com.snipe.community.entity.Answeres;
import com.snipe.community.entity.ContactUs;
import com.snipe.community.entity.Employee;
import com.snipe.community.entity.Question;
import com.snipe.community.entity.Recent;
import com.snipe.community.entity.ResetPassword;
import com.snipe.community.helper.Helper;
import com.snipe.community.request.Requestdto;
import com.snipe.community.response.Responsedto;


@Component
public class Userdaoimplt extends Hibernateutil implements Userdao {

	private static final Logger logger = Logger.getLogger(Userdaoimplt.class);
	

@Autowired(required=false)
private SessionFactory sessionFactoy;

	
	@Autowired
	Helper hepler;

	//Criteria criteria = sessionFactory.openSession().createCriteria(Userdetails.class);
	
	
	

	public List getUserDetails() {
	//	Criteria criteria = sessionFactory.openSession().createCriteria(Userdetails.class);
		//return criteria.list();
		return null;
	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public boolean checkemailId(Requestdto userReg) {

		logger.info("******UserRegisterDAOImpl.checkEmailIdo**************");
		//Session session  = sessionFactory.openSession().createCriteria(Employee.class);
	//	Session session=null;
		Session session=sessionFactoy.getCurrentSession();
		Criteria crc=sessionFactoy.getCurrentSession().createCriteria(Employee.class);
		//Criteria crc=sessionFactoy.openSession().createCriteria(Employee.class);
	//	Criteria crc = openSession().createCriteria(Employee.class);
		crc.add(Restrictions.eq("emailId",userReg.getEmailId())).setProjection(Projections.rowCount());
		System.out.println("email: "+userReg.getEmpId());
		int count = (int)((long)crc.uniqueResult());
		System.out.println(count);
		if(count>0){
			
		//	System.out.println("EmailId is exited");
			return true;
		}
		//System.out.println("COrrectd");
		return false;

	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public boolean checkemailIdE(Requestdto userReg) {
		logger.info("******UserRegisterDAOImpl.checkEmailIdo**************");
		Session session  = sessionFactoy.getCurrentSession();
		Criteria crc = session.createCriteria(Employee.class);
		crc.add(Restrictions.eq("emailId",userReg.getEmailId())).setProjection(Projections.rowCount());
		System.out.println("email: "+userReg.getEmailId());
		int count = (int)((long)crc.uniqueResult());
		System.out.println(count);
		if(count>0){
			
		//	System.out.println("EmailId is exited");
			return true;
		}
		//System.out.println("COrrectd");
		return false;
		
	}

	@Override
	public Responsedto saveUserreg(Requestdto userReg) {
		// TODO Auto-generated method stub
		
		logger.info("******UserRegisterDAOImpl.saveUserreg**************");
		// TODO Auto-generated method stub
		String returnMag ="";
		Employee user = new Employee();
		Responsedto response= new Responsedto();
		Session session=sessionFactoy.getCurrentSession();
		Criteria crc=sessionFactoy.getCurrentSession().createCriteria(Employee.class);
	//	Session session  =currentSession();
		
		//Criteria crc = session.createCriteria(Employee.class);
		user.setFname(userReg.getFname());
		user.setLname(userReg.getLname());
		
		user.setDob(userReg.getDob());
		user.setAddress(userReg.getAddress());
		user.setEmailId(userReg.getEmailId());
		//user.setEmpId("snipe"+user.getUserRef());
		//System.out.println(user.getUserId());
		user.setMobileNo(userReg.getMobileNo());
    	user.setPwd(userReg.getPwd());
		user.setState(userReg.getState());
		user.setCountry(userReg.getCountry());
		user.setGender(userReg.getGender());
	System.out.println(userReg.getGender());
		user.setDate(new Date());
		user.setUeid(1);
		user.setPwd(hepler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId()));
		
		user.setLoginStatus("N");
		System.out.println("HJHGGHV");
	int i=	(int) session.save(user);
		//System.out.println("HJHGGHV");
		System.out.println("Saved");
	//	returnMag = "Congratulations!!"+user.getFname() +" Registration successfull"+user.getEmpId()+"thank u";
		System.out.println(""+userReg.getFname());
		 //response.setReturnMsg(returnMag);	
		//response.setMessageReturn("E"+user.getEmpId());
		return response;
	}

	@Override
	public Responsedto contactUs(Requestdto userReg) {
		ContactUs contact=new ContactUs();
		Responsedto response= new Responsedto();
		String returnMag ="";
		Session session=sessionFactoy.getCurrentSession();
		Criteria crc=sessionFactoy.getCurrentSession().createCriteria(ContactUs.class);
		contact.setEmailId(userReg.getEmailId());
		contact.setMessage(userReg.getMessage());
		contact.setName(userReg.getName());
		session.save(contact);
		System.out.println("Saved");
	//	returnMag = "Congratulations!!"+contact.getName() +" Your message submitted";
	//	response.setReturnCode(0);
		response.setMessageReturn(returnMag);
		return response;
	}

	@Override
	public List<Question> getRecentQ(Requestdto userReg) {

		List<Question> RecentQ = new ArrayList<Question>();
		String returnMag ="";
		Session session=sessionFactoy.getCurrentSession();
		Criteria crc=session.createCriteria(Question.class);
		Query query = session.createQuery("select que.question from Question1 que");
		query.setMaxResults(5);
		try{
			RecentQ = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return RecentQ;
	}

	@Override
	public String getpwd(Requestdto userReg) {
		logger.info("******UserRegisterDAOImpl.getpwd**************");
		// TODO Auto-generated method stub
		String returnMag ="";
		Session session=sessionFactoy.getCurrentSession();
		Criteria crc=sessionFactoy.getCurrentSession().createCriteria(Employee.class);
		crc.add(Restrictions.eq("emailId",userReg.getEmailId()))
		.setProjection(Projections.property("pwd"));
		String pwd = (String) crc.uniqueResult();
		return pwd;
	}

	@Override
	public void updateLoginStatusY(Requestdto userReg) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				logger.info("******UserRegisterDAOImpl.updateLoginStatus**************");
				
				String returnMag ="";
				Session session=sessionFactoy.getCurrentSession();
				Criteria crit=sessionFactoy.getCurrentSession().createCriteria(Employee.class);
				//Criteria crit = currentSession().createCriteria(UserEntity.class);
				crit.add(Restrictions.eq("emailId",userReg.getEmailId()));	
				Employee entity = (Employee)crit.uniqueResult();
				entity.setLoginStatus("Y");
				entity.setLastlogin(new Date());
				sessionFactoy.getCurrentSession().saveOrUpdate(entity);
		
	}

	@Override
	public Responsedto getLoginuser(Requestdto userReg) {
		
		
		Responsedto response= new Responsedto();
		String returnMag ="";
		Session session=sessionFactoy.getCurrentSession();
		Criteria crc=sessionFactoy.getCurrentSession().createCriteria(ContactUs.class);
		Query q=session.createQuery("select emp.ueid from EmployeeEntity emp where emp.emailId=:email");
		q.setParameter("email",userReg.getEmailId());
		System.out.println(q);
		//System.out.println(q);
		response.setMessageReturn("");
		response.setReturnCode(1);
		
		
		/*lresponse.setReturnCode(1);
		userRegRes.setMessageReturn("success");*/
		System.out.println("Login Sussfull");
		
	
		//userRegRes.setReturnCode(1);
		response.setMessageReturn("oooInvalid EmailId/Password");
		System.out.println("Login UnSussfull");
	
	//userRegRes.setReturnCode(1);
	response.setMessageReturn("Invalid EmailId/Password");
	System.out.println("Login UnSussfull");
	return response;
	}

	@Override
	public String getpwdE(Requestdto userReg) {
		logger.info("******UserRegisterDAOImpl.getpwd**************");
		// TODO Auto-generated method stub
		//Session session = currentSession();
		String returnMag ="";
		Session session=sessionFactoy.getCurrentSession();
		Criteria crc=sessionFactoy.getCurrentSession().createCriteria(Employee.class);
		//Criteria crc = session.createCriteria(Employee.class);
		crc.add(Restrictions.eq("emailId",userReg.getEmailId()))
		.setProjection(Projections.property("pwd"));
		String pwd = (String) crc.uniqueResult();
		return pwd;
	}

	@Override
	public int updateLoginStatusYE(Requestdto userReg) {
		logger.info("******UserRegisterDAOImpl.updateLoginStatusE**************");
		String returnMag ="";
		Session session=sessionFactoy.getCurrentSession();
		Criteria crit=session.createCriteria(Employee.class);
		crit.add(Restrictions.eq("emailId",userReg.getEmailId()));	
		
		
		int eid=1;
		Employee entity = (Employee)crit.uniqueResult();
		entity.setLoginStatus("Y");
		entity.setLastlogin(new Date());
		//sessionFactory.getCurrentSession().saveOrUpdate(entity);
		sessionFactoy.getCurrentSession().saveOrUpdate(entity);
		crit.add(Restrictions.eq("ueid",2));
	
		List<Employee> emp=crit.list();
		for(Employee em:emp)
		{
		//	System.out.println(em.getFname());
			eid=eid+1;
		}
		
		return eid;
	}

	@Override
	public List<Question> getrecentQuestionQs(Requestdto userReg) {
		// TODO Auto-generated method stub

		logger.info("******UserRegisterDAOImpl.getUserList**************");
		// TODO Auto-generated method stub
		List<Question> RQ = new ArrayList<Question>();
		Session session = sessionFactoy.getCurrentSession();
		Criteria crc= session.createCriteria(Question.class);
		try{
			RQ = crc.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return RQ;
	}

	@Override
	public List<Employee> getEmployeeList(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.getUserList**************");
		// TODO Auto-generated method stub
		List<Employee> emplist = new ArrayList<Employee>();
		Session session = sessionFactoy.getCurrentSession();
		Criteria crc= session.createCriteria(Employee.class);
		Query query = session.createQuery(" from Employee");
		//query.setMaxResults(5);
		try{
			emplist = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return emplist;
		
	}

	@Override
	public List<Question> getPopularQ(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.PopularQ**************");
		// TODO Auto-generated method stub
		List<Question> popularQ = new ArrayList<Question>();
		Session session = sessionFactoy.getCurrentSession();
		Criteria crc= session.createCriteria(Question.class);
		crc.add(Restrictions.ge("ratings", 3));
		
	//	List<Question> questions=crc.list();
		
		try{
			popularQ = crc.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		/*String hql="select que.question from Question que where que.ratings>:r";
		Query query = session.createQuery(hql);
		System.out.println(query.setParameter("r","3"));
		System.out.println("Result");
		try{
			popularQ = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}*/
		return popularQ;
	}

	@Override
	public boolean checkAns(Requestdto userReg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Recent> getrecentList(Requestdto userReg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getqueList(Requestdto userReg) {
		// TODO Auto-generated method stub
		List<Question> quelist=new ArrayList<Question>();	
		Session session=sessionFactoy.getCurrentSession();
		Criteria crit=session.createCriteria(Question.class);
	    crit.add(Restrictions.eq("status", "N"));
	
	try{
		 quelist = crit.list();
		}catch(Exception ex)
	{
	ex.printStackTrace();		
	}
		
		return quelist;
	}

	@Override
	public boolean checkanswered(Question userReg) {
		// TODO Auto-generated method stub
				logger.info("******UserRegisterDAOImpl.checkANswered**************");
				Session session=sessionFactoy.getCurrentSession();
				
				
				//List<Answeres> ans=new ArrayList<Answeres>();
				Answeres ans=new Answeres();
				Criteria crc1=session.createCriteria(Question.class);
				crc1.add(Restrictions.eq("q_id", userReg.getQ_id())).setProjection(Projections.rowCount());
				
			
				System.out.println("Q_Id"+userReg.getQ_id());
				boolean count = crc1.setMaxResults(1) != null;
				System.out.println(count);
				if(count){
					
				//	System.out.println("EmailId is exited");
					return true;
				}
				//System.out.println("COrrectd");
				return false;
				
				
				}

	@Override
	public void updateLoginStatusNE(Requestdto userReg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Responsedto saveEmprreg(Requestdto userReg) {
		// TODO Auto-generated method stub
		
		logger.info("******UserRegisterDAOImpl.saveUserreg**************");
		// TODO Auto-generated method stub
		String returnMag ="";
		Responsedto response= new Responsedto();
		Session session=sessionFactoy.getCurrentSession();
		
	//	UserEntity user = new UserEntity();
		Employee emp=new Employee();
		Criteria crc = session.createCriteria(Employee.class);
		emp.setFname(userReg.getFname());
		emp.setLname(userReg.getLname());
		emp.setDob(userReg.getDob());
		emp.setQualification(userReg.getQualification());
		emp.setDoj(userReg.getDoj());
		emp.setAddress(userReg.getAddress());//
		emp.setEmailId(userReg.getEmailId());
		emp.setUeid(2);
		//user.setDob("");
		//user.setName(userReg.getName());
		emp.setMobileNo(userReg.getMobileNo());
		//user.setAddress(userReg.getAddress());
		emp.setPwd(userReg.getPwd());
		emp.setState(userReg.getState());
		emp.setCountry(userReg.getCountry());
		emp.setGender(userReg.getGender());
		emp.setDate(new Date());
		emp.setPwd(hepler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId()));
		emp.setLoginStatus("N");
		session.save(emp);
		System.out.println("Saved");
		returnMag = "Congratulations!!"+emp.getFname() +" Registration successfull ID is  "+emp.getEmpId()+"";
		response.setMessageReturn(returnMag);
		return response;

	}

	@Override
	public boolean checkEmpId(Requestdto userReg) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				logger.info("******UserRegisterDAOImpl.checkEmailIdo**************");
				Session session  = sessionFactoy.getCurrentSession();
				Criteria crc = session.createCriteria(Employee.class);
				crc.add(Restrictions.eq("empId",userReg.getEmpId())).setProjection(Projections.rowCount());
				System.out.println("EmpId"+userReg.getEmailId());
				int count = (int)((long)crc.uniqueResult());
				System.out.println(count);
				if(count>0){
					
				//	System.out.println("EmailId is exited");
					return true;
				}
				//System.out.println("COrrectd");
				return false;
	}

	@Override
	public void deleteEmployee(int userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.deleteUser**************");
		// TODO Auto-generated method stub
		Session session=sessionFactoy.getCurrentSession();
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.eq("empId", userReg));
		Employee delentity = (Employee)crit.uniqueResult();
		session.delete(delentity);
		
	}

	@Override
	public void deleteUser(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.deleteUser**************");
		// TODO Auto-generated method stub
		Session session=sessionFactoy.getCurrentSession();
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.eq("userId", userReg.getEmpId()));
		Employee delentity = (Employee)crit.uniqueResult();
		session.delete(delentity);
		
		
	}

	@Override
	public int modifyUser(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.modifyUser**************");
		// TODO Auto-generated method stub
		boolean modifyUser = true;
		Session session=sessionFactoy.getCurrentSession();
		Criteria crit = session.createCriteria(Employee.class);
		
		
		String hql="update Employee as emp set "+"fname=:fname,"+"lname=:lname"+" where emailId=:emailId";
	   // Query q=session.createQuery(hql);
		Query q=session.createQuery(hql);
	    q.setParameter("fname",userReg.getFname());  
	    q.setParameter("lname",userReg.getLname());
	    q.setParameter("emailId",userReg.getEmailId());
	 int status1=q.executeUpdate();  
	    if(status1>=1)System.out.println("updated");
	    else{System.out.println("Not found");}
	      
	    
		
		
		
		//crit.add(Restrictions.eq("emailId",userReg.getEmailId()));
		/*EmployeeEntity userUpdate;
		userUpdate =(EmployeeEntity)crit.uniqueResult();
		List list = crit.list();
		if(list.isEmpty()){
			System.out.println("No data found");
			modifyUser = false;
		}
		else{*/
			/*Criteria crit1 = currentSession().createCriteria(EmployeeEntity.class);
			crit1.add(Restrictions.eq("emailId",userReg.getEmailId()));	
			EmployeeEntity entity = (EmployeeEntity)crit1.uniqueResult();
		//	entity.setName(userReg.getName());
			sessionFactory.getCurrentSession().saveOrUpdate(entity);
			modifyUser=true;*/
		//}
		//return modifyUser;
		return status1;

	}

	@Override
	public List<Employee> getUserList(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.getUserList**************");
		// TODO Auto-generated method stub
		List<Employee> userList = new ArrayList<Employee>();
		Session session=sessionFactoy.getCurrentSession();
		
		Criteria crc= session.createCriteria(Employee.class);
				/* .setProjection(Projections.projectionList()
					      .add(Projections.property("fname"), "fname")
					      .add(Projections.property("lname"), "lname"))
					    .setResultTransformer(Transformers.aliasToBean(UserEntity.class));
				*/
				
				
				
	//	Query query = session.createQuery(" from UserEntity");
	//	query.setMaxResults(5);
		try{
			userList = crc.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void updateLoginStatusN(Requestdto userReg) {
		// TODO Auto-generated method stub
				logger.info("******UserRegisterDAOImpl.updateLoginStatusN**************");
				Session session=sessionFactoy.getCurrentSession();
				Criteria crit = session.createCriteria(Employee.class);
				crit.add(Restrictions.eq("emailId",userReg.getEmailId()));	
				Employee entity = (Employee)crit.uniqueResult();
				entity.setLoginStatus("N");
				session.saveOrUpdate(entity);
		
	}

	@Override
	public boolean checkEmpId(String userReg) {
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public boolean checkemailId(String userReg) {

		logger.info("******UserRegisterDAOImpl.checkEmailIdo**************");
		//Session session  = sessionFactory.openSession().createCriteria(Employee.class);
	//	Session session=null;
		Session session=sessionFactoy.getCurrentSession();
		Criteria crc=sessionFactoy.getCurrentSession().createCriteria(Employee.class);
		//Criteria crc=sessionFactoy.openSession().createCriteria(Employee.class);
	//	Criteria crc = openSession().createCriteria(Employee.class);
		crc.add(Restrictions.eq("emailId",userReg)).setProjection(Projections.rowCount());
		System.out.println("email: "+userReg);
		int count = (int)((long)crc.uniqueResult());
		System.out.println(count);
		if(count>0){
			
		//	System.out.println("EmailId is exited");
			return true;
		}
		//System.out.println("COrrectd");
		return false;

	}

	@Override
	public boolean checkempId(int userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.checkEmailIdo**************");
		Session session  = sessionFactoy.getCurrentSession();
		Criteria crc = session.createCriteria(Employee.class);
		crc.add(Restrictions.eq("empId",userReg)).setProjection(Projections.rowCount());
		System.out.println("EmpId"+userReg);
		int count = (int)((long)crc.uniqueResult());
		System.out.println(count);
		if(count>0){
			
		//	System.out.println("EmailId is exited");
			return true;
		}
		//System.out.println("COrrectd");
		return false;
	}

	@Override
	public boolean checkanswered(Requestdto userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.checkANswered**************");
		Session session=sessionFactoy.getCurrentSession();
		
		
		//List<Answeres> ans=new ArrayList<Answeres>();
		Answeres ans=new Answeres();
		Criteria crc1=session.createCriteria(Question.class);
		crc1.add(Restrictions.eq("q_id", userReg.getQ_id())).setProjection(Projections.rowCount());
		
	
		System.out.println("Q_Id"+userReg.getQ_id());
		boolean count = crc1.setMaxResults(1) != null;
		System.out.println(count);
		if(count){
			
		//	System.out.println("EmailId is exited");
			return true;
		}
		//System.out.println("COrrectd");
		return false;
		

	}

	@Override
	public List<Answeres> getAnsweres(int q_id) {
		// TODO Auto-generated method stub
		List<Answeres> quelist=new ArrayList<Answeres>();	
		Session session=sessionFactoy.getCurrentSession();
		Criteria crit=session.createCriteria(Answeres.class);
	    crit.add(Restrictions.eq("Questionid", q_id));
	
	try{
		 quelist = crit.list();
		}catch(Exception ex)
	{
	ex.printStackTrace();		
	}
		
		return quelist;
		//return null;
	}

	@Override
	public Employee isUserExist(ResetPassword resetPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String resetPassword(String emailId, String encriptString) {
		// TODO Auto-generated method stub
		try {
			

			String returnMag ="";
			Session session=sessionFactoy.getCurrentSession();
			Query crit=session.createQuery("update Employee emp set emp.password=?" + 
					"where emp.emailId=?");
			//Criteria crit = currentSession().createCriteria(UserEntity.class);
			crit.setParameter("emailId", emailId );
			crit.setParameter("password", encriptString );
			int res=crit.executeUpdate();
		//	crit.add(Restrictions.eq("emailId",userReg.getEmailId()));	
		if(res==1) {
			return StatusCode.SUCCESS.name();
		}
	
	
		}catch(Exception e)
		{
			e.printStackTrace();
			return StatusCode.ERROR.name();
		}
		return encriptString;
	}
	
}
