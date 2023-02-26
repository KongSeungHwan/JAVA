package javaStudy;

import java.time.LocalDate;

public class ConditionalPrac {

	public static void main(String[] args) {
		LocalDate a = LocalDate.now();
		String dayOfWeek = a.getDayOfWeek().toString();
		int dayOfWeekValue = a.getDayOfWeek().getValue();
		System.out.println(dayOfWeek+" "+dayOfWeekValue);

		String result = "";
		if(dayOfWeekValue==1|| dayOfWeekValue ==2 
				||dayOfWeekValue==3|| dayOfWeekValue==4){
			result = "주말 아니고 평일";
		}else if(dayOfWeekValue==5) {
			result = "불금";
		}else if(dayOfWeekValue==6 || dayOfWeekValue==7){
			result = "주말";
		}else {
			result = "잘못된 값";
		}
		System.out.println(result);

		switch(dayOfWeekValue) {
		case 1:
		case 2:
		case 3:
		case 4:
			result="주말이 아니고 평일--";
			break;
		case 5:
			result="불금";
		case 6:
		case 7:
			result = "주말";
			break;
		default:
			result="모르는 요일";
		}
		System.out.println(result);


	}

}
