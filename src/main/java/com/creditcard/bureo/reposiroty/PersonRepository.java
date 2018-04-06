package com.creditcard.bureo.reposiroty;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.creditcard.bureo.entity.UserEntity;
import com.creditcard.bureo.exception.InvalidCreditCardException;
import com.creditcard.bureo.rest.CreditCardBureoController;

@Repository
public class PersonRepository  {
	
	private static Map<String,UserEntity> userMap;
	
	private static final Log logger = LogFactory.getLog(CreditCardBureoController.class);
	
	static{
		
		userMap = new HashMap<String,UserEntity>();
		
		userMap = new HashMap<String,UserEntity>();
		userMap.put("12345", new UserEntity("12345", "test1", true));
		userMap.put("12121", new UserEntity("12121", "test2", false));
		userMap.put("54321", new UserEntity("54321", "test3", true));
		userMap.put("31331", new UserEntity("31331", "test4", false));
		
	}
	
	public UserEntity findOne(String ssn) throws InvalidCreditCardException,RuntimeException {
		UserEntity userInfo = null;
		
		if(ssn==null)
		   throw new RuntimeException("SSN Should not be null"); 
		
		userInfo = (UserEntity) userMap.get(ssn);
		if(userInfo==null)
			throw new InvalidCreditCardException();
		return userInfo;
	}

	
}
