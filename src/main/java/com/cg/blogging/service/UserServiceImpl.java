package com.cg.blogging.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.UserJPARepository;
import com.cg.blogging.entities.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserJPARepository userJPARepository;
	
	public List<User> updateNewUser(User user) {
		userJPARepository.saveAndFlush(user);
		return userJPARepository.findAll();
	}
	
	public User findUser(Integer userId) {
		Optional<User>u=userJPARepository.findById(userId);
		return u.get();
	}
	
	public List<User> deleteUser(Integer userId) {
		userJPARepository.deleteById(userId);
		return userJPARepository.findAll();
		
	}

}
