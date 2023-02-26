<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 파일 가져오기</title>
</head>
<body>
	<p> 제리짤 가져오기(gif)<br>
		<img src="./jerry.gif" alt="해당 경로에 이미지 파일이 존재하지 않습니다" style="width:500px; height:500px"> <br>
		카카오 프렌즈 이미지 가져오기
		<img src="./kakao.png" alt="해당 경로에 이미지가 존재하지 않습니다.">
			<br>
		<img src="./park.jpg" alt="(파일없다 이자슥아)">&lt&lt예외처리 &lt&lt이미지
		안넣음 그러면 alt 속성값이 뜸
		<!-- 일부러 이름만 다르게 해서 안뜨게 한 것임. -->
		<img src="./park1.jpg" alt="해당 경로에 이미지 파일이 존재하지 않습니다">
		&lt&lt 공원 이미지(핀터 사용)
		<!-- 절대경로는 귀찮아서 그냥 상대경로로 씀 
	절대 경로 같은 경우는 http://localhost(포트번호)... 
	요렇게 써야해서 개귀찮음
	절대경로와 상대경로
	절대경로는 장치에 정확이 어디에 저장되어있나 나타내는 경로
	상대경로는 해당 프로그램이 설치되어있는 디렉터리 기준으로 정한 경로
	절대경로는 데이터 분실 가능성이 아예없지만
	상대경로는 데이터 분실 가능성이 있다.-->
	</p>
</body>
</html>