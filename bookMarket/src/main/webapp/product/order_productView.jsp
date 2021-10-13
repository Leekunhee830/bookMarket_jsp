<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/pd_css/order_prodcutView.css"  rel="stylesheet" type="text/css"/>

	<div class="order_wrap">
		<div class="order_cont">
			<div class="order_form">
				<div><h2>주문 페이지</h2></div>
				<form action="" method="post">
					<div class="order_font">받으실분</div>
					<div>
						<input type="text" name="order_name" required>
					</div>
					<div class="order_font">휴대폰번호</div>
					<div>
						<select name="order_phone1" id="user_phone1">
							<option value="010">010</option>
							<option value="070">070</option>
							<option value="011">011</option>
						</select>
						-
						<input type="text" name="order_phone2" required size="5" maxlength='4'>
						-
						<input type="text" name="order_phone3" required size="5" maxlength='4'>
					</div>
					<div class="order_font">유선전화(선택)</div>
					<div>
						<select name="order_home_phone1" id="user_phone1">
							<option value="02">02</option>
							<option value="042">042</option>
							<option value="044">044</option>
							<option value="051">044</option>
						</select>
						-
						<input type="text" name="order_home_phone2" required size="5" maxlength='4'>
						-
						<input type="text" name="order_home_phone3" required size="5" maxlength='4'>
					</div>
					<div class="order_font">주소</div>
					<div>
						<input type="text" name="order_zipCode" required>
						<input type="button" value="우편번호검색">
					</div>
					<div>
						<input type="text" name="order_address" required size="50">
					</div>
					<div>
						<input type="text" name="order_detail_address" required size="50">
					</div>
					<div class="order_font">배송 메시지</div>
					<div>
						<input type="text" name="order_message" placeholder="택배 기사님께 전달할 메시지를 남겨주세요." size="50">
					</div>
					
					
					<div class="order_submit">
						<input type="button" value="주문하기""/>
					</div>
				</form>
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>