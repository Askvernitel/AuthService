package com.judge.auth.services.security;

import com.judge.auth.dto.JWTEncodable;
import com.judge.auth.exceptions.base.ValidationException;
import com.judge.auth.util.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
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
		//transfer to jwt encodable
		JWTEncodable jwtEncodable = new JWTEncodable();
		Helpers.copySameFieldsFromTo(user, jwtEncodable);
		User userEntity = new User();
		// set entity data
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		userEntity.setPassword(encodedPassword);
		userRepository.save(userEntity);
		String token = jwtService.generateJWT(jwtEncodable);
		return new AuthResponse(token);
	}

	public AuthResponse login(LoginDTO user) throws Exception{
		JWTEncodable jwtEncodable=new JWTEncodable();
		User userEntity = userRepository.findByEmail(user.getEmail()).orElseThrow(() -> new ValidationException("USER_NOT_FOUND"));
		Helpers.copySameFieldsFromTo(userEntity, jwtEncodable);
		System.out.println(userEntity.getName());
		String token =jwtService.generateJWT(jwtEncodable);
		return new AuthResponse(token);
	}
}
