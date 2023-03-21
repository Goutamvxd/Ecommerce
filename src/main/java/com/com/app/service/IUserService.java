package com.com.app.service;

import java.util.List;
import java.util.Optional;

import com.com.app.entitiy.User;

public interface IUserService {
	
	Long saveUser(User user);
	 Optional<User> findByEmail (String email);
	 List<User> getAllUsers();
	 void updatedUserPwd(String pwd,Long userId);

}
