package study19;

import java.io.*;

public class BufferedTimeTestRun {

	public static void main(String[] args) {
		File f = new File("src\\study19\\files\\bear.jpg");
		File copyFile1 = new File("src\\study19\\files\\bear(1).jpg");
		File copyFile2 = new File("src\\study19\\files\\bear(2).jpg");
		
		long t1,t2;
		t1=System.nanoTime();
		try( 	FileInputStream i = new FileInputStream(f);
				FileOutputStream o = new FileOutputStream(copyFile1);){
			int dat;
			while((dat=i.read())!=-1) {
				o.write(dat);
			}
		}catch(FileNotFoundException e) {
			
		}catch(IOException e) {
			t1+=-1*(System.nanoTime());
			System.out.println("버퍼 사용 실행1:"+t1);
		}catch(Exception e) {
			
		}
		t2=System.nanoTime();
		try( 	FileInputStream i = new FileInputStream(f);
				FileOutputStream o = new FileOutputStream(copyFile2);
				BufferedInputStream bi = new BufferedInputStream(i);
				BufferedOutputStream bo = new BufferedOutputStream(o);){
			int dat;
			while((dat=i.read())!=-1) {
				bo.write(dat);
			}
		}catch(FileNotFoundException e){
			
		}catch(IOException e) {
			t2+=-1*(System.nanoTime());
			System.out.println("버퍼 사용 실행2:"+t2);
		}catch(Exception e) {
			
		}
		System.out.println(t1/t2);
	}

}
