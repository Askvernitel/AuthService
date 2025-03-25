package com.judge.auth.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.judge.auth.dto.LoginDTO;
import com.judge.auth.dto.RegisterDTO;
import com.judge.auth.interfaces.IAuthController;

/**
 * AutheficationController
 */
@RestController
public class AuthController implements IAuthController {

	@Override
	public LoginDTO login() {
		return null;
	}

	@Override
	public RegisterDTO register() {
		return null;
	}

}
