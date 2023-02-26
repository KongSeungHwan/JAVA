<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블 만들기</title>
<!-- 특정 값 속성 정의 하는 영역 -->
<style>
	table,tr,th,td {border:10px;}
</style>
</head>
<body>
<table style="width:100%">
	<tr>
		<th>사이트 이름</th>
		<th>하이퍼링크</th>
	</tr>
	<tr style="text-align:center">
		<th>네이버</th>
		<th><a href="http://www.naver.com" target="_blank"><img src="./naver.png" style="width:100px; height:100px"></a></th>
	</tr>
	<tr>
		<th>다음</th>
		<th><a href="http://www.daum.net" target="_blank"><img src="./daum.png" style="width:100px; height:100px"></a></th>
	</tr>
	<tr>
		<th>카카오</th>
		<th><a href="https://www.kakaocorp.com/" target="_blank"><img src="./Kakao.png" style="width:100px; height:100px"></a></th>
	</tr>
	<tr>
		<th>제리짤</th>
		<th><img src="./jerry.gif" style="width:100pxpx; height:100px"></th>
	</tr>
</table>
</body>
</html>