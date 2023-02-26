package study05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CharCheck {

	public static void main(String[] args) throws IOException {
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		String in = n.readLine();
		//걍 IOException throw 해버림(입출력 예외 <<자료형이 다른 잘못된 값 입력시)
		int con=0, vow = 0;
		
		String check = in.toLowerCase();
		for (int i = 0; i < in.length(); i++){
			char c = in.charAt(i);
			if(c>='a'&&c<='z') {
				
			}
				//예외처리, 아스키코드 활용(대문자65~,  소문자97~)
			if(c == 'a'||c=='e'||c =='i'||c=='o'||c=='u') {
				vow++;
			}else {
				con++;
			}
			//char는 참조형이 아니라 기본형이기 때문에 equals 안써도 비교된다.
			//String 만 값을 비교시에 equals 함수사용(참조형이기 때문에!)
		}
		System.out.printf("자음개수: %d, 모음개수:%d \n",con,vow);
	}

}
