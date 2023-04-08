package Prac5;

public class Employee extends Person{
	double salary;
	String department;
	
	Employee(String n,int a,double sal,String de){
		super(n,a);
		salary=sal;
		department=de;
	}
	

}
