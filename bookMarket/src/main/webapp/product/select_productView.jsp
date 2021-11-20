<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/layout/header.jsp"/>

	<link href="${pageContext.request.contextPath}/css/pd_css/select_productView.css"  rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/product/product.js"></script>
	
	<c:set var="dto" value="${requestScope.dto}" scope="page"/>

	<div class="select_wrap">
		<div class="select_cont row">

			<div class="cont_left">
				<div class="product_img">
					<img src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_imgName}"/>
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
					가격: <fmt:formatNumber value="${dto.pd_price}" type="number"/>원
				</div>
			</div>
			<div class="btn_wrap">
				<input type="button" value="주문하기" onclick="order_view('${sessionScope.currentNum}','${dto.pd_num}')"/>
				<input type="button" value="장바구니" onclick="addCart('${dto.pd_num}')"/>
			</div>
		</div>
	</div>
	
	<!-- 하단 박스 시작 -->
	<div class="wrap_detail_info">
		<!-- 상품정보/리뷰/Q&A/주문정보 시작 -->
		<div class="tab_detail_info row">
			<ul class="tab">
				<li><a href="#">상품상세정보</a></li>
				<li><a href="#">리 뷰</a></li>
				<li><a href="#">Q & A</a></li>
				<li><a href="#">반품/교환</a></li>
			</ul>
		</div>
		<!-- 상품정보/리뷰/Q&A 끝 -->
	
		<!-- 상품 상세정보 시작 -->
		<div>
			<h2>상품상세정보</h2>
		</div>
		<div>
			${dto.pd_contents}
		</div>
		<div>
			<c:if test="${not empty dto.pd_imgName2}">
				<img src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_imgName2}"/>
			</c:if>
			<c:if test="${not empty dto.pd_imgName3}">
				<img src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_imgName3}"/>
			</c:if>
			<c:if test="${not empty dto.pd_imgName4}">
				<img src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_imgName4}"/>
			</c:if>
		</div>
		<!-- 상품 상세정보 끝 -->
		
		<!-- 리뷰 박스 시작 -->
		<div class="review_box">
			<div>
				리뷰
				<c:if test="${sessionScope.currentId!=null}">
					<a href="${pageContext.request.contextPath}/review/reviewWrite.rv?prodNum=${dto.pd_num}">리뷰 작성</a>				
				</c:if>
				<a href="#">전체 보기</a>
			</div>
			<div>
				<!-- 리뷰 목록 -->
			</div>
		</div>
		<!-- 리뷰 박스 끝 -->
	</div>
	<!-- 하단 박스 끝 -->
<jsp:include page="/layout/footer.jsp"/>