<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/signout.css"  rel="stylesheet" type="text/css"/>

	<div class="signout_wrap">
		<div class="signout_cont">
			<form action="signout.do" method="post">
				<div>
					<h2>비밀번호 수정</h2>
					<input type="hidden" name="user_id" value="${sessionScope.currentId}">
					<input type="password" name="user_password" placeholder="비밀번호를 입력하세요." required>
					<input type="password" name="user_repassword" placeholder="비밀번호를 다시 입력하세요." required>
					<input type="submit" value="비밀번호 수정">
				</div>
			</form>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>