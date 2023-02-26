package MemberManagementSystemMadeByJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnecter{
	static int accountNumber=0;
	Connection con; //db 드라이버 연결 객체
	Statement state; //PreparedStatement의 상위 객체, 다형성으로 이용가능
	PreparedStatement pstmt; //상태 객체
	ResultSet rs; //중복 값이 없는 데이터 집합을 의미
	DbConnecter(){}

	void insertSQL(String name,String id, String pw){
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsystem?serverTimezone=UTC","root","3520");
			String sql = "insert into client(client_id,client_password,client_name,balance,account_number)"
					+ "values('"+id+"','"+pw+"','"+name+"',"+0+","+accountNumber+");";
			state=con.createStatement();
			state.execute(sql);
			System.out.println("회원가입 완료! \n");
			accountNumber++;
		}catch(SQLException t) {
			System.out.printf("db 연결 실패 또는 sql 문법오류");
		}

	}
	void deleteSQL(String id){
		try{ 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsystem?serverTimezone=UTC","root","3520");
			state = con.createStatement(); //state 객체를 리턴하는 함수
			String sql="select * from client where client_id='"+id+"';";
			rs = state.executeQuery(sql); //select문을 기입시 사용하는 메소드
			if(rs.next()) { //sql문으로 실행한 테이블의 다음 요소가 있는지 판별하는 boolean 메소드
				sql = "delete from client where client_id ='"+id+"';";
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();
			}else {
				System.out.println("없는 아이디 입니다.");
			}
		}catch(SQLException t) { //db연결시 예외가 생길경우를 처리하는 catch문
			System.out.printf("db 연결 실패 또는 sql 문법 오류");
		}


	}
	void selectSQL(String id) throws InterruptedException{
		try{ 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsystem?serverTimezone=UTC","root","3520");
			state = con.createStatement();
			String sql="select * from client where client_id='"+id+"';";
			rs = state.executeQuery(sql);
			if(rs.next()) {
				int accountNumber =rs.getInt("account_number");
				String name =rs.getString("client_name");
				int balance =rs.getInt("balance");
				System.out.printf(" 이름:%s"+" 계좌번호:%d , 잔고:%d \n",name,accountNumber,balance);
			}
		}catch(SQLException t) {
			System.out.printf("중복되는 아이디가 있습니다.");
			Thread.sleep(1000);
		}


	}
	void updateSQL(String id,String index,String value) {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsystem?serverTimezone=UTC","root","3520");
			state = con.createStatement();
			String sql="select * from client where client_id='"+id+"';";
			rs = state.executeQuery(sql);
			if(rs.next()) {
				sql = "update client set "+index+" = '"+value+"' where client_id= '"+id+"';";
				state.executeUpdate(sql);
			}else {
				System.out.println("없는 아이디 입니다.");
			}
		} catch (SQLException e) {
			System.out.println("db연결 실패 또는 sql 문법오류");
		}
	}
	boolean checkLoginId(String id){
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsystem?serverTimezone=UTC","root","3520");
			state = con.createStatement();
			String sql="select * from client where client_id='"+id+"';";
			rs = state.executeQuery(sql);
			return rs.next();
		} catch (SQLException e) {

			return false;
		}
	}
	boolean checkPassword(String password){
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsystem?serverTimezone=UTC","root","3520");
			state = con.createStatement();
			String sql="select * from client where client_password='"+password+"';";
			rs = state.executeQuery(sql);
			return rs.next();
		} catch (SQLException e){

			return false;
		}
	}
	Client cookie(String id){
		try{ 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsystem?serverTimezone=UTC","root","3520");
			state = con.createStatement();
			String sql="select * from client where client_id='"+id+"';";
			rs = state.executeQuery(sql);
			if(rs.next()) {
				String name =rs.getString("client_name");
				String clientId = rs.getString("client_id");
				String clientPassword = rs.getString("client_password");
				int balance =rs.getInt("balance");
				int accountNumber =rs.getInt("account_number");
				return new Client(name,clientId,clientPassword,balance,accountNumber);
			}
		}catch(SQLException t) {
			System.out.printf("db 연결 실패 또는 sql 문법오류");
			return new Client();
		}
		return null;
	}



	//기본기능 CRUD 기능 구현
}
