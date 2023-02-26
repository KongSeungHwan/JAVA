package study19;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileInputOutputStreamRun{

	public static void main(String[] args)throws IOException {
		File f = new File("src\\study19\\files\\input.txt");
		OutputStream os1 = new FileOutputStream(f);
		byte[] a = "InputOutput practice".getBytes();
		os1.write(a);
		os1.write('\n');
		os1.write('3');
		os1.write('2');
		os1.write('4');
		os1.flush();
		os1.close(); //필수
		InputStream is = new FileInputStream(f);
		int data;
		while((data=is.read())!=-1) System.out.print((char)data+" "+is.available()+" ");//available <<남은 문자 갯수 리턴
		is.close();
		System.out.println();
		InputStream is2 = new FileInputStream(f);
		byte[] bar = new byte[23];
		int data2;
		while((data2=is2.read(bar))!=-1) {
			for(int i = 0; i < data2; i++) System.out.println((char)bar[i]);
			System.out.println(data2);
		}
		is2.close();
		byte[] bar2 = new byte[26];
		byte ch = 65;
		for (int i = 0; i < bar2.length; i++) bar2[i]=ch++;
		File f2 = new File("src\\study19\\files\\TestFileOut.txt");
		try (FileOutputStream fos = new FileOutputStream(f2)){
			fos.write(bar2);
		}catch(IOException e) {
			System.out.println("입출력 예외");
		}
		System.out.println("끝");
	}
}