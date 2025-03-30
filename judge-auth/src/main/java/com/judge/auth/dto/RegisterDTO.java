package com.judge.auth.dto;

import com.judge.auth.annotations.Validate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterDTO {
	@Validate(required = true)
	private String userName;

	@Validate(required = true, email = true)
	private String email;

	@Validate(required = true, minLength = 6)
	private String password;
}
