package com.app.P2PLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.P2PLibrary.pojos.User;
import com.app.P2PLibrary.service.IUserService;

@RestController
@CrossOrigin(allowedHeaders = "*",origins="*")
public class UserController {
	
	@Autowired
	IUserService service;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(@RequestBody User user){
		User temp=service.login(user);
		if(temp!=null) {
			return new ResponseEntity<User>(temp,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Authentication failed!!",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user){
		if(service.register(user)) {
			return new ResponseEntity<String>("Succesfull",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Email or Mobile No already exist",HttpStatus.OK);
	}

	@RequestMapping(value = "/updateUser",method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestParam String phone,@RequestParam Integer userid ){
		try {
				service.updateUser(phone, userid);	
				return new ResponseEntity<String>("User details updated",HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity<String>("Update details failed!!",HttpStatus.OK);		
	}
}
