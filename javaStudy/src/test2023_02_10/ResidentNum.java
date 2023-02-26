package test2023_02_10;

public class ResidentNum {

	public static void main(String[] args) {
		String str = "871130-1464217", birthYear ="",birthMonth = "",birthDay="",gender=""; //주민등록번호를 기반으로 성별과 생일 구하기
		//년도 2자리, 월 2자리, 일 2자리, 성별 (1,2) , 지역변호 등등...
		//charAt으로 index 값을 찾아 추출하는 방법도 있지만
		//문자열 자체를 잘라서 하는 방법도 있다.(subString)
		//다른 방법 넘침
				birthYear+=str.charAt(0);
				birthYear+=str.charAt(1);
				birthMonth+=str.charAt(2);
				birthMonth+=str.charAt(3);
				birthDay+=str.charAt(4);
				birthDay+=str.charAt(5);
				gender+=str.charAt(7); //어차피 주민번호는 고정자리기때문에 이래도 상관 없음
		if(gender.equals("1")) {
			gender="남";
		}else if(gender.equals("2")){
			gender="여";
		}
		System.out.printf("생일 %s년 %s월 %s일 성별: %s",birthYear,birthMonth,birthDay,gender); //문자열 이니까! 서식문자 %s 사용
		
		//subString 방법도 있다!
	}

}
