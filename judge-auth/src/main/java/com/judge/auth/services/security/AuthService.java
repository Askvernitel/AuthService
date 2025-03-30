package com.judge.auth.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.judge.auth.dto.RegisterDTO;
import com.judge.auth.repositories.UserRepository;

/**
 * AuthService
 */

@Service
public class AuthService {
	@Autowired
	UserRepository userRepository;

	public void register(RegisterDTO user) {

	}
}
