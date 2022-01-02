<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="dto" value="${requestScope.dto}" scope="page"></c:set>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/member_css/order.css"  rel="stylesheet" type="text/css"/>

	<div class="order_wrap">
		<h1>주문상세 정보</h1>
		<!-- 주문타이틀시작 -->
		<div class="order_info_top_box flex_apply">
			<div>주문일자: <fmt:formatDate value="${dto.regdate}"/></div>
			<div>주문번호: ${dto.order_num}</div>
			<div>배송상태: 
				<c:choose>
					<c:when test="${dto.order_result eq 0}">
						<th>결제중</th>
					</c:when>
					<c:when test="${dto.order_result eq 1}">
						<th>결재완료</th>
					</c:when>
					<c:when test="${dto.order_result eq 2}">
						<th>배송중</th>
					</c:when>
					<c:when test="${dto.order_result eq 3}">
						<th>배송 완료</th>
					</c:when>
				</c:choose>
			</div>
		</div>
		<!-- 주문타이틀 끝 -->
		
		<div class="flex_apply order_info_box">
		<!-- 결제정보시작 -->
			<div class="order_info_left_box">
				<h2>주문/결제 정보</h2>
				<div class="flex_apply">
					<div class="order_info_left_box_prod">
						<img src="${pageContext.request.contextPath}/upLoadImg/${dto.product_img}"/>
					</div>
					<div class="order_info_left_box_prodInfo">
						<div class="order_info_left_box_prodInfo_font">
							상품명: ${dto.product_name}
						</div>
						<div class="order_info_left_box_prodInfo_font">
							상품금액: ${dto.order_price}
						</div>
						<div class="order_info_left_box_prodInfo_font">
							배송비: 0원
						</div>
						<div class="order_info_left_box_prodInfo_font all_price">
							총 결제: <fmt:formatNumber value="${dto.order_price}" type="number"/>
						</div>
					</div>
				</div>
			</div>
		<!-- 결제정보 끝  -->
			
		<!-- 배송지정보 시작 -->
			<div class="order_info_right_box">
				<div class="order_info_right_box_orderInfo">
					<h2>배송지 정보</h2>
					<div class="order_info_right_box_font">수령인: ${dto.order_name }</div>
					<div class="order_info_right_box_font">연락처: ${dto.order_phone }</div>
					<div class="order_info_right_box_font">배송지: ${dto.order_address }</div>
					<div class="order_info_right_box_font">배송메모: ${dto.order_message }</div>
				</div>
			</div>
		<!-- 배송지정보 끝 -->
		</div>
	</div>
<jsp:include page="/layout/footer.jsp"/>

