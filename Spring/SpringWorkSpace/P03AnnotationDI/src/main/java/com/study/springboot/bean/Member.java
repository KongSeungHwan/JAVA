package com.study.springboot.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Member {
	@Value("나문희")
	private String name;
	@Value("호박고구마")
	private String nickName;
	@Autowired
	@Qualifier("PrinterA")
	private Printer printer;
	
	public Member() {}
	public Member(String name, String nickName, Printer printer) {
		this.name = name;
		this.nickName = nickName;
		this.printer = printer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Printer getPrinter() {
		return printer;
	}

	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	public void print() {
		System.out.println("퉤"+name+" "+nickName);
	}

	
	
}
