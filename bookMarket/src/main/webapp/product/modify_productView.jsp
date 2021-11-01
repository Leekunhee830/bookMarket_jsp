<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/layout/header.jsp"/>
	
	<link href="${pageContext.request.contextPath}/css/pd_css/add_productView.css"  rel="stylesheet" type="text/css"/>
	
	<c:set var="dto" value="${requestScope.dto}"/>
	<c:remove var="dto" scope="request"/>
	
	<div class="add_wrap">
		<div class="add_cont">
			<div class="add_form">
			<form action="AddProduct.pd" method="post" enctype="multipart/form-data">
				<h2>상품수정</h2>
				<div class="add_font">상품 코드</div>	
				<div>
					<input type="text" name="pd_code" value="${dto.pd_code}">
				</div>
				<div class="add_font">상품 이름</div>	
				<div>
					<input type="text" name="pd_name" value="${dto.pd_name}">
				</div>
				<div class="add_font">상품 소개</div>	
				<div>
					<textarea name="pd_contents">${dto.pd_contents}</textarea>
				</div>
				<div class="add_font">상품 가격</div>	
				<div>
					<input type="text" name="pd_price" value="${dto.pd_price }">
				</div>
				<div class="add_font">상품 갯수</div>	
				<div>
					<input type="text" name="pd_amount" value="${dto.pd_amount }">
				</div>
				<div class="add_font">상품 분류</div>	
				<div>
					<select name="pd_category">
							<option value="">==선택==</option>
							<option value="language">외국어</option>
							<option value="IT">컴퓨터,모바일</option>
					</select>
				</div>
				<div class="add_font">상품 제조사</div>		
				<div>
					<input type="text" name="pd_manufacturer" value="${dto.pd_manufacturer}">
				</div>
				<div class="add_font">상품 이미지</div>
				<div>
					<input type="file" name="pd_img">
				</div>
				<div class="add_submit">
					<input type="submit" value="상품 등록">
				</div>
			</form>
			</div>
		</div>
	</div>
	
<jsp:include page="/layout/footer.jsp"/>