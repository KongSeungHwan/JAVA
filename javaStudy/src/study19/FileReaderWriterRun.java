package study19;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReaderWriterRun {
	public static void main(String[] args) {
		File file = new File("src\\study19\\files\\BufferedFile.txt");
		File file2 = new File("src\\study19\\files\\BufferedOutFile.txt");
		if(!file.exists())
		if(!file2.exists())	
		try (	FileInputStream w = new FileInputStream(file);
				FileOutputStream r = new FileOutputStream(file2);
				BufferedInputStream bi = new BufferedInputStream(w);
				BufferedOutputStream bo = new BufferedOutputStream(r);
				){
			int i;
			while((i=bi.read())!=-1) bo.write(i);
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
