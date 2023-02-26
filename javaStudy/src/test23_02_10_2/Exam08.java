package test23_02_10_2;

import java.util.ArrayList;
import java.util.Arrays;

class Calculator{
	int value;
	Calculator(){
		value=0;
	}
	void add(int val) {
		
		value+=val;
	}
	int getValue() {
		return value;
	}
	boolean isEven(int a) {
		if(a==0)return false;
		if(a%2==0){ return true;}
		else {return false;}
	}
	double avg(int[] arr) {
		int avg = 0;
		for (int i : arr) {
			avg+=i;
		}
		return avg/arr.length;
	}
	double avg(ArrayList<Integer> arr) {//끝!
		int avg = 0;
		for (int i : arr) {
			avg+=i;
		}
		return avg/arr.size();
	}

}

class UpgradeCalculator extends Calculator{ 
	//자식 클래스 생성자에는 늘 super(); 가 생략되어있다.
	void minus(int a){
		value-=a;
	}
}
class MaxLimitCalculator extends Calculator{ 
	//자식 클래스 생성자에는 늘 super(); 가 생략되어있다.
	
	MaxLimitCalculator(int value){
		this.value = value;
	}
	@Override
	void add(int val) {
		if((value+val)>=100){value=100;}else{
		value+=val;}
	}
}

public class Exam08 {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.add(10);
		System.out.printf("cal의 value필드: %d \n",cal.getValue());
		UpgradeCalculator cal1 = new UpgradeCalculator();
		cal1.add(10);
		System.out.printf("cal1의 value필드: %d \n",cal1.getValue());
		cal1.minus(7);
		System.out.printf("cal1의 value필드: %d \n",cal1.getValue());
		MaxLimitCalculator cal3 = new MaxLimitCalculator(50);
		 //급내 많이 더해도? 100이다~
		System.out.println("+40");
		cal3.add(40);
		System.out.printf("뭘 더해 봤자 100이여 cal3의 value값 %d +40 \n", cal3.getValue());
		cal3.add(40);
		System.out.printf("뭘 더해 봤자 100이여 cal3의 value값 %d \n", cal3.getValue());
		
		Calculator cal4 = new Calculator();
		System.out.println(cal4.isEven(3));
		System.out.println(cal4.isEven(4));
		System.out.println(cal4.isEven(0)); //끝
		
		Calculator cal5 = new Calculator();
		int[] data1 = {1,3,5,7,9};
		ArrayList<Integer> data2 = new ArrayList<>(Arrays.asList(1,3,5,6,7,9,20));
		System.out.println( (int)Math.round(cal5.avg(data1)) );
		System.out.println( cal5.avg(data2) );//끄읕
		
	}
}
