package com.creditcard.bureo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.creditcard.bureo.rest.CreditCardBureoController;
import com.creditcard.bureo.security.AuthenticationFilter;

@SpringBootApplication
@ComponentScan(basePackages={"com.creditcard.bureo.rest","com.creditcard.bureo.service",
		"com.creditcard.bureo.reposiroty","com.creditcard.bureo.exception",
		"com.creditcard.bureo.entity","com.creditcard.bureo.model","com.creditcard.bureo.security"}, basePackageClasses=CreditCardBureoController.class)
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class Application {
	
	public static void main(String args[]){
		SpringApplication.run(Application.class, args);
		
	}
	
	@Bean
    public FilterRegistrationBean authenticationFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new AuthenticationFilter());
        registration.addUrlPatterns("/creditcard/*");
        return registration;
    }

}
