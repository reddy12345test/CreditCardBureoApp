package com.creditcard.bureo.entity;

import org.springframework.stereotype.Component;

@Component
public class UserEntity {
	
	private String ssn;
	private String name;
	private boolean isCreditScoreGood;
	
	public UserEntity(){
		
	}
	
public UserEntity(String ssn, String name, boolean isCreditCanRaise){
	
	this.ssn = ssn;
	this.name = name;
	this.isCreditScoreGood = isCreditCanRaise;
		
	}
	
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCreditScoreGood() {
		return isCreditScoreGood;
	}
	public void setCreditScoreGood(boolean isCreditScoreGood) {
		this.isCreditScoreGood = isCreditScoreGood;
	}
	
	

}
