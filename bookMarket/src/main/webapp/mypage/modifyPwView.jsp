<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/member_css/modifyPwView.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/member/modifyPw.js"></script>

	<div class="modifyPw_wrap">
		<div class="modifyPw_cont">
			<form action="ModifyPw.do" method="post" id="modifyPw_submit">
				<div>
					<h2>비밀번호 수정</h2>
					<input type="hidden" name="user_id" value="${sessionScope.currentId}">
					<input type="password" id="user_password" name="user_password" placeholder="비밀번호를 입력하세요." required><br/>
					<input type="password" id="user_repassword" name="user_repassword" placeholder="비밀번호를 다시 입력하세요." required>
					<input type="submit" value="비밀번호 수정" id="modifyPw_button">
				</div>
			</form>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>