package com.nat.shorturl;

import org.springframework.boot.SpringApplication;

public class TestShorturlApplication {

	public static void main(String[] args) {
		SpringApplication.from(ShorturlApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
