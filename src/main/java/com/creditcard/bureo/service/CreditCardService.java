package com.creditcard.bureo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.bureo.entity.UserEntity;
import com.creditcard.bureo.exception.InvalidCreditCardException;
import com.creditcard.bureo.reposiroty.PersonRepository;

@Service
public class CreditCardService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public UserEntity getUser(String ssn) throws InvalidCreditCardException,RuntimeException{
		return personRepository.findOne(ssn);
	}

}
