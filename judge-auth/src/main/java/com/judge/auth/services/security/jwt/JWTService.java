package com.judge.auth.services.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.judge.auth.dto.RegisterDTO;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

/**
 * JWTService
 */
@Service
public class JWTService {
	@Value("${JWT_SECRET_TOKEN}")
	private String secretKey;

	public String generateJWT(RegisterDTO registerDTO) {
		System.out.println(Jwts.builder().claim("email", registerDTO.getEmail())
				.claim("userName", registerDTO.getUserName()).compact());
		return null;
	}

	public Boolean isValidJWT() {
		return null;
	}

}
