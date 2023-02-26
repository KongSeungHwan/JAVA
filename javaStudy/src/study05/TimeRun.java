package study05;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

import javaStudy.Sysout;

public class TimeRun {

	public static void main(String[] args) {
		//java.time 패키지에 있는 클래스
		//LocalDate(날짜), LocalTime(시간), LocalDateTime(모두)
		//ZonedDateTime
		//차이 Period(날짜), Duration(시간)
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime zoneDateTime = ZonedDateTime.now();
		date = LocalDate.of(2022, 8, 4);
		//now()의 디폴트 값은 현재시간이고 of 함수로 출력값을 달리 가능time = LocalTime.of(12, 11, 30);
		// of는 오버로딩함 즉 메소드는 두 형태가 존재(매개변수 타입으로 구분)
		zoneDateTime = ZonedDateTime.of(dateTime, ZoneId.of("America/New_York"));
		dateTime = LocalDateTime.of(date, time);
		System.out.println(date);
		System.out.println(time);
		System.out.println(dateTime);
		// 초 단위가 소수점 아래 숫자가 엄청 많음
		System.out.println(zoneDateTime);
		// 현재 위치까지 출력해줌 뒤에 나오는 숫자는 
		//날짜에 대한 일련번호(실수로 일련번호 관리)
		//생성 안해도 됨.
		System.out.println();
		System.out.printf("%d년, %d월 %d일에서 현재까지 며칠 지났나?: %d일",date.getYear(),date.getMonthValue(),date.getDayOfWeek().getValue(),date.getDayOfYear());
		//dayOfYear는 설정 날짜부터 일수를 세보고 출력하는 메소드
		//즉, 2022.8.4부터 현재까지 날짜를 세본 것을 리턴(int)
		//getDayOfWeek는 LocalDate 객체를 리턴하므로 해당 메소드를 이용하여
		//며칠인지 나타내는 getValue 메소드를 씀
		//+)lengthOfMonth(),lengthOfYear는 달의 총일수, 년의 총일수를 즉, int값을 리턴하는 함수
		// isLeapYear는 윤년인가 아닌가의 여부를 boolean값으로 리턴하는 메소드
		System.out.println(time.getHour());
		System.out.println(time.getMinute());
		System.out.println(time.getSecond());
		System.out.println(time.getNano());
		//각각 시간,분,초, 나노초 단위로 표기된다.
		//초를 기준으로 보면
		//nano Second는 10억분의 1초를 단위로 나타냄
		System.out.println(date.withYear(2002));
		System.out.println(date.withMonth(12));
		System.out.println(date.withDayOfMonth(25));
		System.out.println(date.withDayOfYear(120));
		System.out.println(date);
		System.out.println(time.withHour(1));
		System.out.println(time.withMinute(26));
		System.out.println(time.withSecond(30));
		System.out.println(time.withNano(1234));
		//with뒤에 있는 내용을 변경해서 LocalDate객체 리턴하는 메소드들
		System.out.println(time);
		LocalDate date2 = date.withYear(2002);
		System.out.println(date2);

		//날짜 계산
		System.out.println(date2.plusYears(20));
		System.out.println(date2.plusWeeks(1));
		System.out.println(date2.plusMonths(5));
		System.out.println(date2.plusDays(0));
		System.out.println(date2.minusYears(2));
		System.out.println(date2.minusWeeks(1));
		System.out.println(date2.minusMonths(2));
		System.out.println(date2.minusDays(7));
		//더하거나 뺀 년월일을 계산한 뒤에 LocalDate 객체를 리턴하는 메소드들

		LocalTime time2 = LocalTime.now();
		String sAmPm;
		if(time2.get(ChronoField.AMPM_OF_DAY)==0){
			sAmPm ="오전";
		}else {
			sAmPm ="오후";
		}
		System.out.printf("지금 %s %d시/ %d \n",sAmPm,time2.getHour(),time2.get(ChronoField.HOUR_OF_AMPM));
		//크로노 필드는 열거체(Enum >>Iteator 객체로 출력해야 함 while문을 이용해서 next()함수로)
		//크로노 필드로 출력하면 1 OR 0으로 나오는데 여기선 1,0을 true/false 취급 안해주네(c언어 한정)
		//DB도 열거체로 받아서 출력하게 됨.(객체 단위로)
		System.out.printf("%d년 %d월 %d일 ver.ChronoField \n",dateTime.get(ChronoField.YEAR),dateTime.get(ChronoField.MONTH_OF_YEAR),dateTime.get(ChronoField.DAY_OF_MONTH));
		//크로노필드 상수 중에서  day_of_week,ampm_of_day,hour_of_day,hour_of_ampm도 있음
		//각각 요일,오전/오후(1,0),(0-23시),(1~24시),(0~11시) 등 있다.라이브러리/패키지 찾아보자
		//https://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoField.html

		LocalDate date3 = LocalDate.of(2015,6,15);
		LocalDate date4 = LocalDate.of(2015,5,15);
		//해당 년 월일을 파라미터로 받아 해당 객체의 필드에 입력 후 
		//나중에 리턴하는 형태
		LocalTime time3 = LocalTime.of(15, 30,25);
		LocalDateTime dateTime1 = LocalDateTime.of(2015,6,15,15,30,30);
		LocalDateTime dateTime2 = LocalDateTime.of(2015,6,15,15,30,30);
		System.out.println(dateTime2);
		LocalDateTime dateTime3 = date3.atTime(time3);
		//+)
		//isAfter a.isAfter(b) a시간이 b 시간보다 이후 시간인지 여부 boolean 리턴
		//isBefore a.isBefore(b) a시간이 b 시간보다 이전 시간인지 여부 boolean 리턴
		//isEqual a.isEqual(b) a시간이 b 시간과 같은 시간인지 여부 boolean 리턴

		//TemporalAdjusters 필요한 계산
		LocalDate dt = LocalDate.now();
		LocalDate nextYear = dt.with(TemporalAdjusters.firstDayOfNextYear());
		LocalDate nextMon = dt.with(TemporalAdjusters.firstDayOfNextMonth());
		System.out.printf("다음 년도는 %d년 %d월 \n",nextYear.getDayOfYear(),nextMon.getDayOfMonth());
		//TemporalAdjusters클래스는 자주쓰일만한 요일과 날짜를 알려주는 클래스
		
	}
}
