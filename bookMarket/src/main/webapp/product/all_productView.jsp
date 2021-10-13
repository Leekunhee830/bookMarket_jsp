<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath}/css/pd_css/all_product.css"  rel="stylesheet" type="text/css"/>

<jsp:include page="/layout/header.jsp"/>
	
	<div>
		<div class="main">
			<div>
				<h2>전체상품</h2>
			</div>
			<div>
				<ul class="product_ranking row">
					<li><a href="#">누적판매순</a> |</li>
					<li><a href="#">낮은가격순</a> |</li>
					<li><a href="#">최신등록순</a> |</li>
					<li><a href="#">리뷰많은순</a> |</li>
				</ul>
			</div>
			
			<c:choose>
				<c:when test="${requestScope.list ==null}">
					<h1>상품 정보가 없습니다.</h1>
				</c:when>
				<c:otherwise>
					<c:forEach var="dto" items="${requestScope.list}">
						
						<div class="cell">
							<div class="cell_img">
								<a href="SelectProductView.pd?productNum=${dto.pd_num}"><img src="${pageContext.request.contextPath}/upLoadImg/${dto.pd_imgName}" alt="c언어"/></a>
							</div>
							<div class="cell_product_name">
								<a href="#">${dto.pd_name}</a>
							</div>
							<div class="cell_product_price">
								<a href="#">가격:${dto.pd_price}원</a>
							</div>
						</div>
					
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
			
			<div class="cell">
				<div class="cell_img">
					<a href="#"><img src="${pageContext.request.contextPath}/img/all_product_img/k1.jpg" alt="한국사문제집 사진"/></a>
				</div>
				<div class="cell_product_name">
					<a href="#">큰별쌤 최태성의 별별 한국사</a>
				</div>
				<div class="cell_product_price">
					<a href="#">13000원</a>
				</div>
			</div>
			
			<div class="cell">
				<div class="cell_img">
					<a href="#"><img src="${pageContext.request.contextPath}/img/all_product_img/k1.jpg" alt="한국사문제집 사진"/></a>
				</div>
				<div class="cell_product_name">
					<a href="#">큰별쌤 최태성의 별별 한국사</a>
				</div>
				<div class="cell_product_price">
					<a href="#">13000원</a>
				</div>
			</div>
			
			
		
			
			
		</div>
	
	</div>
	
<jsp:include page="/layout/footer.jsp"/>