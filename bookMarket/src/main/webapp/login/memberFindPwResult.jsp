<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/memberFindIdResult.css"  rel="stylesheet" type="text/css"/>
	
	<div class="find_cont">
		<div class="find_form">
			<c:choose>
				<c:when test="${requestScope.result}">
					<h2>이메일로 임시번호를 전송하였습니다.</h2>
				</c:when>
				<c:otherwise>
					<h2>아이디 혹은 이메일을 다시 확인해주세요.</h2>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
<jsp:include page="/layout/footer.jsp"/>