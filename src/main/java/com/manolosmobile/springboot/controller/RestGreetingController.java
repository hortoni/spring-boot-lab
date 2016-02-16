package com.manolosmobile.springboot.controller;

import com.manolosmobile.springboot.model.Greeting;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestGreetingController {
	
	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	private List<Greeting> greetings = new ArrayList<>();
	
	@RequestMapping("/create")
	public Greeting createGreeting(@RequestParam(value="name", required=true) String name) {
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name)); 
		greetings.add(greeting);
		return greeting;
	}
	
	@RequestMapping("/get")
	public Greeting getGreeting(@RequestParam(value="id", required=true) long id) {
		for (Greeting greeting : greetings) {
			if (greeting.getId() == id) {
				return greeting;
			}
		}
		return null;
	}
	
	@RequestMapping("/get/{id}")
	public Greeting getGreeting2(@PathVariable(value="id") long id) {
		for (Greeting greeting : greetings) {
			if (greeting.getId() == id) {
				return greeting;
			}
		}
		return null;
	}

	@RequestMapping("/getGreetingList")
	public List <Greeting> getGreetingList() {
		return greetings;
	}
}
