package study04;

import java.util.Calendar;

public class CalendarRun {

	public static void main(String[] args) {
		// 싱글톤 패턴(디자인 패턴)GOF: 객체를 static으로 단일 생성만 하고 여러 영역에서 공유하는 객체로 만드는 것.
		// Calendar가 싱글톤 패턴을 예시로 들기 가능..
		Calendar cal = Calendar.getInstance();
		/*
		 * * Calendar 클래스의 주요 상수

상수

사용방법

설명 

static int YEAR

Calendar.YEAR 

 현재 년도를 가져온다.

static int MONTH 

Calendar.MONTH 

 현재 월을 가져온다. (1월은 0) 

static int DATE 

Calendar.DATE 

 현재 월의 날짜를 가져온다. 

static int WEEK_OF_YEAR 

Calendar.WEEK_OF_YEAR

 현재 년도의 몇째 주

static int WEEK_OF_MONTH 

Calendar.WEEK_OF_MONTH 

 현재 월의 몇째 주 

static int DAY_OF_YEAR 

Calendar.DAY_OF_YEAR 

 현재 년도의 날짜 
static int DAY_OF_MONTH

Calendar.DAY_OF_MONTH 

 현재 월의 날짜 (DATE와 동일) 

static int DAY_OF_WEEK 

Calendar.DAY_OF_WEEK 

 현재 요일 (일요일은 1, 토요일은 7)

static int HOUR 

Calendar.HOUR 

 현재 시간 (12시간제)
static int HOUR_OF_DAY

Calendar.HOUR_OF_DAY 

 현재 시간 (24시간제) 
static int MINUTE 

Calendar.MINUTE 

 현재 분

static int SECOND 

Calendar.SECOND 

 현재 초 
		 * 
		 * */

 //Calendar 안의 final로 선언된 상수들  설계자가 요일이나 년도를 인덱스화 시켜버림 ex)DAY,YEAR 등 상수들은 1을 뺀 수로 나옴
	}

}
