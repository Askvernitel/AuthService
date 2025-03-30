package com.judge.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.judge.auth.dto.LoginDTO;
import com.judge.auth.dto.RegisterDTO;
import com.judge.auth.interfaces.IAuthController;
import com.judge.auth.services.security.AuthService;
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

	@Override
	public LoginDTO login(@RequestBody LoginDTO loginData) throws Exception {
		return null;
	}

	@Override
	public RegisterDTO register(@RequestBody RegisterDTO registerData) throws Exception {
		validationService.isValid(registerData);
		authService.register(registerData);
		return null;
	}

}
