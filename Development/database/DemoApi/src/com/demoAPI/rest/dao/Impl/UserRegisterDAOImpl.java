package com.demoAPI.rest.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transaction;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;



import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.demoAPI.rest.dao.HibernateDao;
import com.demoAPI.rest.dao.UserRegisterDAO;
import com.demoAPI.rest.dto.request.RequestDTO;
import com.demoAPI.rest.dto.response.ResponseDTO;
import com.demoAPI.rest.entity.Answeres;
import com.demoAPI.rest.entity.EmployeeEntity;
import com.demoAPI.rest.entity.Question1;
import com.demoAPI.rest.entity.Questions;
import com.demoAPI.rest.entity.Recent;
//import com.demoAPI.rest.entity.Tags1;
import com.demoAPI.rest.entity.UserEntity;
import com.demoAPI.rest.util.Helper;
import com.itextpdf.text.log.SysoCounter;

@Repository()
public class UserRegisterDAOImpl extends HibernateDao implements UserRegisterDAO{

	private static final Logger logger = Logger.getLogger(UserRegisterDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	Helper hepler;
	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public ResponseDTO saveUserreg(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.saveUserreg**************");
		// TODO Auto-generated method stub
		String returnMag ="";
		ResponseDTO response= new ResponseDTO();
		Session session  = currentSession();
		UserEntity user = new UserEntity();
		Criteria crc = session.createCriteria(UserEntity.class);
		user.setFname(userReg.getFname());
		user.setLname(userReg.getLname());
		user.setDob(userReg.getDob());
		user.setAddress(userReg.getAddress());
		user.setEmailId(userReg.getEmailId());
		user.setEmpId("snipe"+user.getUserRef());
		System.out.println(user.getUserRef());
	
		user.setMobileNo(userReg.getMobileNo());
		//user.setAddress(userReg.getAddress());
    	user.setPwd(userReg.getPwd());
		user.setState(userReg.getState());
		user.setCountry(userReg.getCountry());
		
		user.setGender("Male");
		
		user.setDate(new Date());
		user.setPwd(hepler.getPasswordEncoded(userReg.getPwd(),userReg.getEmailId()));
		user.setLoginStatus("N");
		session.save(user);
		System.out.println("Saved");
		
		returnMag = "Congratulations!!"+user.getName() +" Registration successfull";
		System.out.println(""+userReg.getFname());
		 response.setReturnMsg(returnMag);
			
		
	    //response.setUserEntity(user);
		
		response.setMessageReturn("E"+user.getUserRef());
		return response;
	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public String getpwd(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.getpwd**************");
		// TODO Auto-generated method stub
		Session session = currentSession();
		Criteria crc = session.createCriteria(UserEntity.class);
		crc.add(Restrictions.eq("emailId",userReg.getEmailId()))
		.setProjection(Projections.property("pwd"));
		String pwd = (String) crc.uniqueResult();
		return pwd;
	}
	
	
	/*
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public String getTagId(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.getquestions**************");
		// TODO Auto-generated method stub
		Session session = currentSession();
		Criteria crc = session.createCriteria(Question1.class);
		crc.add(Restrictions.eq("tag_name",userReg.getTag_id()))
		.setProjection(Projections.property("que"));
		
		System.out.println("Hellow");
		Object tag_name = (String) crc.uniqueResult();
		
		return (String) tag_name;
	}
	*/
	


	
	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public List<UserEntity> getUserList(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.getUserList**************");
		// TODO Auto-generated method stub
		List<UserEntity> userList = new ArrayList<UserEntity>();
		Session session = currentSession();
		Criteria crc= session.createCriteria(UserEntity.class);
		
	//	Session session  = currentSession();
		//Criteria crc = session.createCriteria(UserEntity.class);
		Query query = session.createQuery("select userentity.address from UserEntity userentity where userentity.userRef = 275");
		//query.setParameter("code", "275");
		//List list = query.list();
		
		
		
		
		try{
			userList = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public boolean modifyUser(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.modifyUser**************");
		// TODO Auto-generated method stub
		boolean modifyUser = true;
		Criteria crit = currentSession().createCriteria(UserEntity.class);
		crit.add(Restrictions.eq("mobileNo",userReg.getMobileNo()));
		UserEntity userUpdate;
		userUpdate =(UserEntity)crit.uniqueResult();
		List list = crit.list();
		if(list.isEmpty()){
			System.out.println("No data found");
			modifyUser = false;
		}
		else{
			Criteria crit1 = currentSession().createCriteria(UserEntity.class);
			crit1.add(Restrictions.eq("mobileNo",userReg.getMobileNo()));	
			UserEntity entity = (UserEntity)crit1.uniqueResult();
		//	entity.setName(userReg.getName());
			sessionFactory.getCurrentSession().saveOrUpdate(entity);
		}
		return modifyUser;
	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public void deleteUser(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.deleteUser**************");
		// TODO Auto-generated method stub
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(EmployeeEntity.class);
		crit.add(Restrictions.eq("emailId", userReg.getEmailId()));
		EmployeeEntity delentity = (EmployeeEntity)crit.uniqueResult();
		sessionFactory.getCurrentSession().delete(delentity);
	}

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public void updateLoginStatusY(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.updateLoginStatus**************");
		Criteria crit = currentSession().createCriteria(UserEntity.class);
		crit.add(Restrictions.eq("emailId",userReg.getEmailId()));	
		UserEntity entity = (UserEntity)crit.uniqueResult();
		entity.setLoginStatus("Y");
		entity.setLastlogin(new Date());
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}
	
	@Override
    @Transactional(value="transactionManager", rollbackFor=Exception.class)
	public void updateLoginStatusN(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.updateLoginStatusN**************");
		Criteria crit = currentSession().createCriteria(UserEntity.class);
		crit.add(Restrictions.eq("emailId",userReg.getEmailId()));	
		UserEntity entity = (UserEntity)crit.uniqueResult();
		entity.setLoginStatus("N");
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public boolean checkemailId(RequestDTO userReg) {

		logger.info("******UserRegisterDAOImpl.checkEmailIdo**************");
		
		Session session  = currentSession();
		Criteria crc = session.createCriteria(UserEntity.class);
		crc.add(Restrictions.eq("emailId",userReg.getEmailId())).setProjection(Projections.rowCount());
		System.out.println("email: "+userReg.getEmailId());
		int count = (int)((long)crc.uniqueResult());
		
		System.out.println(count);
		if(count>0){
			
			System.out.println("COrrectdtyhb");
			return true;
		}
		System.out.println("COrrectd");
		return false;
		
	}
	
	
	
	@Override
	public boolean checkanswered(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
logger.info("******UserRegisterDAOImpl.checkANswered**************");
		
		
		Question1 que=new Question1();
	//	Criteria crc = session.createCriteria(Question1.class);
		
		que.setAns(userReg.getAnswered());
		System.out.println("answerd"+userReg.getAnswered());
		
	//	Criteria crit=session.createCriteria(Answeres.class);
		List<Question1> quelist=new ArrayList<Question1>();
	/*	Query query = session.createQuery("select que.status from Question1 que where que.status = 'N'");
		//query.setParameter("code", "7277");
		System.out.println("query"+query);
		//if(query.equals("N")){*/
		//update User set name=:n where id=:i
		
		
	    //org.hibernate.Transaction tx=session.beginTransaction();  
		Session session  = currentSession();
	    Query q=session.createQuery("update Question1 set ans=:n where id=:i");  
	    q.setParameter("n",userReg.getAnswered());  
	    q.setParameter("i",288);  
	      
	    int status=q.executeUpdate();  
	    System.out.println(status);  
	//    tx.commit();  
		
		
		
		
			//Query query1 = session.createQuery("update Question1 set ans ='user' where q_id=288");
	//	}
		//List list = query.list();
		//quelist = query.list();
		System.out.println("answered");
		return true;
		
		
		
		
	}
	
	

	/*@Override
	public boolean checkTag(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		logger.info("******UserRegisterDAOImpl.checkTags**************");
		// TODO Auto-generated method stub
		Session session  = currentSession();
		Criteria crc = session.createCriteria(Tags1.class);
		crc.add(Restrictions.eq("tag_name",userReg.getTag_name())).setProjection(Projections.rowCount());
		System.out.println("sjdfldksjjkdslfjl");
		int count = (int)((long)crc.uniqueResult());
		if(count>0){
			System.out.println("sjdfldksj");
			return true;
		}
		return false;
		
		
		
	}*/

	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public List<Recent> getrecentList(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		
		
		
		
		
			logger.info("******UserRegisterDAOImpl.getRecentList**************");
			// TODO Auto-generated method stub
			List<Recent> recentList = new ArrayList<Recent>();
			Session session = currentSession();
			Criteria crc= session.createCriteria(Recent.class);
			try{
				recentList = crc.list();
			}catch(Exception e){
				e.printStackTrace();
			}
			return recentList;
		
	}
	

	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public boolean checkAns(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.checkMobileNo**************");
		// TODO Auto-generated method stub
		Session session  = currentSession();
		Criteria crc = session.createCriteria(Recent.class);
		crc.add(Restrictions.eq("fname",userReg.getFname()))
		.setProjection(Projections.rowCount());
		int count = (int)((long)crc.uniqueResult());
		System.out.println(""+userReg.getFname());
		if(count>0){
			return true;
		}
		return false;
	}

	
	
	
	
	
	
	
	
	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public void updateAnsStatusY(RequestDTO userReg) {
		// TODO Auto-generated method stub

		Criteria crit = currentSession().createCriteria(Recent.class);
	//	Criteria crit1 = currentSession().createCriteria(UserEntity.class);
	//	String tag= userRegisterDao.getpwd(userReg);
		logger.info("******UserRegisterDAOImpl.updateAnsStatusY**************");
	//if(fname.equals(heapler.getTag(userReg.getTag(),userReg.getAns())))
		crit.add(Restrictions.eq("fname",userReg.getFname()));	
		

		Recent rec=(Recent)crit.uniqueResult();
	//	rec.setFname("DRFGC");
		rec.setAns_status("Y");
		rec.setAns(userReg.getAns());
		System.out.println("hsdkjfhsdkjfhsdkj");
		sessionFactory.getCurrentSession().saveOrUpdate(rec);

		
		
	}

	@Override
	public List<Recent> getrecentList(ResponseDTO response) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question1> getqueList(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		
		Session session=currentSession();
		Criteria crit=session.createCriteria(Answeres.class);
		List<Question1> quelist=new ArrayList<Question1>();
		Query query = session.createQuery("select que.question from Question1 que where que.status = 'N'");
		//query.setParameter("code", "7277");
		System.out.println(query);
		if(query.equals("N")){
			Query query1 = session.createQuery("select question from Question1");
		}
		//List list = query.list();
		quelist = query.list();
		return quelist;
	}



	
	
	

	
	
	
	
	
}
