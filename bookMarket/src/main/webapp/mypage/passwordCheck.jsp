<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/signout.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/modifyPw.js"></script>

	<div class="signout_wrap">
		<div class="signout_cont">
			<div>
				<h2>비밀번호 수정</h2>
				<input type="hidden" id="user_id" value="${sessionScope.currentId}">
				<input type="password" id="user_password" placeholder="비밀번호를 입력하세요." required>
				<input type="button" value="비밀번호 확인" id="checkPw_btn">
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>