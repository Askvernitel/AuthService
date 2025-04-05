package com.judge.auth.services.security;

import java.util.Date;

import com.judge.auth.dto.JWTEncodable;
import com.judge.auth.util.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.judge.auth.dto.AuthResponse;
import com.judge.auth.dto.LoginDTO;
import com.judge.auth.dto.RegisterDTO;
import com.judge.auth.entities.User;
import com.judge.auth.repositories.UserRepository;
import com.judge.auth.services.security.jwt.JWTService;

/**
 * AuthService
 */

@Service
public class AuthService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JWTService jwtService;

	private Boolean userExists(RegisterDTO user) {
		return userRepository.findOneByEmail(user.getEmail()) != null;
	}

	public AuthResponse register(RegisterDTO user) {
		if (userExists(user)) {
			System.out.println("Exist");
			// TODO: throw user exists exception
			return null;
		}
		JWTEncodable jwtEncodable = new JWTEncodable();
		Helpers.copySameFieldsFromTo(user, jwtEncodable);
		User userEntity = new User();
		userEntity.setEmail(user.getEmail());
		userEntity.setUsername(user.getUserName());
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		userEntity.setPassword(encodedPassword);
		userRepository.save(userEntity);
		String token = jwtService.generateJWT(jwtEncodable);
		return new AuthResponse(token);
	}

	public AuthResponse login(LoginDTO user) {
		JWTEncodable jwtEncodable=new JWTEncodable();
		Helpers.copySameFieldsFromTo(user, jwtEncodable);
		String token =jwtService.generateJWT(jwtEncodable);
		return new AuthResponse(token);
	}
}
