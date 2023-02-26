<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인용구</title>
</head>
<body>

<p>HTML
<q>웹 페이지를 만들기 위한 하이퍼텍스트 마크업 언어</q>
입니다.
</p>
<%--인용구 "~~"를 표현해주는 태그 --%>
<p>HTML의 정의</p>
<blockquote>
	인터넷 서비스의 하나인 월드 와이드 웹을 통해 볼 수 있는 문서를 만들 때
	사용하는 프로그래밍 언어의 한 종류이다.
</blockquote>

<%--p가 단락을 나누는 태그인데 그 안의 단락을 또 나누는 태그이다.
head+paragraph(blackquote+blackquote....)
구조가 이런식! blackquote 안에 또 blackquote가 있을 수 있음
 --%>
 
<p><strong><abbr title="HyperText Markup Language 5">HTML5</abbr></strong>
란 웹 문서를 제작하는 데 쓰이는 프로그래밍 언어인 HTML의 최신규격입니다.</p>
<%--abbr는 축약형 태그이다. title 속성값을 줄인 값을 쓴다.
	검색엔진에게 유용한 정보를 제공가능.
--%>
<address>
서울특별시<br>
강남구 테헤란로
</address>
<%--html에서 주소표현시 쓰는 태그 글 앞에 약간 공백을 넣는 기능이 있다.
i, em이랑 기능이 똑같네? --%>
</body>
</html>