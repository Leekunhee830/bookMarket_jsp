<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/pd_css/order_prodcutView.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/order_product.js"></script>

<c:set var="dto" value="${requestScope.dto}"/>
<c:remove var="dto" scope="request"/>

	<div class="order_wrap">
		<div class="order_cont">
			<div class="order_form">
				<div><h2>주문 상세내역</h2></div>
				<div>
					<img src="${pageContext.request.contextPath}/upLoadImg/${dto.product_img}"/>
					<h2>제목 : ${dto.product_name }</h2>
				</div>
					<div class="order_font">받으실분</div>
					<div>
						${dto.order_name}
					</div>
					<div class="order_font">휴대폰번호</div>
					<div>
						${dto.order_phone }
					</div>
					<div class="order_font">유선전화</div>
					<div>
						${dto.order_home_phone }
					</div>
					<div class="order_font">주소</div>
					<div>
						${dto.order_address}
					</div>
					<div class="order_font">배송 메시지</div>
					<div>
						${dto.order_message }
					</div>
					<div class="order_font">
						수량
					</div>
					<div>
						${dto.order_amount}
					</div>
					
					<h2>가격 :<div id="order_price" class="order_price">${dto.order_price}</div>원</h2>
					
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>