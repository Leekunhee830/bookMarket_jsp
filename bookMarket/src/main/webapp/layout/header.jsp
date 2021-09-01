<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${pageContext.request.contextPath}/css/header.css"  rel="stylesheet" type="text/css"/>

<title>Insert title here</title>
</head>
<body>
	<div class="header_wrap">
		<div class="header_top">
			<div class="header_top_cont row">
				<ul class="top_member_box row">
					<li><a href="#">로그인</a></li> 
					<li><a href="#">회원가입</a></li>
					<li><a href="#">장바구니</a></li>
					<li><a href="#">마이페이지</a></li>
					<li><a href="#">고객센터</a></li>
				</ul>
			</div>
		</div>
		
		<div class="header_search">
			<div class="header_search_cont">
				<div class="logo">
					<a href="#">Book Market</a>
				</div>
				<div class="search">
				<form action="#" metohd="get">
					<input type="text" name="">
					<input type="image" src="${pageContext.request.contextPath}/img/search.png">				
				</form>
				</div>
			</div>
		</div>
		
		<div class="header_gnb">
			<div class="gnb_cont">				
				<ul class="gnb_box row">
					<li><a href="#">전체상품</a></li>
					<li><a href="#">베스트셀러</a></li>
					<li><a href="#">취업 수험서</a></li>
					<li><a href="#">컴퓨터,모바일</a></li>
					<li><a href="#">외국어</a></li>
				</ul>
			</div>
		</div>
		
	</div>
	
	
</body>
</html>