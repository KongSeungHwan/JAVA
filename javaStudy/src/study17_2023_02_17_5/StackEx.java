package study17_2023_02_17_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackEx {

	public static void main(String[] args) throws IOException {
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		//괄호 추가 프로그램
		String a = n.readLine();
		Stack<Character> st = new Stack<>();
		char[] chl = a.toCharArray();
		char[] chl2 = a.toCharArray();
//		a가 String이면 a[0]==첫글자,a[1]==둘째 글자.. 일케 되는데..(c언어)
//		while(st.isEmpty()) { //괄호 제거 프로그램
//			if(chl[i]=='('){st.push(')');continue;}
//		if(chl[i]=='{'){st.push('}');continue;}
//			if(chl[i]=='['){st.push(']');continue;}
//		}
	}

}
