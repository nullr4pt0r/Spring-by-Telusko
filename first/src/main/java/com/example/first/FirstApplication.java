package com.example.first;

import com.example.first.Alien.Alien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


//leart about DI
@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(FirstApplication.class, args);

		Alien obj = context.getBean(Alien.class);

		obj.code();
	}

}
