package IOTest;

import java.io.File;
import java.util.Arrays;

public class FileDirTest {

	public static void main(String[] args) {
		String path="D:\\workspace01\\javaStudy\\src";
		File s = new File(path);
		File s2 = new File(path+"\\IOTest\\a.txt");
		System.out.printf("디렉터리 경로: %s\n",s.getAbsolutePath());
		System.out.println("해당 경로에 있는 디렉터리들:");
		Arrays.stream(s.list()).forEach(System.out::println);//얘는 확장자 없으니까 필요x 스트림 연산 응용!
		System.out.printf("파일 경로: %s\n",s2.getAbsolutePath());
		System.out.printf("파일 이름(확장자 미포함):");
		System.out.println(s2.getName().substring(0, s2.getName().indexOf(".")));//확장자 빼기
	}
}
