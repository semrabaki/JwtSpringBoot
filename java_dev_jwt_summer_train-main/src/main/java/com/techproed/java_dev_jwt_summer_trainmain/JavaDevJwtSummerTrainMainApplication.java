package com.techproed.java_dev_jwt_summer_trainmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaDevJwtSummerTrainMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaDevJwtSummerTrainMainApplication.class, args);
	}

}

//note to students when you run at the end of coding
//instead of nimda for next request you use this token app will check it instead of simple password
//there is 3 parts in token
//how to use it
//go to header type Authorization and for value paste ur token without "" add Bearer and space
//based on my code it will get token after 7 characters
//by using that token we can do any request
//do get without any authorization
//localhost:8081/students i should see the 3 names