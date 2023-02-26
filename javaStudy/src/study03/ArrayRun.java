package study03;

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 */
public class ArrayRun {
	public static void main(String[] args) /*throws NumberFormatException, IOException*/ {
		/*BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("배열의 길이를 입력하시오.");
		int k = Integer.parseInt(n.readLine());*/
		Subject a[]= new Subject[10];
		//for(int i=0;i<10;i++) {a[i]=new Subject();}
		int[] num =new int[10];
		int[] num2 = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(num.length);
		System.out.println(num2.length);
		System.out.println(num2[3]+" "+num[3]);
		num[1]=11;
		System.out.println(num[1]+" "+num[0]);

		for (int i = 0; i < num.length; i++) {
			System.out.println(num2[i]+" ");
		}//  앞에서 배열을 선언하면 for Ctrl+space 누르면 자동 완성 기능이 생김
		System.out.println();
		for (int i : num2) {
			System.out.println(i+" ");
		}
		String[] str =new String[5];
		System.out.println(str[2]);
		boolean[] bool = new boolean[5];
		System.out.println(bool[3]);
		double[] dd = new double[5];
		System.out.println(dd[3]);//임의의 요소 출력
		char[] alphabet = new char[26];
		System.out.println(alphabet[3]);
		//문자 배열은 toString()(Object클래스의 메소드)이라는 메소드를 통해 문자열로 바꾸기 가능
		char ch ='A';//int로 캐스팅을하면? 65 ASCII Code
		System.out.println(ch);
		ch = 66;//char로 캐스팅하면 B ASCII Code
		System.out.println(ch);
		int k ='A';
		ch='A';
		System.out.println(ch+" "+k);
		for (int i = 0; i < alphabet.length; i++,ch++){
			alphabet[i]=ch;
		}
		for (int i = 0; i < alphabet.length; i++) {
			if(i==alphabet.length-1){
				System.out.printf("%s",alphabet[i]);
				System.out.println();
				System.out.println("끝");
			}else {
				System.out.printf("%s ",alphabet[i]);
			}
		}
		for (char c : alphabet) {
			System.out.printf("%s ",c);
		}//이건 인덱스가 없음
		System.out.println();
		System.out.println("끝");
	}

	//보통 선언하고 초기화 하지 않으면 쓰레기값이 들어가게 되어 null이 된다. c언어떄 배운 내용..
	//컴퓨터가 인식하지 못하는 값 또한 null로 찍힘.
}
