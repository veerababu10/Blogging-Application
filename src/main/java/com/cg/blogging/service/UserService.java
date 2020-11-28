package com.cg.blogging.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.blogging.entities.User;

@Service
public interface UserService {
	
	public List<User> updateNewUser(User user);
	
	public User findUser(Integer userId);
	
	public List<User> deleteUser(Integer userId);
	

}
