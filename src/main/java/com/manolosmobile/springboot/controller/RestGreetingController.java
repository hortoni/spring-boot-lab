package com.manolosmobile.springboot.controller;

import com.manolosmobile.springboot.model.Greeting;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RestGreetingController {

	private final AtomicLong counter = new AtomicLong();
	private List<Greeting> greetings = new ArrayList<>();

	@RequestMapping("/create")
	public Greeting createGreeting(@RequestParam(value="name", required=true) String name) {
		Greeting greeting = new Greeting(counter.incrementAndGet(), "Hello, " + name);
		greetings.add(greeting);
		return greeting;
	}

	@RequestMapping("/get")
	public Greeting getGreetingByRequestParam(@RequestParam(value="id", required=true) long id) {
        return getGreeting(id);
	}

	@RequestMapping("/get/{id}")
	public Greeting getGreetingByPathVariable(@PathVariable(value="id") long id) {
		return getGreeting(id);
	}

    private Greeting getGreeting(long id) {
        return greetings.stream().filter(g -> g.getId() == id).findFirst().orElse(null);
    }

	@RequestMapping("/getGreetings")
	public List<Greeting> getGreetings() {
		return greetings;
	}

}
