<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/review_css/reviewWrite.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/review/reviewWrite.js"></script>
	
	<div class="review_wrap">
	
		<div>
			<h2>리뷰작성</h2>
		</div>
		
		<div class="review_title">
			<div class="review_name_header">작성자명 :</div>
			<div class="review_name">${sessionScope.currentName}</div>
		</div>
		
		<textarea id="review_contents"></textarea>
		
		
		<button class="review_upload_btn" onclick="upload('${sessionScope.currentNum}','${requestScope.prod_num}');" >리뷰 등록</button>
		
	</div>

<jsp:include page="/layout/footer.jsp"/>
	