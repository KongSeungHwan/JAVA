package study18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResources {
	public static void main(String[] args) {
		Scanner s = null;
		Scanner s1 = null;
		String a = "D:\\workspace01\\javaStudy\\src\\study18\\input.txt"; //절대 경로
		String b = ".\\src\\study18\\input.txt";//상대 경로는 src 폴더까지 나와야 가능
		try { 
			s= new Scanner(new File(a));// 상대경로로 표기 이스케이프문 썼는데
			s1= new Scanner(new File(b));// 상대경로로 표기
					//Absolute Path/Relative Path
			System.out.print(s.next()+"\n"); //next만 쓰면 띄어쓰기 단위로 1단어로 출력되는 것 같다.
			System.out.println(s.nextLine());//Iterator next와 비슷하다고 보면 된다.(계속 쓰면 다음 원소로 넘어가듯 다음 라인으로 넘어감.)
			System.out.println(s1.nextLine());
			PrintWriter p =new PrintWriter(new File("D:\\workspace01\\javaStudy\\src\\study18\\output.txt"));
		}catch(FileNotFoundException e) {
			System.out.println("파일 없음!");
		}finally {
			if(s!=null) s.close();//파일이 없을 시 시스템 자원 반환
			if(s1!=null) s1.close();//파일이 없을 시 시스템 자원 반환
		}
		
	}

}
