package com.bilgeadam.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.bilgeadam.springbootrest.restclient.MyRestClientExample;


@SpringBootApplication
@ComponentScan(basePackages = {"com.bilgeadam.springbootrest"})
public class SpringbootrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestApplication.class, args);
//		MyRestClientExample restclient = new MyRestClientExample();
//		restclient.getByIdEntity();
//		restclient.getAllEntity();
	}

}
