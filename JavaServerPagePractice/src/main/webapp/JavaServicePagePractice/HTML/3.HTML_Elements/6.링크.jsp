<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>하이퍼링크를 이용한 이미지 출력</title>
</head>
<body>
	<a href="http://www.naver.com" target="_blank"> <img
		src="./naver.png" style="width: 100px; height: 100px;">
	</a>
	<a href="http://www.daum.net" target="_blank"> <img
		src="./daum.png" style="width: 100px; height: 100px">
	</a>
	<!-- a는 안에 있는 글을 하이퍼링크로 걸어버리는 기능을 하는 태그
	속성값은 각각 href,target이 있고
	href는 url, target은 _self,_blank가 있다.(현 재창,새창)
	 위의 코드는 a태그를 부모 태그로 이미지 태그를 상속시켜 
	 이미지를 누르면 해당 페이지로 넘어가게끔 효과를 넣어준것.
	 -->
	<a href="http://naver.com" target="_blank"> <img src="./naver.png"
		alt="html size" width="100" height="100">
	</a>
	<!--width, height 는 pixel 단위-->
	<img src="./daum.png" alt="이미지 파일 없음" usemap="#map">
		<map name="map">
			 <area shape="circle" coords="140,100,40" alt="진실" href="https://www.naver.com">
			<area shape="circle" coords="220,180,40" alt="거짓" href="https://www.daum.net">
		</map>
		<!-- 해당 map의 mapname에 연결된 인자의 태그의 영역을 나눠 하이퍼링크를 거는 태그 -->

</body>
</html>