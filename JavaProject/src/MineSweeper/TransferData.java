package MineSweeper;
import java.util.HashMap;
//다른 곳(DB)에서 받아온 데이터를 HashMap(회원ID(key), 회원 객체(value))자료구조 형식에 맞춰 변환하여 저장하는 클래스
//나중에 파일 입출력으로 받아온 데이터처리 기능도 추가해야 할 가능성이 있으므로 이 클래스를 만들었다.(필요 시 이 클래스만 고치면 된다!)
public class TransferData{
	HashMap<String,Client> dbList;
	DAO dao;
	TransferData(){
		dao=new DAO();
		dbList= dao.databaseClientList;
	}
	boolean addClientByDB(String name,String id,String pw){
		if(dao.insertSQL(name,id, pw)==true) {
			System.out.println("완료!");
			return true;
		}else {
			System.out.println("실패! 관리자에게 문의하십시오.");
			return false;
		}
	}
}
