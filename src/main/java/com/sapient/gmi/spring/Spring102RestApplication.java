package com.sapient.gmi.spring;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring102RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring102RestApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(AccountRepository accountRepository,
			BookmarkRepository bookmarkRepository) {
		return (evt) -> Arrays.asList(
				"John,David,Abraham,Jesus,Ramses,Moses".split(","))
				.forEach(
						a -> {
							Account account = accountRepository.save(new Account(a,
									"password"));
							bookmarkRepository.save(new Bookmark(account,
									"http://bookmark.com/1/" + a, "A description for first bookmark " + a));
							bookmarkRepository.save(new Bookmark(account,
									"http://bookmark.com/2/" + a, "A description for second bookmark " + a));
						});
	}
}
