<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javascript test</title>
</head>
<body>
<p style ="font-size:50px">
<script>

var oper = "<%=request.getParameter("oper")%>";
var num1 = "<%=request.getParameter("num1")%>";
var num2 = "<%=request.getParameter("num2")%>";

if(oper==="pl"){
	document.write(" 더한 값은 ");
	document.write(parseInt(num1)+parseInt(num2));
}else if(oper === "mi"){
	document.write("뺀 값은 ");
	document.write(parseInt(num1)-parseInt(num2));
}else if(oper === "mu"){
	document.write("곱한 값은 ");
	document.write(parseInt(num1)*parseInt(num2));
}else if(oper === "di"){
	document.write("나눈 값은 ");
	document.write(parseInt(parseInt(num1)/parseInt(num2)));	
	document.write("**나머지 버림처리.");
}else{
	
}
</script>
</p>
</body>
</html>