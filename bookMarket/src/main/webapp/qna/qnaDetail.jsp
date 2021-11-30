<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="dto" value="${requestScope.dto}" scope="page"></c:set>
<c:set var="currentId" value="${sessionScope.currentId}" scope="page"></c:set>

<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/review_css/reviewWrite.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/review/reviewWrite.js"></script>

	<div class="review_detail_wrap">
		<div class="review_detail_info">
			<div>
				<span class="review_detail_info_writer"><span>작성자:</span>${dto.user_id}</span>
				<span class="review_detail_info_regdate"><span>작성일:</span><fmt:formatDate value="${dto.regdate}" type="date"/></span>
			</div>
			<div>
				<c:if test="${dto.user_id==currentId}">
					<button type="button" onclick="review_delete('${dto.qna_num}')" class="review_delete">삭제</button>				
				</c:if>
			</div>
			
		</div>
		<div class="review_detail_contents">
			<span>${dto.contents}</span>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>