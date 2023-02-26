package MineSweeper;

import java.sql.*;
import java.util.HashMap;

public class DAO {
	Connection con;
	String connect="jdbc:mysql://localhost:3306/minesweeper?serverTimezone=UTC";
	String id ="root";
	String pw ="3520";
	Statement state;
	PreparedStatement pstmt;
	ResultSet rs;
	HashMap<String,DTO> list = new HashMap<>();
	DAO(){list=allDataSQL();} //생성시 바로 데베에있는 모든 데이터 hashmap으로 초기화
	void closeResource(){
		try {
			if (rs != null)rs.close();
			if (pstmt != null)pstmt.close();
			if (con != null)con.close();
		}catch(SQLException e) {
		}
	}
	boolean insertSQL(String name,String id, String pw){
		try {con = DriverManager.getConnection(connect,id,pw);
		state=con.createStatement();
		String sql = "insert into minesweeper.client(client_id,client_password,client_name,total_rounds,victory_rounds)"
				+ "values('"+id+"','"+pw+"','"+name+"',"+0+","+0+");";
		state.execute(sql);
		return true;
		}catch(SQLException e){
			System.out.println("DB연결 실패 또는 SQL문법 오류");
			return false;
		}
	} //처음 만들 시에는 판수가 0으로 되어야하니까 victory,total 둘 다 0으로 insert문을 구성.

	DTO personalInquirySQL(String id) throws SQLException{
		try {
			con = DriverManager.getConnection(connect,id,pw);
			String sql="select * from minesweeper.client where client_id='"+id+"';";
			rs = state.executeQuery(sql);
			if(rs.next())return new DTO(rs.getString("client_name"),rs.getString("client_id"),rs.getString("client_pw"),rs.getInt("total_rounds"),rs.getInt("victory_rounds"));
			else{
				System.out.println("해당 계정이 존재하지 않습니다.");
				return null;
			}
		}
		catch(SQLException e){
			System.out.println("DB연결 실패 또는 SQL문법 오류");
			return null;
		}
	}
	HashMap<String,DTO> allDataSQL(){
		HashMap<String,DTO> resultList = new HashMap<>();
		try {
			con = DriverManager.getConnection(connect,id,pw);
			String sql="select * from minesweeper.client;";
			state = con.createStatement();
			rs = state.executeQuery(sql);
			while (rs.next()) {
				resultList.put(rs.getString("client_id"),new DTO(rs.getString("client_name"),rs.getString("client_id"),rs.getString("client_pw"),rs.getInt("total_rounds"),rs.getInt("victory_rounds")));
			}
			return resultList;
		} catch (SQLException e) {
			System.out.println("DB연결 실패 또는 SQL문법 오류");
			return null;
		}
	}
	boolean checkLoginId(String id){
		try {
			con = DriverManager.getConnection(connect,id,pw);
			state = con.createStatement();
			String sql="select * from minesweeper.client where client_id='"+id+"';";
			rs = state.executeQuery(sql);
			return rs.next(); //있는지 없는지만 체크! next 함수가 리턴 값이 boolean임
		} catch (SQLException e) {
			System.out.println("DB연결 실패 또는 SQL문법 오류");
			return false;
		}
	}
	boolean checkPassword(String password){
		try {
			con = DriverManager.getConnection(connect,id,pw);
			state = con.createStatement();
			String sql="select * from minesweeper.client where client_password='"+password+"';";
			rs = state.executeQuery(sql);
			return rs.next();
		} catch (SQLException e){
			System.out.println("DB연결 실패 또는 SQL문법 오류");
			return false;
		}
	}
}
