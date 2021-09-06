<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/joinResult.css"  rel="stylesheet" type="text/css"/>
	
	<div>
		<div class="join_result_wrap">
			<c:choose>
				<c:when test="${requestScope.result}">
					<h1>회원가입을 완료하였습니다.</h1>
				</c:when>
				<c:otherwise>
					<h1>회원가입을 실패하였습니다.</h1>
				</c:otherwise>
			
			</c:choose>
			<div>
				<input type="button" value="메인화면으로 이동하기" class="main_move" onclick="location.href='/bookMarket/index.jsp'">
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>