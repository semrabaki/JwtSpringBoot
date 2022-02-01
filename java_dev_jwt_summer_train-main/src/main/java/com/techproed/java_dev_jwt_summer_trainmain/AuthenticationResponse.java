package com.techproed.java_dev_jwt_summer_trainmain;

public class AuthenticationResponse  { //This class is to store the token inside it
	
	private final String jwt;
	
	public AuthenticationResponse (String jwt)
	{
		this.jwt=jwt;
	}
	
	public String getJwt() {
		return jwt;
	}
	

}
