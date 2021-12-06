<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/cart_css/cart.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/product/product.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cart/cart.js"></script>


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
						<th>상품 이미지</th>
						<th width="20%">상품 이름</th>
						<th width="30%">출판사</th>
						<th width="30%">상품 가격</th>
					</tr>
					<c:forEach var="dto" items="${requestScope.list}">
						<tr>
							<th>
								<a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.pd_num}">
									<img class="cart_img" src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_img}"/>
								</a>
							</th>
							<th><a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.pd_num}">${dto.pd_name}</a></th>
							<th>${dto.pd_manufacturer}</th>
							<th>
								<span><fmt:formatNumber value="${dto.pd_price}" type="number" />원</span>
								<div><input type="button" value="주문하기" onclick="order_view('${sessionScope.currentNum}','${dto.pd_num}')"></div>
							</th>
							<th><button type="button" class="cart_table_delete" onclick="delete_cart('${sessionScope.currentNum}','${dto.pd_num}')"></button></th>
						</tr>
						<c:set var="cartProdCount" value="${cartProdCount+1}"/>
						<c:set var="cartAllPrice" value="${cartAllPrice+dto.pd_price}"/>
					</c:forEach>
			  	</table>
			</c:otherwise>
		</c:choose>
	<!-- 장바구니 리스트 끝 -->
	
	<!-- 장바구니 총 금액 시작 -->
		<div class="cart_price_manager row">
			<div class="cart_left_box">
				<ul class="cart_left_box_ul">
					<li class="cart_left_box_li">
						<span>상품수</span>
						<span>${cartProdCount} 개</span>
					</li>
					<li class="cart_left_box_li">
						<span>상품금액</span>
						<span><fmt:formatNumber value="${cartAllPrice}" type="number" /> 원</span>
					</li>
					<li class="cart_left_box_li">
						<span>할인금액</span>
						<span>0 원</span>
					</li>
					<li class="cart_left_box_li">
						<span>총 배송비</span>
						<span>0 원</span>
					</li>
				</ul>
			</div>
			<div class="cart_right_box">
				<div class="cart_right_box_div">
					<h2>총 금액:</h2>
					<h2><fmt:formatNumber value="${cartAllPrice}" type="number"/> 원</h2>
				</div>
			</div>
		</div>
	<!-- 장바구니 총 금액 끝 -->
	
	<!-- 장바구니 구매 시작 -->
		<div class="cart_buy_btn_box">
			<button class="cart_buy_btn" onclick="location.href='${pageContext.request.contextPath}/cart/cartAllBuy.ct?userNum='+${sessionScope.currentNum};">구매하기 ${cartProdCount}</button>
		</div>
	<!-- 장바구니 구매 끝 -->
	</div>

<jsp:include page="/layout/footer.jsp"/>