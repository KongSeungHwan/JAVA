package study23;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegularExpressionRun {

	public static void main(String[] args) throws IOException {
		Stream<String> st = Pattern.compile(",").splitAsStream("1,2,3,4");

		st.filter(s -> Integer.parseInt(s)>2).forEach(System.out::println);
		//문자열 중에 2 초과 수만 출력 3,4만 출력
		System.out.println(System.getProperty("user.dir"));
		if(!new File("src/study23/i.txt").exists())new File("src/study23/i.txt").createNewFile(); 
		//파일 없으면 만들기
		Stream<String> f = Files.lines(Paths.get("src/study23/i.txt"),Charset.forName("UTF-8"));
		f.forEach(System.out::println);
		ArrayList<String> l = new ArrayList<>();
		Stream<String> s=(l.size()==0)?Stream.empty():l.stream();
		//Uno 스페인어 하나라는 의미
		Stream<Integer> i = Stream.iterate(10,n->n+2).limit(5);
		i.forEach(System.out::println);//10 12 14 16 18
		
		
	
		
	}
}
