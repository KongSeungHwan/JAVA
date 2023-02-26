package IOTest;

import java.io.*;

public class CopyRun {
	public static void main(String[] args) {
		try( 	FileOutputStream o = new FileOutputStream("src/IOTest/ab.txt",false);
				FileInputStream i = new FileInputStream("src/IOTest/a.txt");
				InputStreamReader isr = new InputStreamReader(i);
				OutputStreamWriter osr = new OutputStreamWriter(o);
				) {
			//직접 해보니까 복사할 파일 생성은 기능을 다르게 해야 가능할 것 같다... 
			// 파일생성 기능,파일 복사 기능 따로
			int a;while((a=isr.read())!=-1) osr.write(/*(char)*/a); //int >> String   1.new String(int) 2.valueOf(int) 
																	//String >> int    Integer.parseInt(String)
			//대입 연산자는 왼쪽 피연산자를 리턴하기에 그 점을 이용하여 파일의 가장 끝에 도착하게 된다면 다음 원소로는 -1을 리턴 그때 while 탈출
			//방법 2
		}catch(FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}catch(IOException e) {
			System.out.println("입출력 예외 발생!");
		}catch(Exception e) {
			System.out.println("예외 발생!");
		}//제일 최상위 예외 클래스인 Exception은 마지막에 catch 해놓는 것이 좋다.(완벽히 하기 위해)
	}
}
