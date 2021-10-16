<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

	<link href="${pageContext.request.contextPath}/css/pd_css/select_productView.css"  rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/select_product.js"></script>
	
	<c:set var="dto" value="${requestScope.dto}" scope="page"/>
	<c:remove var="dto" scope="request"/>

	<div class="select_wrap">
		<div class="select_cont row">
			<input type="hidden" id="user_id" value="${sessionScope.currentId}">
			<input type="hidden" id="product_num" value="${dto.pd_num}">
			<input type="hidden" id="product_imgName" value="${dto.pd_imgName}">
			<input type="hidden" id="product_name" value="${dto.pd_name}">
			<input type="hidden" id="product_price" value="${dto.pd_price}">
			<div class="cont_left">
				<div class="product_img">
					<img src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_imgName}" alt="c언어"/>
				</div>			
			</div>
			<div class="cont_right">
				<div class="product_font">
					제목: ${dto.pd_name}
				</div>
				<div class="product_font">
					출판사: ${dto.pd_manufacturer}
				</div>
				<div class="product_font">
					책 소개: ${dto.pd_contents}				
				</div>
				<div class="product_font">
					가격: ${dto.pd_price}원
				</div>
			</div>
			<div class="btn_wrap">
				<input type="button" id="order_btn" value="주문하기"/>
				<input type="button" value="장바구니"/>
			</div>
		</div>
	</div>


<jsp:include page="/layout/footer.jsp"/>