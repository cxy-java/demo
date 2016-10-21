package cn.springboot.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecutityController {

	@PostMapping
	public void login(){
		
	}
	
	@GetMapping("/getuser")
	public void getUser(){
		
	}
}
