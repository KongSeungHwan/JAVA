package study19;


import java.io.*;

public class PrintStreamWriterRun {

	public static void main(String[] args) {
		File psf = new File("src/study20/files/PrintStream.txt");
		File pwf = new File("src/study20/files/PrintWriter.txt");
		
		try(	PrintWriter ps = new PrintWriter(pwf);//생성된 파일 부분 
				OutputStream os = new FileOutputStream(pwf);
				PrintStream pw2 = new PrintStream(os);
				PrintStream pw3 = new PrintStream(System.out);//콘솔 측 객체?
				
				){
			ps.println(10.9);
			ps.print(String.format("%s 년 %s 개월 \n",10,9));
			//==System.out.print(String...); 
			ps.printf("%s","우리나라");
			ps.println();
//			ps2.println(10.9);
//			ps2.print(String.format("%s 년 %s 개월 \n",10,9));
//			ps2.printf("%s","우리나라");
//			ps2.println();
			pw3.println(10.9);
			pw3.print(String.format("%s 년 %s 개월 \n",10,9));
			pw3.printf("%s","우리나라");
			pw3.println();
		}catch(IOException e) {
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
