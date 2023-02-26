package IOTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileClassRun {

	public static void main(String[] args) {
		try(BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
				){
			System.out.println("디렉터리명 입력:");
			String directory = n.readLine();
			if(!(new File("./src/IOTest/"+directory).exists())) new File("./src/IOTest/"+directory).mkdir();
			System.out.println("파일명 입력:");
			String filestr1 = n.readLine();
			System.out.println("확장자명 입력:");
			String filestr2 = n.readLine();
			if(!(new File("src/IOTest/"+directory+"/"+filestr1+"."+filestr2).exists()))new File("src/IOTest/"+directory+"/"+filestr1+"."+filestr2).createNewFile();
		}catch(IOException e) {
			System.out.println("입출력 예외 발생");
		}

	}

}
