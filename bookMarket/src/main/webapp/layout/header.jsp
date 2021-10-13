<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${pageContext.request.contextPath}/css/header.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
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
							<li><a href="/bookMarket/logout.do">로그아웃</a></li>
							<li><a href="/bookMarket/mypage/mypage.do">마이페이지</a></li>
							<c:if test="${sessionScope.currentId=='admin' }">
								<li><a href="/bookMarket/product/add_productView.jsp">상품 등록</a></li>
							</c:if>
						</c:otherwise>
						
					</c:choose>
						<li><a href="#">장바구니</a></li>
						<li><a href="#">고객센터</a></li>
					</ul>
				</div>
			</div>
			
			<div class="header_search">
				<div class="header_search_cont">
					<div class="logo">
						<a href="/bookMarket/index.jsp">Book Market</a>
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
						<li><a href="/bookMarket/product/AllProductView.pd">전체상품</a></li>
						<li><a href="#">베스트셀러</a></li>
						<li><a href="#">취업 수험서</a></li>
						<li><a href="#">컴퓨터,모바일</a></li>
						<li><a href="#">외국어</a></li>
					</ul>
				</div>
			</div>
			
		</div>
	
	