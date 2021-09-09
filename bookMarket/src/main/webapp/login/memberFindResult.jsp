<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/memberFindResult.css"  rel="stylesheet" type="text/css"/>
	
	<div class="find_cont">
		<div class="find_form">
			<c:choose>
				<c:when test="${requestScope.find_id==null}">
					<h2>찾으시는 ID는존재하지 않습니다.</h2>
				</c:when>
				<c:otherwise>
					<h2>고객님의 ID는 다음과 같습니다.</h2>
					<c:forEach var="user_id" items="${requestScope.find_id }">
						<div class="find_id_font">${user_id}</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
<jsp:include page="/layout/footer.jsp"/>