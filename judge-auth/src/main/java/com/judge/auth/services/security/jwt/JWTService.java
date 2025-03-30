package com.judge.auth.services.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;

/**
 * JWTService
 */
@Service
public class JWTService {
	@Value("${JWT_SECRET_TOKEN}")
	private String secretKey;

	public String generateJWT() {

		return null;
	}

	public Boolean isValidJWT() {
		return null;
	}

}
