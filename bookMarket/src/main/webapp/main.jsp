<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/main.css"  rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/pd_css/categoryProdView.css"  rel="stylesheet" type="text/css"/>

	<div>
		<div class="main">
		
			<!--  메인 slick slider 시작 -->
			<div class="slick_slider" id="slick_slider">
			  <div><img src="${pageContext.request.contextPath}/img/main01.jpg" alt="메인사진"/></div>
			  <div><img src="${pageContext.request.contextPath}/img/main02.jpg" alt="메인사진2"/></div>
			</div>
			<!--  메인 slick slider 끝 -->
			
			<!-- 상품 목록 시작 -->
			<c:choose>
				<c:when test="${requestScope.list ==null}">
					<h1>상품 정보가 없습니다.</h1>
				</c:when>
				<c:otherwise>
					<div class="prod_list_box">
						<c:forEach var="dto" items="${requestScope.list}">
							<div class="prod_list_item">
								<div class="prod_list_item_img">
									<a href="SelectProductView.pd?productNum=${dto.pd_num}"><img src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_imgName}" alt="${dto.pd_name}"/></a>
								</div>
								<div class="prod_list_item_publisher">
									<a href="#">${dto.pd_manufacturer}</a>
								</div>
								<div class="prod_list_item_name">
									<a href="#">${dto.pd_name }</a>
								</div>
								<div class="prod_list_item_price">
									가격:<a href="#"><fmt:formatNumber value="${dto.pd_price}" type="number"/></a>원
								</div>
							</div>
						</c:forEach>
					</div>
				</c:otherwise>
			</c:choose>
		<!-- 상품 목록 끝 -->
			
		</div>
	</div>
	
<jsp:include page="/layout/footer.jsp"/>