<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/pd_css/order_prodcutView.css"  rel="stylesheet" type="text/css"/>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/addressDaum.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/order_product.js"></script>

<c:set var="pdto" value="${requestScope.pdto}" scope="page"/>
<c:set var="mdto" value="${requestScope.mdto}" scope="page"/>

	<div class="order_wrap">
		<div class="order_cont">
			<div class="order_form">
				<div><h2>주문 페이지</h2></div>
				<div class="order_product_img">
					<img src="${pageContext.request.contextPath}/upLoadImg/${pdto.pd_imgName}"/>
					<h2>제목 : ${pdto.pd_name }</h2>
				</div>
				<form action="OrderProduct.pd" method="post" id="order_submit">
					<input type="hidden" name="user_num" value="${mdto.num}">
					<input type="hidden" name="user_id" value="${mdto.id}">
					<input type="hidden" name="user_email" value="${mdto.email}">					
					<input type="hidden" name="product_num" value="${param.pd_num}">
					<input type="hidden" name="product_name" value="${param.pd_name}">
					<input type="hidden" name="product_img" value="${param.pd_imgName}">
					<input type="hidden" name="order_amount" value="">
					<input type="hidden" name="order_price" value="">
					
					<div class="order_font">받으실분</div>
					<div>
						<input type="text" id="order_name" name="order_name" required>
					</div>
					<div class="order_font">휴대폰번호</div>
					<div>
						<select name="order_phone1" id="order_phone1">
							<option value="010">010</option>
							<option value="070">070</option>
							<option value="011">011</option>
						</select>
						-
						<input type="text" name="order_phone2" id="order_phone2" required size="5" maxlength='4'>
						-
						<input type="text" name="order_phone3" id="order_phone3" required size="5" maxlength='4'>
					</div>
					<div class="order_font">유선전화</div>
					<div>
						<select name="order_home_phone1" id="order_home_phone1">
							<option value="02">02</option>
							<option value="042">042</option>
							<option value="044">044</option>
							<option value="051">044</option>
						</select>
						-
						<input type="text" name="order_home_phone2" id="order_home_phone2" required size="5" maxlength='4'>
						-
						<input type="text" name="order_home_phone3" id="order_home_phone3" required size="5" maxlength='4'>
					</div>
					<div class="order_font">주소</div>
					<div>
						<input type="text" id="order_zipcode" onclick="search_zipcode()" name="order_zipcode" placeholder="우편번호" required size="6">
						<input type="button" value="우편번호검색" onclick="search_zipcode()">
					</div>
					<div>
						<input type="text" id="order_address" name="order_address" placeholder="주소" required size="50" readonly>
					</div>
					<div>
						<input type="text" id="order_detail_address" name="order_detail_address" placeholder="상세주소" required size="25">
					</div>
					<div class="order_font">배송 메시지</div>
					<div>
						<input type="text" name="order_message" placeholder="택배 기사님께 전달할 메시지를 남겨주세요." size="50">
					</div>
					<div class="order_font">
						수량
					</div>
					<div>
						<input type="button" id="count_minus" class="count_button" value="-">
						<div id="order_count" class="order_count">1</div>
						<input type="button" id="count_plus" class="count_button" value="+">
					</div>
					
					<h2>가격 :<div id="order_price" class="order_price">${pdto.pd_price}</div></h2>
					
					<div class="order_submit">
						<input type="button" id="order_btn" value="주문하기"/>
					</div>
				</form>
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>