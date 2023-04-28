package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class FormController {
	@RequestMapping("/")
	public String root() {
		return "form";
	}
	@RequestMapping("/test1")
	public String test1(HttpServletRequest req,Model model){
		String age=	req.getParameter("age");
		String name= req.getParameter("name"); 
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "test1";
	}
	@RequestMapping("/test2")
	public String test2(@RequestParam("age") String age,@RequestParam("name") String name,Model model) {
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "test1";
	}
	@RequestMapping("/test3/{personname}/{personage}")
	public String getPathInfo(@PathVariable String personname,@PathVariable String personage,Model model) {
		model.addAttribute("name",personname);
		model.addAttribute("age",personage);
		return "test1";
	}
	
	@RequestMapping("/test4")
	public String test4(PersonDTO person,Model model) {
		model.addAttribute("person",person);
		return "test2";
	}
}
