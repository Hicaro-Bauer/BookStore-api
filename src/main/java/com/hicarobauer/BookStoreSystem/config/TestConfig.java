package com.hicarobauer.BookStoreSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.hicarobauer.BookStoreSystem.service.DBService;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	DBService dbService;
	
	@Override
	public void run(String... args) throws Exception {
		dbService.instanciaBanco();
	}
}
