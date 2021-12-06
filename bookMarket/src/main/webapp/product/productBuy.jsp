<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/order_prodcutView.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/product/order_product.js"></script>

<c:set var="pdto" value="${requestScope.pdto}" scope="page"/>
<c:set var="mdto" value="${requestScope.mdto}" scope="page"/>

<div>
	<!-- 주문정보 입력 박스 시작 -->
	<div>
		
	</div>
	<!-- 주문정보 입력 박스 끝 -->
	
	<div></div>
</div>

<jsp:include page="/layout/footer.jsp"/>