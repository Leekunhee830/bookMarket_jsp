<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	int reviewNo=1;
%>
<jsp:include page="/layout/header.jsp"/>

	<link href="${pageContext.request.contextPath}/css/pd_css/select_productView.css"  rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/product/product.js"></script>
	
	<c:set var="pddto" value="${requestScope.pddto}" scope="page"/>

	<div class="select_wrap">
		<div class="select_cont row">

			<div class="cont_left">
				<div class="product_img">
					<img src="${pageContext.request.contextPath}/upLoadImg/${pddto.pd_imgName}"/>
				</div>			
			</div>
			<div class="cont_right">
				<div class="product_font">
					제목: ${pddto.pd_name}
				</div>
				<div class="product_font">
					출판사: ${pddto.pd_manufacturer}
				</div>
				<div class="product_font">
					가격: <fmt:formatNumber value="${pddto.pd_price}" type="number"/>원
				</div>
			</div>
			<div class="btn_wrap">
				<input type="button" value="주문하기" onclick="order_view('${sessionScope.currentNum}','${pddto.pd_num}')"/>
				<input type="button" value="장바구니" onclick="addCart('${pddto.pd_num}')"/>
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
			${pddto.pd_contents}
		</div>
		<div>
			<c:if test="${not empty pddto.pd_imgName2}">
				<img src="${pageContext.request.contextPath}/upLoadImg/${pddto.pd_imgName2}"/>
			</c:if>
			<c:if test="${not empty pddto.pd_imgName3}">
				<img src="${pageContext.request.contextPath}/upLoadImg/${pddto.pd_imgName3}"/>
			</c:if>
			<c:if test="${not empty pddto.pd_imgName4}">
				<img src="${pageContext.request.contextPath}/upLoadImg/${pddto.pd_imgName4}"/>
			</c:if>
		</div>
		<!-- 상품 상세정보 끝 -->
		
		<!-- 리뷰 박스 시작 -->
		<div class="review_box">
			<div class="review_header_box">
				<div>
					<h2>리뷰 (${requestScope.reviewCount})</h2>
				</div>
				<div class="review_header_font">
					<c:if test="${sessionScope.currentId!=null}">
						<a href="${pageContext.request.contextPath}/review/reviewWriteView.rv?prodNum=${pddto.pd_num}" class="review_write">리뷰 작성</a>				
					</c:if>
					<a href="${pageContext.request.contextPath}/review/reviewAllList.rv?prodNum=${pddto.pd_num}">전체 보기</a>
				</div>
			</div>
			<div class="review_item_box">
				<c:if test="${requestScope.reviewList!=null}">
					<c:forEach var="review" items="${requestScope.reviewList}">
						<div class="review_item">
							<div class="review_item_reviewNo"><%=reviewNo %></div>
							<div class="review_item_contents"><a href="${pageContext.request.contextPath}/review/reviewDetail.rv?reviewNum=${review.review_num}">${review.contents}</a></div>
							<div class="review_item_id">${review.user_id}</div>
							<div class="review_item_regdate"><fmt:formatDate value="${review.regdate}" type="date"/></div>
						</div>
						<%reviewNo+=1; %>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<!-- 리뷰 박스 끝 -->
	</div>
	<!-- 하단 박스 끝 -->
<jsp:include page="/layout/footer.jsp"/>