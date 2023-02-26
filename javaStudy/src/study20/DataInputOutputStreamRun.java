package study20;

import java.io.*;

public class DataInputOutputStreamRun {

	public static void main(String[] args) throws IOException {
		File f = new File("src/study20/files/file.data");
		try(
		FileOutputStream o = new FileOutputStream(f,false);
		//default 인자 true 파일이 없다면 false처리
		FileInputStream i = new FileInputStream(f);
		BufferedInputStream bi = new BufferedInputStream(i);
		BufferedOutputStream bo = new BufferedOutputStream(o);
		DataInputStream dis  = new DataInputStream(bi);
		DataOutputStream dos = new DataOutputStream(bo);){
			dos.writeInt(99);
			dos.writeDouble(11.12);
			dos.writeChar(65);
			dos.writeChar(66);
			dos.writeUTF("아");
			dos.flush();
			
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readChar());
			System.out.println(dis.readChar());
			System.out.println(dis.readUTF());
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

}
