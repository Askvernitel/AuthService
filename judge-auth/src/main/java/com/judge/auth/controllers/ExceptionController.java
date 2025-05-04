package com.judge.auth.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.judge.auth.dto.LoginDTO;
import com.judge.auth.exceptions.base.ValidationException;

/**
 * ExceptionController
 * 
 */

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<LoginDTO> handleValidationError() {
		ResponseEntity<LoginDTO> rq = new ResponseEntity<LoginDTO>(new LoginDTO(), HttpStatus.BAD_REQUEST);
		return rq;
	}

}
