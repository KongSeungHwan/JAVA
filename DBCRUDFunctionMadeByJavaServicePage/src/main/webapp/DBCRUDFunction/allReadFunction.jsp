<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
</head>
<body>
	고객 리스트
	<table width="100%" border="1">
		<thead>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>잔고</th>
				<th>계좌번호</th>
				<th>은행</th>
			</tr>
		</thead>
		<tbody>
			<%
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				String jdbcDriver = "jdbc:mysql://localhost:3306/atmsystem?useUnicode=true&characterEncoding=utf8";
				String dbUser = "root";
				String dbPwd = "3520";
				conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPwd);

				pstmt = conn.prepareStatement("select * from client");

				rs = pstmt.executeQuery();

				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString("client_name")%></td>
				<td><%=rs.getString("client_id")%></td>
				<td><%=rs.getString("client_password")%></td>
				<td><%=rs.getString("balance")%></td>
				<td><%=rs.getString("account_number")%></td>
				<td><%=rs.getString("bank")%></td>
			</tr>
			<%
			}
			} catch (SQLException se) {
			se.printStackTrace();
			} finally {
			if (rs != null)
			rs.close();
			if (pstmt != null)
			pstmt.close();
			if (conn != null)
			conn.close();
			}
			%>
		</tbody>
	</table>
	<button type="button" onclick="location.href='./firstPage.html'">돌아가기</button>
</body>
</html>