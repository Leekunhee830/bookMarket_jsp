<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/member_css/modifyResultView.css"  rel="stylesheet" type="text/css"/>
	
	<div class="modify_result_wrap">
		<div class="modify_result_cont">
			<c:choose>
				<c:when test="${requestScope.result}">
					<h1>비밀번호 변경을 완료하였습니다.</h1>
				</c:when>
				<c:otherwise>
					<h1>비밀번호 변경을 실패하였습니다.</h1>					
				</c:otherwise>
			
			</c:choose>
			<div>
				<input type="button" value="메인화면으로 이동하기" class="main_move" onclick="location.href='/bookMarket/index.jsp'">
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>