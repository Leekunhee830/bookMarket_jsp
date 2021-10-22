<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/order_Manager.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/order_product.js"></script>


	<div class="order_wrap">
		
		<div class="order_title"><h2>결제 내역</h2></div>
		
		<c:choose>
			<c:when test="${requestScope.list==null}">
				<h1>결제 내역이 없습니다.</h1>		
			</c:when>
			
			<c:otherwise>
				<table border="1">
					<tr>
						<th>상품 정보</th>
						<th width="20%">주문 번호</th>
						<th width="20%">상품 이름</th>
						<th width="20%">구매일</th>
						<th width="10%">수량</th>
						<th width="10%">총 결제</th>
						<th width="10%">처리 상태</th>
					</tr>
					<c:forEach var="dto" items="${requestScope.list}">
						<tr>
							<th><a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.product_num}"><img class="order_img" src="${pageContext.request.contextPath}/upLoadImg/${dto.product_img}"/></a></th>
								<th><a href="#" class="order_num">${dto.order_num}</a></th>
								<th><a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.product_num}">${dto.product_name }</a></th>
								<th>${dto.regdate }</th>
								<th>${dto.order_amount }</th>
								<th>${dto.order_price}</th>
								<c:choose>
									<c:when test="${dto.order_result}==0">
										<th>배송완료</th>
									</c:when>
									<c:otherwise>
										<th>배송중</th>
									</c:otherwise>
								</c:choose>
						</tr>
					</c:forEach>
			  	</table>
			</c:otherwise>
		</c:choose>
	</div>

<jsp:include page="/layout/footer.jsp"/>