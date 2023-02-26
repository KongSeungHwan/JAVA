package study05;
public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int lotto[] = new int[6];	// 로또 번호를 입력받을 배열을 선언해준다.
		
		System.out.print("로또 번호 : ");
		for(int i = 0; i < lotto.length; i++) {
			int num = (int)(Math.random() * 45) + 1;	// 1~46까지의 임의의 수를 받는다.
			lotto[i] = num;
			for(int j = 0; j < i; j++) {	// 중복된 번호가 있으면 이전 포문으로 돌아가 다시 시행한다.
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
			System.out.print(lotto[i]);	// 로또번호를 출력한다.
			if(i!=lotto.length) {
				System.out.print(" ");
			}else {
				System.out.print("");
			}//추가로 공백 없애기(마지막 요소만 공백빼기)
			//routine
			//1.random함수로 임의의 num값 초기화, 2.lotto 배열에 집어넣음
			//3.lotto배열의 인덱스0~i 인 요소들을 전부 비교하여 같은 값이 나타나면
			//i를 1빼고 반복문을 나가 다시 탐색(j가 포함된 for문 다시 실행)
			//시간 복잡도 O(n^2)인 프로그램
		}
	}
}
