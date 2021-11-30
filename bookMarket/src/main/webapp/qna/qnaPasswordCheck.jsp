<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/signout.css"  rel="stylesheet" type="text/css"/>

	<div class="signout_wrap">
		<div class="signout_cont">
			<div>
				<h2>Q&A 비공개글</h2>
				<input type="hidden" id="user_id" value="${sessionScope.currentId}">
				<input type="password" id="user_password" placeholder="비밀번호를 입력하세요." maxlength="4">
				<input type="button" value="비밀번호 확인" id="checkPw_btn">
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>