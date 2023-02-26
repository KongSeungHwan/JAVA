package study03;

public class WrapperClassRun {
	public static void main(String[] args) {
		int a = 10;
		Integer num = 10; //오토 박싱(boxing) int의 Wrapper Class(기본형을 객체로 사용하기 위한 클래스)
		int n = num; //오토 언박싱
		n= num.intValue();//수동 언박싱
		String str1 = "100";
		String str2 = "3.14";
		String str3 ="false";
		byte b =Byte.parseByte(str1);
		System.out.println(b);
		int i = Integer.parseInt(str1);
		System.out.println(i);
		short s = Short.parseShort(str1);
		long l =Long.parseLong(str1);
		System.out.println(l);
		float f =Float.parseFloat(str2);
		System.out.println(f);
		double d = Double.parseDouble(str2);
		System.out.println(d);
		boolean bool = Boolean.parseBoolean(str3);
		System.out.println(bool);
		// 문자열을 바로 기본형으로 바꿀때 파싱을 한다.
		
		
		

//BufferedReader 출력때 String를 제외하고 다른 기본형을 파싱해주는 이유가 
//readLine()메소드는 문자형으로 반환하기 때문이다.
		
	}
}
