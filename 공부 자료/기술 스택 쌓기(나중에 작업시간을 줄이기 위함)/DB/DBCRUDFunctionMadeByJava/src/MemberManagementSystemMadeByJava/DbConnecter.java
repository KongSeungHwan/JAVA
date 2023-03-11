package MemberManagementSystemMadeByJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnecter{
	static int accountNumber=0;
	Connection con;
	Statement state;
	PreparedStatement pstmt;
	ResultSet rs;
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
			state = con.createStatement();
			String sql="select * from client where client_id='"+id+"';";
			rs = state.executeQuery(sql);
			if(rs.next()) {
				sql = "delete from client where client_id ='"+id+"';";
				pstmt = con.prepareStatement(sql);
				pstmt.executeUpdate();
			}else {
				System.out.println("없는 아이디 입니다.");
			}
		}catch(SQLException t) {
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
				/*String clientId = rs.getString("client_id");
				String clientPassword = rs.getString("client_password");*/
				int accountNumber =rs.getInt("account_number");
				String name =rs.getString("client_name");
				int balance =rs.getInt("balance");
				System.out.printf(" 이름:%s"/*, 아이디:%s, 비밀번호:%s,*/+" 계좌번호:%d , 잔고:%d \n",name,/*clientId,clientPassword,*/accountNumber,balance);
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
