<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/order_Manager.css"  rel="stylesheet" type="text/css"/>

	<div class="order_wrap">	
		<c:choose>
			<c:when test="${requestScope.list==null}">
				<h1 class="empty_font">결제 내역이 없습니다.</h1>		
			</c:when>
			
			<c:otherwise>
				<div class="order_title"><h2>결제 내역</h2></div>
				<table border="1">
					<tr>
						<th>상품 정보</th>
						<th width="20%">주문 번호</th>
						<th width="20%">상품 이름</th>
						<th width="20%">구매일</th>
						<th width="10%">총 결제</th>
						<th width="10%">처리 상태</th>
					</tr>
					<c:forEach var="dto" items="${requestScope.list}">
						<tr>
							<th><a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.prod_num}"><img class="order_img" src="${pageContext.request.contextPath}/upLoadImg/${dto.prod_img}"/></a></th>
								<th><a href="/bookMarket/product/OrderDetail.pd?orderNum=${dto.order_num}" class="order_num">${dto.order_num}</a></th>
								<th><a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.prod_num}">${dto.prod_name }</a></th>
								<th><fmt:formatDate value="${dto.regdate}"/></th>
								<th><fmt:formatNumber value="${dto.order_price}" type="number"/>원</th>
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
						</tr>
					</c:forEach>
			  	</table>
			</c:otherwise>
		</c:choose>
	</div>

<jsp:include page="/layout/footer.jsp"/>