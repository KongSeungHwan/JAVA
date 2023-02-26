package MineSweeper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientManagement{
	ClientList cList;
	BufferedReader n = new BufferedReader(new InputStreamReader(System.in));

	ClientManagement(){
		cList = new ClientList();
	}
	DTO checkInfo() throws IOException{
		System.out.println("아이디 입력!");
		String id = n.readLine();
		System.out.println("비밀번호 입력!");
		String pw = n.readLine();
		if(cList.list.isEmpty()) {
			System.out.println("존재하지 않는 계정입니다.");
			return null;
		}
		else{
			if(cList.list.get(id)!=null){
				if(cList.list.get(id).getPw().equals(pw)) {
					System.out.println("로그인 성공!");
					return cList.list.get(id);
				}else {
					System.out.println("비밀번호가 틀립니다.");
					return null;
				}
			}else return null;	
		}
	}
	boolean signUp() throws IOException{
		System.out.println("이름 입력!");
		String name = n.readLine();
		System.out.println("아이디 입력!");
		String id = n.readLine();
		if(cList.list.get(id)!=null)return false; //중복 제거
		System.out.println("비밀번호 입력!");
		String pw = n.readLine();
		return cList.addClient(name, id, pw);
	}
}
