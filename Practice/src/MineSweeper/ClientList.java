package MineSweeper;
import java.util.HashMap;
public class ClientList{
	HashMap<String,DTO> list;
	DAO dao = new DAO();
	ClientList(){
		list= dao.list;
	}
	boolean addClient(String name,String id,String pw) {
		System.out.println("회원가입 완료!");
		return dao.insertSQL(name,id, pw);
	}
	void showClientInfo(String id){
		System.out.printf("%s님의 정보! \n",list.get(id).getName());
		System.out.printf("id: %s",list.get(id).getId());
		System.out.printf("pw: %s",list.get(id).getPw());	
	}
}
