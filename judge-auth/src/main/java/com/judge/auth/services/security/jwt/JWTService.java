package com.judge.auth.services.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.Base64.Decoder;

import javax.crypto.SecretKey;

import com.judge.auth.dto.JWTEncodable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.judge.auth.dto.RegisterDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

/**
 * JWTService
 */
@Service
public class JWTService {
	@Value("${JWT_SECRET_TOKEN}")
	private String secretKey;

	public String generateJWT(JWTEncodable jwtEncodable) {
		return Jwts.builder().signWith(getSigningKey()).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + 1000*60*24))
				.claim("email", jwtEncodable.getEmail())
				.claim("userName", jwtEncodable.getUserName()).compact();
	}
	/*
	 * public Boolean isExpiredJWT(String token) {
	 * 
	 * }
	 * 
	 * public Boolean isValidJWT(String token) {
	 * 
	 * }
	 */

	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(getSigningKey()).build().parseSignedClaims(token).getPayload();
	}

	private Key getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
