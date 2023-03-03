package MineSweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MineSweeper {
	List<List<Integer>> mineMatrix;
	List<List<String>> currentMatrix; 
	List<List<Integer>> selectMatrix;
	Client user;
	BufferedReader n;
	//원래 그냥 처음부터 String으로 통일해도 되지만 배운내용인 제네릭 메소드를 사용하는 것을 보여주기 위해 Integer,String 번갈아 가면서 사용!
	int normalNumber = 0;
	int mineNumber = 0;
	MineSweeper(Client client){
		int num;
		user = client;
		n = new BufferedReader(new InputStreamReader(System.in));
		if(user.getGrade().equals("UnrankedPlayer")) num=5;
		else if(user.getGrade().equals("BeginnerPlayer")) num=7;
		else if(user.getGrade().equals("AdvancedPlayer")) num=10;
		else if(user.getGrade().equals("MasterPlayer")) num=15;
		else {num =-1;}
		try {
			mineMatrix=createMatrix(num);
			selectMatrix=createSelectMatrix(num);
			currentMatrix=createDefaultMatrix(num);
			mineCount();
		}catch(IndexOutOfBoundsException e) {
			System.out.println("정상적인 등급이 아닙니다 운영자에게 문의하십시오.");
		}
	} //판 생성
	void startGame(){
		try {Thread.sleep(1000);} catch(InterruptedException e){}
		try {Thread.sleep(1000);} catch(InterruptedException e){}
		clear();
		System.out.print(String.format("3"));
		clear();
		System.out.print(String.format("2"));
		clear();
		System.out.print(String.format("1"));
		clear();
		try {
			while(true) {
				if(normalNumber==0) {
					System.out.println("Victory!");
					new DAO().updateGameDataSQL(true,user);
					break;
				}
				matrixView(mineMatrix);
				matrixView(currentMatrix);
				System.out.printf("남은 지뢰 개수: %d",mineNumber);
				System.out.println("좌표 입력 순서쌍(x,y) \n 입력값 예시 ex) 1,2 0,1... ");
				if(!selectSerface(n.readLine())){
					matrixView(mineMatrix);
					break;
				}
				clear();
				currectMatrixOperation();
			}
		} catch (NumberFormatException | IOException e){
			System.out.println("잘못된 값을 입력하셨습니다.");
		}
	}





	List<List<Integer>> createMatrix(int num){
		return IntStream.rangeClosed(1, num)
				.boxed()
				.map(s-> new Random()
						.ints(1,100000)
						.limit(num)
						.boxed()
						.map(u-> (u>=70000)? 2 : 1)
						.collect(Collectors.toList())).collect(Collectors.toList());
	} 
	//반드시 짝수여야하는 조건..(최소 1개라도 나올 수 있게 하려면)
	//1이 일반땅, 2가 폭탄 땅을 의미한다.(70% 확률로 일반땅, 30%확률로 폭탄땅이 나온다.)
	// 50% 확률로 최소 1,2 2,1 로 시작하게 설정 concat 활용 





	boolean selectSerface(String pair){
		int x =Integer.parseInt(pair.split(",")[0]) ,y = Integer.parseInt(pair.split(",")[1]);
		if(selectMatrix.get(y).get(x)==1) {
			System.out.println("이미 선택한 땅입니다.");
			return true; //이미 통과한 땅이라 true 반환
		}
		else if(selectMatrix.get(y).get(x)==0){
			List<Integer> modilist = selectMatrix.get(y);
			if(mineMatrix.get(y).get(x)==1) normalNumber--;
			modilist.set(x, 1);
			selectMatrix.set(y,modilist);
			if(mineMatrix.get(y).get(x)==1) {
				System.out.println("일반 땅!");
				chainOpen(x,y);
				return true;
			}else if(mineMatrix.get(y).get(x)==2){
				System.out.println("Defeat");
				new DAO().updateGameDataSQL(false,user);
				return false;
			}else {
				System.out.println("프로그램 문제 발생! 자료구조에 유효하지 않은 값이 저장되었습니다.");
				return false;
			}
		}
		else {
			System.out.println("프로그램 문제 발생! 자료구조에 유효하지 않은 값이 저장되었습니다.");
			return false;
		}
	}//좌표 값 선택 시 지정 여부를 selectMatrix에 저장하는 형태의 메소드







	List<List<Integer>> createSelectMatrix(int num){
		return IntStream.rangeClosed(1, num)
				.boxed()
				.map(s-> IntStream.generate(()->0)
						.boxed()
						.limit(num)
						.collect(Collectors.toList())).collect(Collectors.toList());
	}
	List<List<String>> createDefaultMatrix(int num){
		return IntStream.rangeClosed(1, num)
				.boxed()
				.map(s-> Stream
						.generate(()->"*")
						.limit(num)
						.collect(Collectors.toList())).collect(Collectors.toList());
	}

	<T> void matrixView(List<List<T>> list){
		list.stream().forEach(s-> System.out.println(s.stream().map(String::valueOf).collect(Collectors.joining(" "))));
		System.out.println();
	}//제네릭 메소드(원소가 Integer든 String이든 Matrix형식으로 조회 가능)

	
	final void chainOpen(int x,int y) { //템플릿 메소드 폭탄 땅이 있을 시까지 열리는 메소드
		selectChainrow(x,y);
		selectChaincol(x,y);
		selectChainrowpl(x,y);
		selectChaincolpl(x,y);
	}

	void selectChainrow(int x, int y){
		if((selectMatrix.get(y).get(x)==0)&&(mineMatrix.get(y).get(x)==1)){
			List<Integer> modilist = selectMatrix.get(y);
			modilist.set(x, 1);
			selectMatrix.set(y, modilist);
			normalNumber--;
		}
		if(mineMatrix.get(y).get(x)==1) {
			if(x >0) selectChainrow(x-1,y);
		}
		
	}
	void selectChaincol(int x, int y){
		if((selectMatrix.get(y).get(x)==0)&&(mineMatrix.get(y).get(x)==1)){
			List<Integer> modilist = selectMatrix.get(y);
			modilist.set(x, 1);
			selectMatrix.set(y, modilist);
			normalNumber--;
		}
		if(mineMatrix.get(y).get(x)==1){
			if(y >0) selectChaincol(x,y-1);
		}	
		
	}
	void selectChainrowpl(int x, int y){
		if((selectMatrix.get(y).get(x)==0)&&(mineMatrix.get(y).get(x)==1)){
			List<Integer> modilist = selectMatrix.get(y);
			modilist.set(x, 1);
			selectMatrix.set(y, modilist);
			normalNumber--;
		}
		if(mineMatrix.get(y).get(x)==1){
			if(x <mineMatrix.size()-1)selectChainrowpl(x+1,y);
		}
	}
	void selectChaincolpl(int x, int y){
		if((selectMatrix.get(y).get(x)==0)&&(mineMatrix.get(y).get(x)==1)){
			List<Integer> modilist = selectMatrix.get(y);
			modilist.set(x, 1);
			selectMatrix.set(y, modilist);
			normalNumber--;
		}
		if(mineMatrix.get(y).get(x)==1){
			if(y <mineMatrix.get(0).size()-1)selectChaincolpl(x,y+1);
		}
	}

	
	void currectMatrixOperation(){
		List<String> modilist = null;
		for (int i = 0; i < selectMatrix.size(); i++) {
			for (int j = 0; j < selectMatrix.get(i).size(); j++){
				modilist = currentMatrix.get(j);
				if(selectMatrix.get(j).get(i)==0){
					modilist.set(i, "*");
					currentMatrix.set(j, modilist);
				}else if(selectMatrix.get(j).get(i)==1){
					modilist.set(i, mineMatrix.get(j).get(i)+""); //+문자열 붙여서 바로 형변환
					currentMatrix.set(j, modilist);
				}else{}
			}
		}
	} //얘는 어쩔 수 없이 for문 써야함, 본래 3중 자료구조 사용할랬는데 시도하면 힙 영역 부족하다고 뜨고 Out Of Memory 에러가 뜬다.
	void mineCount(){
		mineMatrix.stream().forEach(s-> s.stream().forEach(p->{
			if(p==1)normalNumber++;
			if(p==2)mineNumber++;
		}));
	}//일반 땅, 폭탄 땅을 카운트 하는 메소드(게임 종료시의 변수로 사용)
	void clear() {
		try {Thread.sleep(1000);} catch(InterruptedException e){}
		for (int i = 0; i < 14; i++)System.out.println();
	} 
}