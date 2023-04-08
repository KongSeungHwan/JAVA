package Prac5;

import java.util.ArrayList;

public class Department {
	String name;
	ArrayList<Employee> employees;
	
	void addEmployee(Employee em) {
		employees.add(em);
	}
}
