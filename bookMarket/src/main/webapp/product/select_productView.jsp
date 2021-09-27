<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

	<link href="${pageContext.request.contextPath}/css/pd_css/select_productView.css"  rel="stylesheet" type="text/css"/>
	<c:set var="dto" value="${requestScope.dto}" scope="page"/>
	<c:remove var="dto" scope="request"/>

	<div class="select_wrap">
		<div class="select_cont">
			<div>
				<img src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_imgName}" alt="c언어"/>
			</div>
		</div>
	</div>


<jsp:include page="/layout/footer.jsp"/>