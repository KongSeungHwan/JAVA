<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서식에 관하여</title>
</head>
<body>
	<p><b>"이 부분"</b>은 단순히 글씨가 굵은 부분이에요!</p>
	<p><strong>"이 부분"</strong>은 중요한 부분이라서 굵게 표현했어요!</p>
	<%--
	<b>와<strong>은 글씨를 굵게 할때 사용하는 태그이다.
	 두 개의 차이는 b는 단순히 진하게 표시할 때 쓰고,
	 strong는 기능은 b와 동등하지만 웹 접근성에 기여한다는 또 다른 특징을 가지고 있다.
	 --%>
	<p><i>"이 부분"</i>은 단순히 글씨가 이탤릭체인 부분입니다.</p>
	<p><em>"이 부분"</em>은 중요한 부분이라서 이탤릭체로 표현 됐어요</p>
	<%--i,em은 포함된 글을 이탤릭체로 표현할 때 씀
	(오른쪽으로 45도 기울어진듯한 모양)
	i,em 태그의 차이 b,strong 관계와 동일
	 --%>
	 <p><mark>"이 부분"</mark>만 하이라이팅 하고 싶어요.</p>
	 <%-- 
	 mark 태그는 해당 글에 형광펜 칠한 듯한 느낌의 표현을 해줌.
	 (하이라이팅 효과라고 함)
	  --%>
	  <p><del>"이 부분"</del>을 지운 것처럼 하고 싶어요.</p>
	  <%--
	  del 텍스트는 글을 빗금친 모양새로 표현해줌
	   --%>
	  <p><ins>"밑줄 친 부분"</ins>에 들어갈 알맞은 말을 고르세요.</p>
	  <%--ins 태그는 글 밑에 밑줄 쳐줘서 표현해줌. 
	   --%>
	   <p>X<sup>2</sup>+ Y<sup>3</sup> = Z</p>
	   <p>물을 나타내는 화학식은 H<sub>2</sub>O 입니다.</p>
	   <%--sup은 제곱을 표현해주는 태그
	   		sub는 숫자나 문자에 밑 번호를 표현해주는 태그(위의 화학식 같이)
	    --%>
</body>
</html>