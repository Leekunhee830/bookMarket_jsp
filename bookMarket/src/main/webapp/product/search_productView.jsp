<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/categoryProdView.css"  rel="stylesheet" type="text/css"/>
	
	<div class="prod_category_box">
		
		<div>
			<h1>상품 검색</h1>
		</div>
		
		<!-- 상품 상세 카테고리 시작 -->
		<div class="prod_detail_category_box">
			<ul class="prod_detail_category_items">
				<li><a href="#">최신등록순</a> |</li>
				<li><a href="#">누적판매순</a> |</li>
				<li><a href="#">낮은가격순</a> |</li>
				<li><a href="#">리뷰많은순</a> |</li>
			</ul>
		</div>
		<!-- 상품 상세 카테로기 끝 -->
		
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
	
<jsp:include page="/layout/footer.jsp"/>