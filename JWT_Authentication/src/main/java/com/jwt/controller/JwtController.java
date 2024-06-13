package com.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.model.User;
import com.jwt.services.UserServices;

@RestController
@RequestMapping("/jwt")
public class JwtController {
	
	@Autowired
	private UserServices service;
	
	@GetMapping("/check")
	public ResponseEntity<List<User>> justCheck()
	{
		List<User> listOfUser = this.service.listOfUser();
		return ResponseEntity.ok(listOfUser);
	}

}
