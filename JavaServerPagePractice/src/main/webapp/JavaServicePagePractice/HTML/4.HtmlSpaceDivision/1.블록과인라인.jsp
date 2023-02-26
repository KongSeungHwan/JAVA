<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블록과 인라인 활용</title>
</head>
<body>
	<p style="border: 10px solid black; text-align: center">p요소는
		display 속성값이 블록인 요소입니다.</p>
	<div
		style="background-color: lightgrey; color: green; text-align: center">
		<h1>div요소를 이용한 스타일 적용</h1>
		<p>이렇게 div 요소로 여러요소들을 묶은 다음에 style 송성과 클래스 등을 이용하여 한번에 스타일을 적용
			가능하다.</p>
	</div>
	<p>
		<span style="background-color: grey; color: orange; font-size: 30px">span
			태그</span>
	</p>
	<p>
		이렇게 <span style="border: 3px solid red">span요소로 텍스트의 일부분</span> 만을 따로
		묶은 후에 스타일을 적용할 수 있습니다.
	</p>
</body>
</html>