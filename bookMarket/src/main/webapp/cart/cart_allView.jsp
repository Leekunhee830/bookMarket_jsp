<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/cart_css/cart.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/product/product.js"></script>


	<div class="cart_wrap">
	<!-- 장바구니 리스트 시작 -->
		<c:choose>
			<c:when test="${requestScope.list==null}">
				<h1 class="empty_font">장바구니에 담긴 상품이 없습니다.</h1>		
			</c:when>
			
			<c:otherwise>
				<div class="cart_title"><h2>장바구니</h2></div>
				<table border="1">
					<tr>
						<th><input type="checkbox"></th>
						<th>상품 이미지</th>
						<th width="20%">상품 이름</th>
						<th width="30%">출판사</th>
						<th width="30%">상품 가격</th>
					</tr>
					<c:forEach var="dto" items="${requestScope.list}">
						<tr>
							<th><input type="checkbox"></th>
							<th>
								<a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.pd_num}">
									<img class="cart_img" src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_img}"/>
								</a>
							</th>
							<th><a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.pd_num}">${dto.pd_name}</a></th>
							<th>${dto.pd_manufacturer}</th>
							<th>
								<span>${dto.pd_price}</span>원
								<div><input type="button" value="주문하기" onclick="order_view('${sessionScope.currentNum}','${dto.pd_num}')"></div>
							</th>
						</tr>
					</c:forEach>
			  	</table>
			</c:otherwise>
		</c:choose>
	<!-- 장바구니 리스트 끝 -->
	
	<!-- 장바구니 총 금액 시작 -->
		<div class="cart_price_manager">
			<div class="cart_price_hap">
				<h2>총 금액:</h2>
				<h2>0</h2><h2>원</h2>
			</div>
		</div>
	<!-- 장바구니 총 금액 끝 -->
	</div>

<jsp:include page="/layout/footer.jsp"/>