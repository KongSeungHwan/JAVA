package study20;

import java.io.*;
import java.util.Arrays;

public class InputOutputStreamReaderWriterRun {

	public static void main(String[] args) throws IOException {
		File f = new File("src/study20/files/FileReadWriter.txt");
		OutputStream os = new FileOutputStream(f,false);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		osw.write("aaa".toCharArray());
		osw.write("asdasfd");
		osw.flush();
		osw.close();
		os.close();
		
		InputStream is = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(is);
		int a=0;
		char[] buf = new char[1024];//복습
		while((a=isr.read(buf))!=-1) {
			System.out.println(Arrays.toString(buf));
		}
		//***대입 연산자는 보통 왼쪽 피연산자를 리턴하는 형태이다.(안 까봐서 몰랐음)
		//결국에는 입력 값의 가장 끝 지점에 도달한 다음 값이 -1로 초기화 된다는 것을 알 수 있다.
		isr.close();
		is.close();
		
		OutputStreamWriter osw2 = new OutputStreamWriter(System.out);
		//반대로 reader는 system.in인자를 넣으면 입력
		osw2.write("콘솔 출력");
		osw2.flush();
		osw2.close();
		
	}

}
