<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>해당하는 고객 리스트</title>
</head>
<body>
	검색결과
	<table width="100%" border="1">
		<thead>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>잔고</th>
			</tr>
		</thead>
		<tbody>
			<%
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			request.setCharacterEncoding("utf-8");
			try {
				String jdbcDriver = "jdbc:mysql://localhost:3307/atmsystem?useUnicode=true&characterEncoding=utf8";
				String dbUser = "root";
				String dbPwd = "3520";
				String bank = request.getParameter("bank");
				conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPwd);

				pstmt = conn.prepareStatement("select * from client where bank=?");
				pstmt.setString(1, bank);

				rs = pstmt.executeQuery();

				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getString("client_name")%></td>
				<td><%=rs.getString("client_id")%></td>
				<td><%=rs.getString("balance")%></td>
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