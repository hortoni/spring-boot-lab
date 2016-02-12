package com.manolosmobile.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.manolosmobile.springboot.model.Greeting;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
	
	@RequestMapping("/greetings")
    public String greetings(Model model) {
		
        model.addAttribute("greetings", getListGreetings());
        return "greetings";
    }
	
	
	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

	}
	
	private List<Greeting> getListGreetings() {
		List<Greeting> list = new ArrayList<Greeting>();
		
		list.add(new Greeting(1, "thiago"));
		list.add(new Greeting(2, "ph"));
		list.add(new Greeting(3, "hortoni"));

		return list;
	}
}
