<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/qna_css/qna.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/qna/qnaWrite.js"></script>
	
	<div class="qna_wrap">
	
		<div>
			<h2>리뷰작성</h2>
		</div>
		
		<div class="qna_title">
			<div class="qna_info_box">
				<div class="qna_name_header">작성자명 : </div>
				<div class="qna_name">${sessionScope.currentName} </div>
				<div class="qna_option">
					<select  id="qna_option">
								<option value="1">배송문의</option>
								<option value="2">상품문의</option>
								<option value="3">기타</option>
					</select>
				</div>
			</div>
			<div class="qna_password_box">
				<div class="qna_password_font">비공개글 작성시 4자 이내로 입력 : </div>
				<div>
					<input type="password" size="4" maxlength="4" id="qna_password"/>
				</div>
			</div>	
		</div>
		
		<textarea id="qna_contents"></textarea>
		
		<button class="qna_upload_btn" onclick="upload('${sessionScope.currentNum}','${requestScope.prod_num}');" >Q&A 등록</button>
		
	</div>

<jsp:include page="/layout/footer.jsp"/>