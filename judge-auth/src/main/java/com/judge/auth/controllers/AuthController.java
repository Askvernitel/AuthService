package com.judge.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.judge.auth.dto.AuthResponse;
import com.judge.auth.dto.LoginDTO;
import com.judge.auth.dto.RegisterDTO;
import com.judge.auth.interfaces.IAuthController;
import com.judge.auth.services.security.AuthService;
import com.judge.auth.services.security.jwt.JWTService;
import com.judge.auth.services.validation.ValidationService;

/**
 * AutheficationController
 */
@RestController
public class AuthController implements IAuthController {
	@Autowired
	ValidationService validationService;
	@Autowired
	AuthService authService;
	@Autowired
	JWTService jwtService;

	@Override
	public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO loginData) throws Exception {

		validationService.isValid(loginData);
		return	ResponseEntity.ok(authService.login(loginData));
	}

	@Override
	public ResponseEntity<AuthResponse> register(@RequestBody RegisterDTO registerData) throws Exception {
		validationService.isValid(registerData);
		return ResponseEntity.ok(authService.register(registerData));
	}

}
