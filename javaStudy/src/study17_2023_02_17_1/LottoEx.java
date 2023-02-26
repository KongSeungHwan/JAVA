package study17_2023_02_17_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class LottoEx {
	static BufferedReader n = new BufferedReader(new InputStreamReader(System.in));

	void lottoStart() throws NumberFormatException, IOException, InterruptedException{
		while(true) {
			lottoMenu();
		}
	}
	public void getLotto() throws NumberFormatException, IOException {
		System.out.println("낼 금액을 입력하십시오.");
		int price = Integer.parseInt(n.readLine());
		if(price<1000) {
			makeLotto(price);
		}
		else if(price>100000){

		}
	}
	public void lottoMenu() throws NumberFormatException, IOException, InterruptedException{
		System.out.println("로또 판매점");
		System.out.println("1입력 구매 / 2입력 종료");
		int token = Integer.parseInt(n.readLine());
		switch(token) {

		case 1:
			Thread.sleep(1000);
			getLotto();
			break;
		case 2:
			Thread.sleep(1000);
			System.out.println("프로그램 종료");//종료 출력문
			n.close();//시스템 자원 반환
			return;//그냥 프로그램 종료
		default:
			Thread.sleep(1000);
			System.out.println("유효한 값이 아닙니다. 다시 입력해주세요.");
		}
	}
	public void makeLotto(int price) {
		Random r = new Random();
		ArrayList<TreeSet<Integer>> lottoList = new ArrayList<>(); 
		TreeSet<Integer> lottoSet= new TreeSet<>();
		for(int i = 0;i<price/1000;i++) {//금액에 따라 로또 개수가 달라진다.
			while(lottoSet.size()<=6) {//set안에  6자리의 로또 번호 개별 기입
				lottoSet.add(r.nextInt()%46);
			}	//시간복잡도O(n^2)
		}
		for (TreeSet<Integer> a : lottoList){
			System.out.printf("사신 로또 번호:%s",a);
		}
	}


	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		new LottoEx().lottoStart();
	}
}
