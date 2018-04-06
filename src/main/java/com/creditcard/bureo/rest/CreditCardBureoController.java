package com.creditcard.bureo.rest;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.creditcard.bureo.entity.UserEntity;
import com.creditcard.bureo.exception.InvalidCreditCardException;
import com.creditcard.bureo.model.CreditCardResponse;
import com.creditcard.bureo.service.CreditCardService;

@Controller
@RequestMapping("/creditcard")
public class CreditCardBureoController {
	
	private static final Log logger = LogFactory.getLog(CreditCardBureoController.class);
	
	@Autowired
	private CreditCardService creditCardService;
	
	@Autowired
	private CreditCardResponse creditCardResponse;
	
	@RequestMapping( method=RequestMethod.GET, value="/{ssn}")
	@ResponseBody
	public ResponseEntity<CreditCardResponse> getUserInfo(  @PathVariable String ssn, HttpServletRequest request){
		
		
		UserEntity userInfo = null;
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.add("X-Request-ID", request.getHeader("X-Request-ID"));
		
		
		try {
			
			userInfo = creditCardService.getUser(ssn);
			
		} 
		catch(InvalidCreditCardException ex){
			
			throw new InvalidCreditCardException();
			
		}
		catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
		
		creditCardResponse = new CreditCardResponse("SUCCESS",userInfo.isCreditScoreGood()?"Eligible for credit limit increase":"Not eligible for credit limit increase","" );
			
	    return new ResponseEntity<CreditCardResponse>(creditCardResponse,responseHeaders, HttpStatus.OK);
			
		
	}
	

}
