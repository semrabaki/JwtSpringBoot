package com.techproed.java_dev_jwt_summer_trainmain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@GetMapping(path="/students")
	public String getStudents() {
		
		return "Ali Can, Veli Han, Kemal Kuzu";
	}

}
