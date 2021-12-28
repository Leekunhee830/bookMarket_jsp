<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
	
	<link href="${pageContext.request.contextPath}/css/pd_css/add_productView.css"  rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/product/product.js"></script>
	
	<div class="add_wrap">
		<div class="add_cont">
			<div class="add_form">
			<form action="AddProduct.pd" method="post" enctype="multipart/form-data" id="addPd_submit">
				<h2>상품수정</h2>
				<div class="add_font">상품 코드</div>	
				<div>
					<input type="text" name="pd_code" id="pd_code">
				</div>
				<div class="add_font">상품 이름</div>	
				<div>
					<input type="text" name="pd_name" id="pd_name">
				</div>
				<div class="add_font">상품 소개</div>	
				<div>
					<textarea name="pd_contents" id="pd_contents"></textarea>
				</div>
				<div class="add_font">상품 가격</div>	
				<div>
					<input type="text" name="pd_price" id="pd_price">
				</div>
				<div class="add_font">상품 갯수</div>	
				<div>
					<input type="text" name="pd_amount" id="pd_amount">
				</div>
				<div class="add_font">상품 분류</div>	
				<div>
					<select name="pd_category" id="pd_category">
							<option value="">==선택==</option>
							<option value="2">컴퓨터,모바일</option>
							<option value="3">외국어</option>
					</select>
				</div>
				<div class="add_font">상품 제조사</div>		
				<div>
					<input type="text" name="pd_manufacturer" id="pd_manufacturer">
				</div>
				<div class="add_font">상품 이미지(필수)</div>
				<div>
					<input type="file" name="pd_img" id="pd_img">
				</div>
				<div class="add_font">추가 상품 이미지2</div>
				<div>
					<input type="file" name="pd_img2">
				</div>
				<div class="add_font">추가 상품 이미지3</div>
				<div>
					<input type="file" name="pd_img3">
				</div>
				<div class="add_font">추가 상품 이미지4</div>
				<div>
					<input type="file" name="pd_img4">
				</div>
				
				<div class="add_submit">
					<input type="button" value="상품 등록" onclick="product_Check(0)">
				</div>
			</form>
			</div>
		</div>
	</div>
	
<jsp:include page="/layout/footer.jsp"/>
	