<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/prodListBuy.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/product/order_product.js"></script>

<c:set var="AllPrice" value="0"/>
<c:set var="user" value="${requestScope.userDto}"/>

<div class="order_wrap">
	<h2>주문/결제</h2>
	<!-- 왼쪽 박스 시작 -->
	<div class="order_left_box">
		<!-- 주문정보 입력 박스 시작 -->
		<div class="order_left_box_user_info">
			<div class="order_font">받으실분</div>
			<div>
				${user.user_name}
			</div>
			<div class="order_font">휴대폰번호</div>
			<div>
				${user.user_phone}
			</div>
			<div class="order_font">주소</div>
			<div>
				<input type="text" id="order_zipcode" onclick="search_zipcode()" placeholder="우편번호" required size="6">
				<input type="button" value="우편번호검색" onclick="search_zipcode()">
			</div>
			<div>
				<input type="text" id="order_address" placeholder="주소" required size="50" readonly>
			</div>
			<div>
				<input type="text" id="order_detail_address"  placeholder="상세주소" required size="25">
			</div>
			<div class="order_font">배송 메시지</div>
			<div>
				<input type="text" placeholder="택배 기사님께 전달할 메시지를 남겨주세요." size="50">
			</div>
		</div>
		<!-- 주문정보 입력 박스 끝 -->
		
		<!-- 주문 상품 목록 시작 -->
		<div class="order_left_box_prod_info">
			<h3>배송상품</h3>
			<c:forEach var="prodDto" items="${requestScope.prodList}">
				<div class="order_prod_items">
					<div class="order_prod_img">
						<img src="${pageContext.request.contextPath}/upLoadImg/${prodDto.pd_imgName}"/>
					</div>
					<div class="order_prod_info">
						<div class="order_prod_publisher">${prodDto.pd_manufacturer}</div>
						<div class="order_prod_name">${prodDto.pd_name}</div>
						<div class="order_prod_price"><fmt:formatNumber value="${prodDto.pd_price}" type="number"/></div>	
					</div>
				</div>
				<c:set var="AllPrice" value="${AllPrice+prodDto.pd_price}"/>	
			</c:forEach>
			<div class="order_prod_allPrice_box row">
				<div class="order_prod_allPrice">합계:<fmt:formatNumber value="${AllPrice}" type="number"/>원</div>			
			</div>
		</div>
		<!-- 주문 상품 목록 끝 -->
		
	</div>
	<!-- 왼쪽 박스 끝 -->
	
	<!-- 오른쪽 박스 시작 -->
	<div class="order_right_box">
		<div class="order_right_box_items">
			<h3>결재 금액</h3>
			<div class="order_right_box_list">
				<div>총 상품 금액</div>
				<div><fmt:formatNumber value="${AllPrice}"/>원</div>
			</div>
			<div class="order_right_box_list">
				<div>배송비</div>
				<div>0원</div>
			</div>
			<div class="border_top_1 order_right_box_list">
				<div>총 결제 예상 금액</div>
				<div><fmt:formatNumber value="${AllPrice+0}"/>원</div>
			</div>	
		</div>
		<button class="allPrice_buy_btn">구매하기</button>
	</div>
	<!-- 오른쪽 박스 끝 -->
</div>


<jsp:include page="/layout/footer.jsp"/>