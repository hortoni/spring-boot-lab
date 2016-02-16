package com.manolosmobile.springboot.controller;

import com.manolosmobile.springboot.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
	
	@RequestMapping("/greetings")
    public String greetings(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		List<Greeting> greetings = Arrays.asList(restTemplate.getForObject("http://localhost:8080/getGreetingList", Greeting[].class));
        model.addAttribute("greetings", greetings);
        return "greetings";
    }

}
