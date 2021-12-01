<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/qna_css/qnaPasswordCheck.css"  rel="stylesheet" type="text/css"/>

	<div class="qna_wrap">
		<div class="qna_cont">
			<div>
				<h2>Q&A 비공개글</h2>
				<form action="passwordCheck.qna" method="post">
					<input type="hidden" name="qna_num" value="${requestScope.qna_num}">
					<input type="password" name="qna_password" placeholder="비밀번호를 입력하세요." maxlength="4">
					<input type="submit" value="비밀번호 확인">
				</form>
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>