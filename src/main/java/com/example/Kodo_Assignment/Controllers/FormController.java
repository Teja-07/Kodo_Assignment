package com.example.Kodo_Assignment.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Kodo_Assignment.Entity.FormEntity;
import com.example.Kodo_Assignment.Service.FormService;

@RestController
@RequestMapping("/form/api")
//Controllers in Spring Boot are Java classes responsible for handling incoming HTTP requests and returning an appropriate response.
public class FormController {
	@Autowired
	private FormService formservice;
	@PostMapping("/details")
	//Used for Calling HTTP REQUEST HERE WE ARE CALLING POST REQUEST
	public FormEntity findByUserDetails(@RequestBody FormEntity formentity) throws Exception {
		return formservice.findByDetails(formentity);//HELPS US TO STORE THE DATA IN DATABASE
	}
}
