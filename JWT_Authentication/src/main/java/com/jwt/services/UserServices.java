package com.jwt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwt.model.User;

@Service
public class UserServices {
	
	
	List<User> user=new ArrayList<>();
	
	
	public List<User> listOfUser()
	{
		this.user.add(new User(UUID.randomUUID().toString(), "avinash", "123"));
		this.user.add(new User(UUID.randomUUID().toString(), "vicky", "123"));
		this.user.add(new User(UUID.randomUUID().toString(), "piggy", "123"));
		return user;
	}

}
