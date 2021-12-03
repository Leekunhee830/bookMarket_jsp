<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${pageContext.request.contextPath}/css/header.css"  rel="stylesheet" type="text/css"/>

<!-- jquery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>

<!-- slick-slider -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/slick/slick-theme.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/slick/slick.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/slick/main_slick.js"></script>

<!-- 카카오 로그인 API -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/kakao_login.js"></script>

<!-- Iamport js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<!-- 카카오(다음) 주소 API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/addressDaum.js"></script>

<!-- summernote css/js -->
<script src="${pageContext.request.contextPath}/js/summernote/summernote-lite.min.js"></script>
<script src="${pageContext.request.contextPath}/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/summernote/summernote-lite.css">

<title>Insert title here</title>
</head>
<body>
	<div class="content_wrap">
		<div class="header_wrap">
			<div class="header_top">
				<div class="header_top_cont row">
					<ul class="top_member_box row">
					<c:choose>
						<c:when test="${sessionScope.currentName==null}">
							<li><a href="/bookMarket/login/loginView.jsp">로그인</a></li> 
							<li><a href="/bookMarket/join/joinView.jsp">회원가입</a></li>
						</c:when>
						<c:otherwise>
							<li>${sessionScope.currentName}님</li>
							<li><a href="/bookMarket/logout.do" id="kakaoLogout()">로그아웃</a></li>
							<li><a href="/bookMarket/mypage/mypage.do">마이페이지</a></li>
							<li><a href="/bookMarket/cart/AllCart.ct">장바구니</a></li>
							<c:if test="${sessionScope.currentId=='admin' }">
								<li><a href="/bookMarket/product/add_productView.jsp">상품 등록</a></li>
								<li><a href="/bookMarket/product/ProductManager.pd">상품관리</a>
							</c:if>
						</c:otherwise>
						
					</c:choose>
						<li><a href="#">고객센터</a></li>
					</ul>
				</div>
			</div>
			
			<div class="header_search">
				<div class="header_search_cont">
					<div class="logo">
						<a href="/bookMarket/index.jsp">Book Market</a>
					</div>
					<p class="search">
						<input type="text" name="" class="search_tag">
						<input type="image" src="${pageContext.request.contextPath}/img/search.png" class="search_img">
					</p>
				</div>
			</div>
			
			<div class="header_gnb">
				<div class="gnb_cont">				
					<ul class="gnb_box row">
						<li><a href="/bookMarket/product/AllProductView.pd">전체상품</a></li>
						<li><a href="#">베스트셀러</a></li>
						<li><a href="/bookMarket/product/ITProductView.pd?category=2">컴퓨터,모바일</a></li>
						<li><a href="#">취업 수험서</a></li>
						<li><a href="#">외국어</a></li>
					</ul>
				</div>
			</div>
			
		</div>
	
	