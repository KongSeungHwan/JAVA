package study03;

import java.util.ArrayList;

public class Array {
	public static void main(String[] args){
		//class
		ArrayList<Integer> a = new ArrayList<Integer>(/*배열 크기*/);
		//배열크기 부분은 Scanner나 BufferedReader로 가변적으로 사용가능
		ArrayList<Integer> b = new ArrayList<>(/*배열 크기*/);
		//두번째 부터는 생략가능
		//선형 자료구조   <E>안의 값은 배열 요소의 타입을 정의
		ArrayList<Integer> c = new ArrayList<>(10);

		ArrayList<String> strList = new ArrayList<>(/*배열 크기*/);
		strList.add("안녕하세요");
		strList.add("안녕");
		strList.add("잘 가세요");
		System.out.println(strList);
		System.out.println(strList.size());
		System.out.println(c.size());
		strList.add(1,"종호"); 
		//인덱스가 1이므로 2번째에 해당 "종호"문자열이 추가된다.
		//삽입insert
		System.out.println(strList);
		strList.set(2,"아름");
		//3번째 요소가 "아름" 문자열로 바뀌게 된다.
		System.out.println(strList);
		strList.remove("종호");//해당 값을 가진 요소를 삭제한다.
		System.out.println(strList);
		strList.remove(2);//0,1,2 3번째 요소를 삭제한다.
		System.out.println(strList);
		strList.clear();//배열안의 요소들이 모두 삭제된다.
		System.out.println(strList);

		strList.add("이재민");
		strList.add("박만수");
		strList.add("강민정");
		strList.add("공승환");//4개 넣어가지고 배열 길이가 4 인덱스는 3까지
		System.out.println(strList);
		System.out.println();
		System.out.println("기본 for문");
		for (int i = 0; i < strList.size(); i++) {
			if((i!= strList.size()-1)&&(i!=0)) {
				System.out.printf("학생 이름:%s, ", strList.get(i));
			}else if(i==0){
				System.out.printf("[학생 이름:%s, ", strList.get(i));
			}
			else{
				System.out.printf("학생 이름:%s]", strList.get(i));
			}
		}//for문을 이용하여 배열 요소 출력
		System.out.println();
		System.out.println("향상된 for문");
		int i = 0;
		for (String string : strList){
			if(i==strList.size()-1) {
				System.out.printf("학생 이름:%s]",string);
			}else if(i==0) {
				System.out.printf("[학생 이름:%s",string);
			}
			else {
				System.out.printf("학생 이름:%s, ",string);
			}
			i++;
		}
		//향상된 for문을 이용하여 배열 요소 출력
		//4번 돈다

		//검색함수 contains(일부검색 여부), equals(자체가 요소 값과 일치하는지 여부)함수 >> Object클래스 메소드
		System.out.println(strList.contains("박만수"));
		System.out.println(strList.indexOf("박만수"));
		System.out.println(strList.indexOf("김준현"));


		//검색 시에 Iterater로 돌린다음에 if로 (indexOf)||(indexOf) or연산하여 걸러내면 간단(검색어가 2가지 이상일 시)




		//복사
		//clone()
		ArrayList<String> newStr1 = (ArrayList<String>)strList.clone(); //강제 캐스팅
		//리턴 값이 최상위 클래스인 Object 클래스이므로 초기화 불가능 ArrayList로 초기화 불가능 
		//아마 clone() 코드 설계자가 어떤것이 복사될지 미지수이기에 Object 객체로 리턴한것 같다.
		printArrayList(newStr1);
		//addAll
		ArrayList<String> newstr2 = new ArrayList<>();
		newstr2.addAll(strList);
		System.out.println();
		printArrayList(newstr2);
		//for
		ArrayList<String> newStr3 = new ArrayList<>();
		for (String str : strList) {
			newStr3.add(str);
		}
		printArrayList(newStr3);
		
		//
		System.out.println(newStr3.isEmpty());//return boolean
		newStr3.clear();
		System.out.println(newStr3.isEmpty());

	}//메인 메모리는 static이기에 static 메모리에 이미 올라가있어서 메인메소드에 적용시키려면 똑같이 static 메소드로 해야 메인메소드에서 작동한다.
	//만일 일반 메소드로 하면 이미 메모리에 올라가있는 메인메소드에서 작동하지 못한다.
	static void printArrayList(ArrayList<String> arr){
		for (String str : arr) {
			System.out.printf("%s \n",str);
		}
	}
}

