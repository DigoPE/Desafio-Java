package com.autentico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AutenticoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutenticoappApplication.class, args);
		//System.out.print(new BCryptPasswordEncoder().encode("123"));
		System.out.print(new BCryptPasswordEncoder().encode("123"));
	}
}
