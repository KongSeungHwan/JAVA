package MineSweeper;

import java.sql.*;
import java.util.HashMap;

public class DAO {
	Connection con;
	String connect="jdbc:mysql://localhost:3306/minesweeper?serverTimezone=UTC";
	String dbid ="root";
	String dbpw ="3520";
	Statement state;
	ResultSet rs;//최대한 중복되는 객체들은 필드로 처리(자바는 초기화 안 할 시 디폴트 값이 null이거나 0이지만, c는 쓰레기 값이 초기화된다.)
	HashMap<String,DTO> databaseClientList;
	DAO(){databaseClientList=allDataSQL();
	try {
		con = DriverManager.getConnection(connect,dbid,dbpw);
	} catch (SQLException e) {
		System.out.println("DB연결 실패");
	}
	} //생성시 바로 데베에있는 모든 데이터 hashmap으로 초기화
	final void closeResource(){//템플릿 메소드(공부한 것 응용)
		try {
			if (state != null)rs.close();
			if (rs != null)rs.close();
			if (con != null)con.close();
		}catch(SQLException e) {
		}
	}//시스템 자원 반환 한꺼번에 처리하는 메소드
	boolean insertSQL(String name,String id, String pw){
		try {
			state=con.createStatement();
			String sql = "insert into minesweeper.client(client_name,client_id,client_pw,total_rounds,victory_rounds,victory_rate)"
					+ "values('"+name+"','"+id+"','"+pw+"',"+0+","+0+","+0+");";
			//entity 추가 insert문 활용
			state.execute(sql);
			return true;
		}catch(SQLException e){
			System.out.println("SQL문법 오류");
			return false;
		}
	} //처음 만들 시에는 판수가 0으로 되어야하니까 victory,total 둘 다 0으로 insert문을 구성.

	DTO personalInquirySQL(String id) throws SQLException{
		try {
			String sql="select * from minesweeper.client where client_id='"+id+"';";
			state=con.createStatement();
			rs = state.executeQuery(sql);
			if(rs.next())return new DTO(rs.getString("client_name"),rs.getString("client_id"),rs.getString("client_pw"),rs.getInt("total_rounds"),rs.getInt("victory_rounds"),rs.getDouble("victory_rate"));
			else{
				System.out.println("해당 계정이 존재하지 않습니다.");
				return null;
			}//key값은 단일 개수로만 존재하니까 if문 단한번만 돌려도 무방(굳이 무한루프 돌릴 필요 x)
		}
		catch(SQLException e){
			System.out.println("SQL문법 오류");
			return null;
		}
	}
	HashMap<String,DTO> allDataSQL(){
		HashMap<String,DTO> resultList = new HashMap<>();
		try {
			con = DriverManager.getConnection(connect,dbid,dbpw);
			String sql="select * from minesweeper.client;";
			state = con.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next())resultList.put(rs.getString("client_id"),new DTO(rs.getString("client_name"),rs.getString("client_id"),rs.getString("client_pw"),rs.getInt("total_rounds"),rs.getInt("victory_rounds"),rs.getDouble("victory_rate")));
			return resultList;
		} catch (SQLException e) {
			System.out.println("SQL문법 오류");
			return null;
		}
	}
	boolean checkLoginId(String id){
		try {
			state = con.createStatement();
			String sql="select * from minesweeper.client where client_id='"+id+"';";
			rs = state.executeQuery(sql);
			return rs.next(); //있는지 없는지만 체크! next 함수가 리턴 값이 boolean임(if문이나 삼항으로 나누면 코드만 길어지고 가독성 떨어짐)
		} catch (SQLException e) {
			System.out.println("SQL문법 오류");
			return false;
		}
	}
	boolean checkPassword(String password){
		try {
			state = con.createStatement();
			String sql="select * from minesweeper.client where client_password='"+password+"';";
			rs = state.executeQuery(sql);
			return rs.next();
		} catch (SQLException e){
			System.out.println("SQL문법 오류");
			return false;
		}
	}//각자 메소드의 리턴 값이 다르기에 예외처리도 다 제각각 함.
	//Connector 객체는 필드로 놓고
	//PreparedStatement를 안쓰고 Statement 객체를 쓰는 이유 
	//전자 객체는 보안 공격에 취약하다. 그 반면 Statement 객체는 안전하다.
	//+DB연결 예외와 SQL문법 오류 가능성을 나눔.
}
