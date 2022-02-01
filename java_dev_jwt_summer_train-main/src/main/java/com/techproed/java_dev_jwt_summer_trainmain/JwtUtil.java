package com.techproed.java_dev_jwt_summer_trainmain;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.SignatureAlgorithm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;


@Service
public class JwtUtil {
	
	private String SECRET_KEY = "summertrsummertrsummertrsummertrsummertrsummertrsummertrsummertrsummertr";
	
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
	
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
	
	public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
	//this is getting token and returning username as string 
	
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
  //in jwt u can put time for every token like in every 2 weeks i wanna update my token for security
  //this is to get expiration
	
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
  //this is to check if token is expired or not 
    
    private String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder()
        		.setClaims(claims)
        		.setSubject(subject)
        		.setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        
    }
  //this one create token by using map and object like user object
  //if u use send method u can select exp date it gets current time making it 10 hours this is in milliseconds
  //it's settinf exp date 10 hrs after current time
  //it shows what algorith is being used and the secret key 
  //we made it long at the top it shouldn't be short
    
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }
  //this is getting user details username pass authorities so this method generates tokens by using user details
    
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
  //this is the validate token method
  //it will validate the username and password and create token
  //if token is ok for user details it will work
  //it's checking expiration as well 

  //we will use methods from this class
}
