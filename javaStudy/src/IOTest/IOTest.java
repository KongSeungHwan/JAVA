package IOTest;

import java.io.*;

public class IOTest {

	public static void main(String[] args) {
		try(	BufferedReader n = new BufferedReader(new InputStreamReader(System.in));//Scanner 대체
				FileOutputStream f = new FileOutputStream("src/IOTest/a.txt",false);
				OutputStreamWriter i = new OutputStreamWriter(f);
				) {
			System.out.println("파일에 입력할 값을 입력!:");
			i.write(n.readLine());
	}catch(FileNotFoundException e) {
		System.out.println("파일을 찾을 수 없습니다.");
	}catch(IOException e) {
		System.out.println("입출력 예외 발생!");
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
}
