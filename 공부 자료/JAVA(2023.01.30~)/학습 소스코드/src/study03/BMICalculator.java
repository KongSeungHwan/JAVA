package study03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BMICalculator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("몸무게 입력(kg):");
		double weight = Double.parseDouble(n.readLine());
		System.out.println("키 입력(m) :");
		double tall = Double.parseDouble(n.readLine());
		//BMI 지수 계산
		double bmi = calculateBMI(weight,tall);
		printBMIClassification(bmi);
	}

	static double calculateBMI(double weight,double tall) {
		return weight/Math.pow(tall, 2);
	}
	static void printBMIClassification(double bmi) {
		String bmiClass = "";
		//조건문 
		if(bmi<18.5) {
			bmiClass="저체중";
		}else if((bmi>=18.5)&&(bmi<25)){
			bmiClass="정상";
		}else if((bmi>=25)&&(bmi<30)) {
			bmiClass="과제중";
		}else {
			bmiClass="비만";
		}
		System.out.printf("당신의 bmi수치는 %.2f %n%s 입니다",bmi,bmiClass);
	}
}
