<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>색 넣기</title>
</head>
<body>
<h1 style="background-color:blue">
무슨 색일까?
</h1>
<!--위의 것은 h1 태그 범위 한정 배경색 변경 속성인 것!
	
	복수 속성을 하려면 띄어쓰기 하고 옆에 형식에 맞게 쓰면 된다.
	<p style="color:blue" text-align="center">
	이런식
	
	style 속성값을 여러개 하고 싶다!
	그러면
	style="속성:값; 속성2:값"
	을 알고 있으면 된다.
	
	style 속성들
	background-color(배경색)
	color(글자색)
	font-family(글꼴 모양)
		couier(얇은 글씨)
		verdana(굵은 글씨)
	font-size(글꼴 크기)
		px(픽셀)(고정된 값) 또는 %(상대 값) 단위
	text-align 속성들(정렬)
		기본 정렬은 왼쪽위 상단기준 정렬이다.
		
		center(가운데 정렬)
		left(왼쪽 정렬)
		right(오른쪽 정렬)
		justify(양쪽 정렬)
		inherit(부모 요소의 정렬 속성 값을 상속 받는다)
		**그럼 상속관계가 존재하지 않는 다면? 어떻게 될라나? 기본값으로 정렬됨.
		왜냐? 부모 속성인 body,html도 기본 정렬이기 때문이다.
		initial(기본값으로 설정)

		부모 자식 픽셀 관계
		<html><body>안녕</body></html>
			위와 같은 html태그는 body태그의 부모,
					body태그는 html태그의 자식
					이라는 관계가 된다.
		
-->


<p style="text-align:inherit">
안녕하세요
</p>



</body>
</html>