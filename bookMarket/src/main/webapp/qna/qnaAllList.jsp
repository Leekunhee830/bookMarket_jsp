<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%int qnaNo=1; %>

<c:set var="pdDto" value="${requestScope.pdDto}" scope="page"></c:set>

<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/review_css/reviewAllList.css"  rel="stylesheet" type="text/css"/>

<div class="frame">
	
	<!-- 상품 정보 시작 -->
	<div class="review_prod">현재 보고 있는 상품</div>
	<div class="review_prod_box">
		<div class="review_prod_img"><img src="${pageContext.request.contextPath}/upLoadImg/${pdDto.pd_imgName}"/></div>
		<div class="review_prod_info">
			<div class="review_prod_publisher">${pdDto.pd_manufacturer}</div>
			<div class="review_prod_prodname">${pdDto.pd_name}</div>
		</div>
	</div>
	<!-- 상품 정보 끝 -->
	
	<!-- Q&A 목록 시작 -->
	<div class="review_all_item_box">
		<h2 class="review_font">Q & A</h2>
		<c:choose>
			<c:when test="${requestScope.qnaList!=null}">
				<c:forEach var="qna" items="${requestScope.qnaList}">
					<div class="review_all_item">
						<div class="review_all_item_reviewNo"><%=qnaNo %></div>
						<c:choose>
							<c:when test="${empty qna.qna_password}">
								<div class="review_all_item_contents"><a href="${pageContext.request.contextPath}/qna/qnaDetail.qna?qnaNum=${qna.qna_num}">${qna.contents}</a></div>
							</c:when>
							<c:otherwise>
								<div class="review_all_item_contents"><a href="${pageContext.request.contextPath}/qna/qnaDetail.qna?qnaNum=${qna.qna_num}">비밀글입니다.</a></div>
							</c:otherwise>
						</c:choose>
						<div class="review_all_item_id">${qna.user_id}</div>
						<div class="review_all_item_regdate"><fmt:formatDate value="${qna.regdate}" type="date"/></div>
					</div>
					<%qnaNo+=1; %>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="non-review">
					<h1>해당 상품 Q&A가 없습니다.</h1>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- Q&A 목록 끝 -->
</div>

<jsp:include page="/layout/footer.jsp"/>