package com.judge.auth.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.judge.auth.dto.AuthResponse;
import com.judge.auth.dto.LoginDTO;
import com.judge.auth.dto.RegisterDTO;

@RequestMapping("/api/v1/auth")
public interface IAuthController {

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(LoginDTO loginData) throws Exception;

	@PostMapping("/register")
	public ResponseEntity<AuthResponse> register(RegisterDTO registerData) throws Exception;

}
