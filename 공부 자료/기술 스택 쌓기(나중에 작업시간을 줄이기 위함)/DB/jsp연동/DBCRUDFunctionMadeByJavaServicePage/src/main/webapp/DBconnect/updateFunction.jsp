<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String value = request.getParameter("value");
	try{
		String jdbcDriver = "jdbc:mysql://localhost:3306/atmsystem?useUnicode=true&characterEncoding=utf8";
		String dbUser = "root";
		String dbPwd = "3520";
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPwd);
		String sql = "update client set client_password= ? where client_name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, value);
		pstmt.setString(2, name);
		pstmt.executeUpdate();
		%>수정 완료<%
	}catch(SQLException se){
		%>알 수 없는 값을 입력하였습니다. 다시 시도해주십시오<%
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(conn != null) conn.close();
	}
		 %>



</body>
</html>