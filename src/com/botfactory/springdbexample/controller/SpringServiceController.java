package com.botfactory.springdbexample.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.botfactory.springdbexample.dao.UserService;
import com.botfactory.springdbexample.domain.User;

@RestController
@RequestMapping("/service/user")
public class SpringServiceController {

	UserService userService = new UserService();

	@RequestMapping(value = "/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	public User getUser(@PathVariable int id){
		User user = userService.getUserById(id);
		return user;
	}

	@RequestMapping(method = RequestMethod.GET, headers="Accept=application/json")
	public List<User> getAllUsers(){
		List<User> users = userService.getAllUsers();
		return users;
	}
}
