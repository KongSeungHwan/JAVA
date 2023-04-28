package com.study.springboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.springboot.bean.Config;
import com.study.springboot.bean.Member;
import com.study.springboot.bean.Printer;

//@SpringBootApplication
public class D02DiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(D02DiApplication.class, args);
		//1.컨테이너(IoC)
		ApplicationContext context= new AnnotationConfigApplicationContext(Config.class);
		
		Member member1 = (Member)context.getBean("member1",Member.class);
		member1.print();
		Member member2 = (Member)context.getBean("hello",Member.class);
		member2.print();
		Member member3 = (Member)context.getBean("member1",Member.class);
		Printer printer = context.getBean("printerB",Printer.class);
		member1.setPrinter(printer);
		member3.print();
		member1.print();
		member2.print();
		member3.print();
		if(member1==member3) {
			System.out.println("동일 객체");
		}else {
			System.out.println("서로 다른 객체");
		}
		
		
	}

}