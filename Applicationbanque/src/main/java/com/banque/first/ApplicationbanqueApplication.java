package com.banque.first;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.banque.first.entities.Compte;

@SpringBootApplication
public class ApplicationbanqueApplication {
	public static List<Compte>comptees=new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(ApplicationbanqueApplication.class, args);
		Compte c1=new Compte(1,"feriel",2000.5);
		Compte c2=new Compte(2,"mohamed",2050.5);
		Compte c3=new Compte(3,"adem",3000.5);
		comptees.add(c1);
		comptees.add(c2);
		comptees.add(c3);


	}

}
