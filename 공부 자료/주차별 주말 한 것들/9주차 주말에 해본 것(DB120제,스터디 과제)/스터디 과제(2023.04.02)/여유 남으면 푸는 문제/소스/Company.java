package Prac5;

import java.util.ArrayList;

public class Company {
	ArrayList<Department> departments;
	
	void addDepartment(Department em) {
		departments.add(em);
	}
	ArrayList<Employee> getEmployees(){
		ArrayList<Employee> all = new ArrayList<>();
		departments.stream().forEach(de-> de.employees.stream().forEach(em-> all.add(em)));
		return all;
	}
	
}
