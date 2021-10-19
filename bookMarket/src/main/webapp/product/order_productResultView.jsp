<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/order_productResult.css"  rel="stylesheet" type="text/css"/>
	
	<div class="order_result_wrap">
		<div class="order_result_cont">
			<c:choose>
				<c:when test="${requestScope.result}">
					<h1>고객님의 주문이<br/> 정상적으로 완료되었습니다.</h1>
					<div class="order_num_font">주문번호:${requestScope.order_num}</div>
				</c:when>
				<c:otherwise>
					<h1>고객님의 주문이 실패하였습니다.</h1>
				</c:otherwise>
			
			</c:choose>
			<div>
				<input type="button" value="메인화면으로 이동하기" class="main_move" onclick="location.href='/bookMarket/index.jsp'">
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>