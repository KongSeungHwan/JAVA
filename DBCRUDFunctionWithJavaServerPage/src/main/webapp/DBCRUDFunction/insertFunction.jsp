<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>추가 완료 페이지</title>
</head>
<body>

	<%
	int accountNumber = 0;
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String bank = request.getParameter("bank");
	try {
		String jdbcDriver = "jdbc:mysql://localhost:3307/atmsystem?useUnicode=true&characterEncoding=utf8";
		String dbUser = "root";
		String dbPwd = "3520";

		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPwd);

		pstmt = conn.prepareStatement(
		"insert into client set client_name=?, client_id=?,client_password=?,balance=?,account_number=?,bank = ?;");
		pstmt.setString(1, name);
		pstmt.setString(2, id);
		pstmt.setString(3, pw);
		pstmt.setInt(4, 0);
		pstmt.setInt(5, accountNumber);
		pstmt.setString(6, bank);
		int count = pstmt.executeUpdate();
	%><%=name%>님이 추가 되었습니다.(<%=bank%>은행)
	<%
	accountNumber++;
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
	<button type="button" onclick="location.href='./firstPage.html'">돌아가기</button>


</body>
</html>