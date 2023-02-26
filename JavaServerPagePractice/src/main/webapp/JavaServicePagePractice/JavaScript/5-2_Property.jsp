<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 받은 값 출력 페이지(객체 생성)</title>
</head>
<body>
<h1>객체 정보 입력 후 문서 출력</h1>
<p style="text-align:center; color:olive; background-color:#FFF8DC; font-size:50px">
<script>
var gen = "<%=request.getParameter("gender")%>";
if(gen == "m"){gen = "남";}
else{gen = "여";}	

var person = {
		name: "<%=request.getParameter("name")%>",
		gender: gen,
		age: <%=request.getParameter("age")%>
}
document.write("<br>이름: <br>");
document.write(person.name);
document.write("<br>성별: <br>");
document.write(person.gender);
document.write("<br>나이: <br>");
document.write(person.age);
</script>
</p>
</body>
</html>