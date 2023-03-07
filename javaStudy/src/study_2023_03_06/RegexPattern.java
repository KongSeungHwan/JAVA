package study_2023_03_06;

import java.util.regex.Pattern;

public class RegexPattern {

	public static void main(String[] args) {
		String patternString = "^[0-9]*";
		Pattern pa = Pattern.compile(patternString);
		//샘플 문자열
		String txt1 ="123123234";
		String txt2 ="123숫자00";
		boolean result = Pattern.matches("^[0-9]*$", txt1);
		boolean result2 = Pattern.matches(patternString, txt2);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(pa.pattern());
		
		Pattern p2 = Pattern.compile(",");
		for (String s : p2.split("12,31,41")){
			System.out.println(s);
		}
		Pattern p3 = Pattern.compile(",[0-9]{2,},");
		for (String s : p3.split("12,31,41,41,55")) System.out.println(s);
		System.out.println(p2.asPredicate().test("12,33"));
		
	}

}
