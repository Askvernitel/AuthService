package com.judge.auth.services.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.Base64.Decoder;

import javax.crypto.SecretKey;

import com.judge.auth.dto.JWTEncodable;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.judge.auth.dto.RegisterDTO;

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
				.claim("name", jwtEncodable.getName()).compact();
	}

	public Boolean isExpiredJWT(String token) {
		Claims claims = getClaims(token);
		return claims.getExpiration().before(new Date());
	}

	public Boolean isValidJWT(String token) {
		return isExpiredJWT(token);
	 }


	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(getSigningKey()).build().parseSignedClaims(token).getPayload();
	}

	private Key getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
