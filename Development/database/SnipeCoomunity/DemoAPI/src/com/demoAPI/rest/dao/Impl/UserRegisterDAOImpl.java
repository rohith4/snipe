package com.demoAPI.rest.dao.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
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
import com.demoAPI.rest.entity.Questions;
import com.demoAPI.rest.entity.UserEntity;
import com.demoAPI.rest.util.Helper;

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
		//user.setDob("");
		//user.setName(userReg.getName());
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
		
	//	response.setReturnCode(0);
		response.setMessageReturn(returnMag);
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
	
	


	
	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public List<UserEntity> getUserList(RequestDTO userReg) {
		logger.info("******UserRegisterDAOImpl.getUserList**************");
		// TODO Auto-generated method stub
		List<UserEntity> userList = new ArrayList<UserEntity>();
		Session session = currentSession();
		Criteria crc= session.createCriteria(UserEntity.class);
		try{
			userList = crc.list();
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
		Criteria crit = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		crit.add(Restrictions.eq("mobileNo", userReg.getMobileNo()));
		UserEntity delentity = (UserEntity)crit.uniqueResult();
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
		crit.add(Restrictions.eq("mobileNo",userReg.getMobileNo()));	
		UserEntity entity = (UserEntity)crit.uniqueResult();
		entity.setLoginStatus("N");
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	
	@Override
	@Transactional(value="transactionManager", rollbackFor=Exception.class)
	public boolean checkemailId(RequestDTO userReg) {
		// TODO Auto-generated method stub
		logger.info("******UserRegisterDAOImpl.checkMobileNo**************");
		// TODO Auto-generated method stub
		Session session  = currentSession();
		Criteria crc = session.createCriteria(UserEntity.class);
		crc.add(Restrictions.eq("emailId",userReg.getEmailId())).setProjection(Projections.rowCount());
		int count = (int)((long)crc.uniqueResult());
		if(count>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkTag(RequestDTO userReg) {
		// TODO Auto-generated method stub
		
		logger.info("******UserRegisterDAOImpl.checkTags**************");
		// TODO Auto-generated method stub
		Session session  = currentSession();
		Criteria crc = session.createCriteria(Questions.class);
		crc.add(Restrictions.eq("que",userReg.getTag())).setProjection(Projections.rowCount());
		int count = (int)((long)crc.uniqueResult());
		if(count>0){
			return true;
		}
		return false;
		
		
		
	}
}
