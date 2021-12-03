<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/categoryProdView.css"  rel="stylesheet" type="text/css"/>
	
	<div class="prod_category_box">
		<!-- 상품 상세 카테고리 시작 -->
		<div class="prod_detail_category_box">
			<ul class="prod_detail_category_items">
				<li><a href="#">최신등록순</a> |</li>
				<li><a href="#">누적판매순</a> |</li>
				<li><a href="#">낮은가격순</a> |</li>
				<li><a href="#">리뷰많은순</a> |</li>
			</ul>
		</div>
		<!-- 상품 상세 카테로기 끝 -->
		
		<div class="prod_list_box">
			
		</div>
	</div>
	
<jsp:include page="/layout/footer.jsp"/>