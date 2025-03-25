package com.judge.auth.dto;

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
	private String email;
	private String password;
}
