package com.back.prev.util;

import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtToken {
	
	private static String secret = "ASDLASDJ!";
	
    public static Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
	
    public static Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
    
    private static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
	
	public static Integer decodeToken(String token) {
		try {
			JwtToken.isTokenExpired(token);
			Claims claims = Jwts.parser()
	        .setSigningKey(secret)
	        .parseClaimsJws(token)
	        .getBody();
			Integer userToken = (Integer) claims.get("idUsuario");
			return userToken;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
