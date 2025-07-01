package com.example.springtutorial_jdbc;

import com.example.springtutorial_jdbc.model.Person;
import com.example.springtutorial_jdbc.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringtutorialJdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringtutorialJdbcApplication.class, args);
		Person person = context.getBean(Person.class);
		person.setAge(21);
		person.setName("John");


		PersonService personService =  context.getBean(PersonService.class);
		personService.addPerson(person);
		List<Person> allPerson=personService.showAllPersons();

	}

}
