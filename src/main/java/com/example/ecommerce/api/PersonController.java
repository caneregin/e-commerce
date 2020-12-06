package com.example.ecommerce.api;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Person;
import com.example.ecommerce.service.PersonService;
@RequestMapping("api/v1/person")
@RestController
public class PersonController {
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	@PostMapping
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	@GetMapping
	public List<Person> getAllPeople(){
		return personService.getAllPeople();
	}
	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		return personService.getPersonById(id).orElse(null);
	}
}
