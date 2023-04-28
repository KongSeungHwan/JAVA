package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MainController {
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Security";
	}
	@RequestMapping("/guest/welcomeGuest")
	public @ResponseBody String welcomeGuest() throws Exception{
		return "guest/welcomeGuest";
	}
	@RequestMapping("/admin/welcomeAdmin")
	public @ResponseBody String welcomeAdmin() throws Exception{
		return "admin/welcomeAdmin";
	}
	@RequestMapping("/Member/welcomeMember")
	public @ResponseBody String welcomeMember() throws Exception{
		return "member/welcomeMember";
	}
}
