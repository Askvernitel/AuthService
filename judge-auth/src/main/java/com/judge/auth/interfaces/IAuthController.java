package com.judge.auth.interfaces;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.judge.auth.dto.LoginDTO;
import com.judge.auth.dto.RegisterDTO;

@RequestMapping("/api/v1/auth")
public interface IAuthController {

	@PostMapping("/login")
	public LoginDTO login();

	@PostMapping("/register")
	public RegisterDTO register();

}
