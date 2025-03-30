package com.judge.auth.dto;

import com.judge.auth.annotations.Validate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * LoginDTO
 */
@Getter
@Setter
@AllArgsConstructor
public class LoginDTO {
	@Validate(email = true, minLength = 10, maxLength = 20)
	private String email;
	@Validate(minLength = 6)
	private String password;
}
