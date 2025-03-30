package com.judge.auth.services.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.judge.auth.dto.LoginDTO;
import com.judge.auth.dto.RegisterDTO;
import com.judge.auth.entities.User;
import com.judge.auth.repositories.UserRepository;

/**
 * AuthService
 */

@Service
public class AuthService {
	@Autowired
	UserRepository userRepository;

	private Boolean userExists(RegisterDTO user) {
		return userRepository.findOneByEmail(user.getEmail()) != null;
	}

	public void register(RegisterDTO user) {
		if (userExists(user)) {
			// TODO: throw user exists exception
			return;
		}
		User userEntity = new User();
		userEntity.setEmail(user.getEmail());
		userEntity.setUsername(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userRepository.save(userEntity);
	}

	public void login(LoginDTO user) {

	}
}
