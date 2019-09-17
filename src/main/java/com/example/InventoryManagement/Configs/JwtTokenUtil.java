package com.example.InventoryManagement.Configs;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.InventoryManagement.Models.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
 * The JwtTokenUtil is responsible for performing JWT operations like creation and validation. 
 * It makes use of the io.jsonwebtoken.Jwts for achieving this.
 */

@Component
public class JwtTokenUtil implements Serializable {
		
	private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	

	//@Value("${jwt.secret}")
	private String secret = "SecretKeyToGenJWTs";
	
	//retrieve username from jwt token
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}
	
	//retrieve expiration date
	public Date getExpirationFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claim = getAllClaimsfromToken(token);
		
		return claimsResolver.apply(claim);
	}

	//for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsfromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expdate = getExpirationFromToken(token);
		return expdate.before(new Date());
	}
	
	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, user.getUsername());
		}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public Boolean validateToken(String token, User user) {
		final String userName = getUsernameFromToken(token);
		return (userName.equals(user.getUsername()) && !isTokenExpired(token));
	}
}
