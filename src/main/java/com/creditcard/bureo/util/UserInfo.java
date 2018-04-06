package com.creditcard.bureo.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;

import com.creditcard.bureo.entity.UserEntity;

public class UserInfo {
	
	/*private Map<String, UserEntity> userMap;
	
	@Cacheable(value="users",key="#root.methodName")
	public Map loadUserInfo(){
		
		userMap = new HashMap<String,UserEntity>();
		userMap.put("12345", new UserEntity("12345", "test1", true));
		userMap.put("12121", new UserEntity("12121", "test2", false));
		userMap.put("54321", new UserEntity("54321", "test3", true));
		userMap.put("31331", new UserEntity("31331", "test4", false));
		
		return userMap;
	}*/

}
