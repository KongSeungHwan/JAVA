<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제거완료 페이지</title>
</head>
<body>

	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	request.setCharacterEncoding("utf-8");
	try{
		String jdbcDriver = "jdbc:mysql://localhost:3307/atmsystem?useUnicode=true&characterEncoding=utf8";
		String dbUser = "root";
		String dbPwd = "3520";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPwd);
		
		pstmt = conn.prepareStatement("delete from client");
		int count= pstmt.executeUpdate();
		%>모두 삭제 되었습니다.
	<%
	}catch(SQLException se){
		se.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
		 %>
	<button type="button" onclick="location.href='./firstPage.html'">돌아가기</button>
</body>
</html>