package study20;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerRun {

	public static void main(String[] args) {
		File target = new File("src/study20/files/printWriter.txt");
		try(Scanner sc = new Scanner(target);){
			while(sc.hasNextLine()) System.out.println(sc.nextLine());
			//줄단위로 있는지 없는지 boolean 값으로 따지면서 출력
		}catch(FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}//컴퓨터애 존재하는 파일을 Scanner 객체로 읽어오는 프로그램
	}

}
