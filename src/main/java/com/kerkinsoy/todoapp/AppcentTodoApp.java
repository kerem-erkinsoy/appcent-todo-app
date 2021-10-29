package com.kerkinsoy.todoapp;

import com.kerkinsoy.todoapp.repository.TodoRepository;
import com.kerkinsoy.todoapp.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Appcent Todo App API", version = "1.0", description = "User and Todo CRUD REST API"))
//@SecurityScheme(name = "javainuseapi", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)

@SpringBootApplication
public class AppcentTodoApp implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AppcentTodoApp.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		
	}
}
