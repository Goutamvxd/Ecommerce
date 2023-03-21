package com.com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.support.SecurityWebApplicationContextUtils;
import org.springframework.stereotype.Service;

import com.com.app.constants.UserStatus;
import com.com.app.entitiy.User;
import com.com.app.repository.UserRepository;
import com.com.app.service.IUserService;
import com.com.app.util.AppUtil;
import com.com.app.util.MyMailUtil;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private MyMailUtil mailUtil;

	@Override
	public Long saveUser(User user) {
		
		//Generating password
		
		String pwd=AppUtil.genPwd();
		
		//read generate pwd and encode
		
		String encPwd = encoder.encode(pwd);
		
		//set back to user object
		user.setPassword(encPwd);
		
		user.setStatus(UserStatus.INACTIVE.name());
		Long id = userRepository.saveAndFlush(user).getId();
		
		if(id!=null) {
			
		}
		return null;
	}

	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatedUserPwd(String pwd, Long userId) {
		// TODO Auto-generated method stub

	}

}
