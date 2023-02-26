package study19;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileClassRun {

	public static void main(String[] args) throws IOException {
		String path ="D:\\workspace01\\javaStudy\\src\\study19\\files";//Absolute Path
		File f = new File(path);
		if(!f.exists()) f.mkdir();
		System.out.println(f.exists());
		File file = new File(path+"\\TestFile.txt");
		if(!file.exists()) file.createNewFile();
		//파일 생성 시 작업(존재 여부를 확인 후 파일 생성)
		System.out.println(file.exists());
		System.out.println(file.getCanonicalPath());
		System.out.println(System.getProperty("user.dir"));
		File f1 = new File("src/study17/files");
		System.out.println(f1.getName());
		System.out.println(f1.isFile());
		System.out.println(f1.isDirectory());
		System.out.println(f1.getParent());
		File f2 = new File(path+"");
		System.out.println(f2.mkdir());
		File[] files = f2.listFiles();
		for (File file2 : files) System.out.println(file2.getName()+" "+(file2.isFile()?"파일":"디렉터리"));
		//A to Z 65~90(대문자) 97~122(소문자) euc-kr 영어를 제외한 문자셋
		//utf-8 iso 10046에서 정의한 문자셋?
		Charset cs = Charset.forName("UTF-8");
		Charset cs2 = Charset.defaultCharset();
		System.out.println(cs2);
		System.out.println(Charset.isSupported("MS949"));
		byte[] arr1 = "한명".getBytes();
		byte[] arr2 = "두명".getBytes();
		byte[] arr3 = "세명".getBytes();
		byte[] arr4 = "네명".getBytes();
		
		String a = new String(arr1,Charset.forName("MS949"));
		String b = new String(arr2,Charset.defaultCharset());
		String c = new String(arr3,"UTF-8");
		String d = new String(arr4,"UTF-8");
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}

}
