package MineSweeper;
import java.util.HashMap;
public class ClientList{
	HashMap<String,DTO> list;
	DAO dao;
	ClientList(){
		dao=new DAO(); //생성자가 호출되는 순간만 생성되도록 설정 그이외에는 선언만 한 형태(공간 복잡도 생각)
		list= dao.databaseClientList;
	}
	boolean addClient(String name,String id,String pw) {

		if(dao.insertSQL(name,id, pw)==true) {
			System.out.println("회원가입 완료!");
			return true;
		}else {
			System.out.println("가입 실패! 관리자에게 문의하십시오.");
			return false;
		}
	}
	void showClientInfo(String id){
		System.out.printf("%s님의 정보! \n",list.get(id).getName());
		System.out.printf("id: %s \n",list.get(id).getId());
		System.out.printf("pw: %s \n",list.get(id).getPw());
		System.out.printf("승률: %d \n",(int)(list.get(id).getvRounds()));
		System.out.printf("총 판수: %d \n",(int)(list.get(id).gettRounds()));
		System.out.printf("승률: %.2f \n",list.get(id).getvRate());//소수점 아래 2번째까지 반올림 처리
	}//숫자 야구게임 (볼 카운트 수) = (총 일치수)-(스트라이크 카운트 수) 응용
}
