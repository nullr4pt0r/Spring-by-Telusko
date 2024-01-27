package com.dnl.jdbc;

import com.dnl.jdbc.model.Alien;
import com.dnl.jdbc.repository.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(JdbcApplication.class, args);
		//create object
		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(111);
		alien1.setName("Raguvaran");
		alien1.setTech("Java");
		//save data in db
		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien1);

		//get all data from db
		System.out.println(repo.getAllAlien());
		//get data by id
		System.out.println(repo.getAlienById(111));

	}

}
