<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/order_Manager.css"  rel="stylesheet" type="text/css"/>



	<div class="order_wrap">
		<c:choose>
			<c:when test="${requestScope.list==null}">
				<h1>장바구니에 담긴 상품이 없습니다.</h1>		
			</c:when>
			
			<c:otherwise>
				<div class="order_title"><h2>장바구니</h2></div>
				<table border="1">
					<tr>
						<th>이미지</th>
						<th width="20%">상품 이름</th>
						<th width="30%">출판사</th>
						<th width="30%">상품 가격</th>
					</tr>
					<c:forEach var="dto" items="${requestScope.list}">
						<tr>
							<th><a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.pd_num}"><img class="order_img" src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_img}"/></a></th>
								<th><a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.pd_num}">${dto.pd_name}</a></th>
								<th>${dto.pd_manufacturer}</th>
								<th>${dto.pd_price}</th>
						</tr>
					</c:forEach>
			  	</table>
			</c:otherwise>
		</c:choose>
	</div>

<jsp:include page="/layout/footer.jsp"/>