package study20;

import java.io.*;

public class BufferedReaderWriterRun {

	public static void main(String[] args) throws IOException {
		File file = new File("src\\study20\\files\\f1.txt");
		if(!file.exists()) file.createNewFile();
		try(
				Writer writer = new FileWriter(file);
				Reader reader = new FileReader(file);
				BufferedWriter bw = new BufferedWriter(writer);
				BufferedReader br = new BufferedReader(reader);){
			bw.write("Seoul Korea\n".toCharArray());
			bw.write(123);
			bw.write("come to my home"); //괄호가 왜 붙지?
			bw.flush();

			String data;
			while((data=br.readLine())!=null) System.out.println(data);
		}catch(IOException e) {
			e.printStackTrace();
		}

	}


}

