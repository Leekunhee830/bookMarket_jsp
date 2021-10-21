<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/order_Manager.css"  rel="stylesheet" type="text/css"/>


	<div class="order_wrap">
		<table border="1">
			<tr>
				<th>상품 정보</th>
				<th width="20%">주문 번호</th>
				<th width="15%">상품 이름</th>
				<th width="20%">구매일</th>
				<th width="15%">총 결재</th>
			</tr>
			<c:forEach var="dto" items="${requestScope.list}">
				<tr>
					<th><img class="order_img" src="${pageContext.request.contextPath}/upLoadImg/${dto.product_img}"/></th>
					<th>${dto.order_num}</th>
					<th>${dto.product_name }</th>
					<th>${dto.regdate }</th>
					<th>${dto.order_price }</th>
				</tr>
			</c:forEach>
		</table>
	</div>




	
<jsp:include page="/layout/footer.jsp"/>