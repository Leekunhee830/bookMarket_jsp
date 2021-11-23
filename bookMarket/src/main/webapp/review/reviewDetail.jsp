<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="dto" value="${requestScope.dto}" scope="page"></c:set>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/review_css/reviewWrite.css"  rel="stylesheet" type="text/css"/>

	<div class="review_detail_wrap">
		<div class="review_detail_info">
			<span class="review_detail_info_writer"><span>작성자:</span>${dto.user_id}</span>
			<span class="review_detail_info_regdate"><span>작성일:</span>${dto.regdate}</span>
		</div>
		<div class="review_detail_contents">
			${dto.contents}
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>