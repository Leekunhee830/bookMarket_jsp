<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/order_Manager.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/product/manager_product.js"></script>


	<div class="order_wrap">
		
		<div class="order_title"><h2>상품 목록</h2></div>
		
		<c:choose>
			<c:when test="${requestScope.list==null}">
				<h1>등록된 상품이 없습니다.</h1>		
			</c:when>
			
			<c:otherwise>
				<table border="1">
					<tr>
						<th>상품 정보</th>
						<th width="20%">상품 코드</th>
						<th width="20%">상품 이름</th>
						<th width="20%">상품 출판사</th>
						<th width="10%">상품 부류</th>
						<th width="10%">상품 수량</th>
						<th width="10%">상품 가격</th>
						<th>수정/삭제</th>
					</tr>
					<c:forEach var="dto" items="${requestScope.list}">
						<tr>
							<th><a href="/bookMarket/product/SelectProductView.pd?productNum=${dto.pd_num}"><img class="order_img" src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_imgName}"/></a></th>
							<th><div id="pd_code">${dto.pd_code}</div></th>
							<th>${dto.pd_name }</th>
							<th>${dto.pd_manufacturer }</th>
							<th>${dto.pd_category}</th>
							<th>${dto.pd_amount}</th>
							<th>${dto.pd_price}</th>
							<th>
								<input type="button" value="수정">
								<input type="button" value="삭제" onclick="product_delete('${dto.pd_code}','${dto.pd_imgName }')">
							</th>
						</tr>
					</c:forEach>
			  	</table>
			</c:otherwise>
		</c:choose>
	</div>

<jsp:include page="/layout/footer.jsp"/>