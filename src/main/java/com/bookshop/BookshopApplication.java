package com.bookshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bookshop")
//public class BookshopApplication extends SpringBootServletInitializer {
public class BookshopApplication{
	/*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BookshopApplication.class);
    } */

	public static void main(String[] args) {
		SpringApplication.run(BookshopApplication.class, args);
	}

}
