package javaStudy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Star {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		int line= Integer.parseInt(n.readLine());
		for(int i=0;i<line;i++){
			for(int j=0;j<line;j++) {
				if((i+j)<(line-1)){
					System.out.print(" ");
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
