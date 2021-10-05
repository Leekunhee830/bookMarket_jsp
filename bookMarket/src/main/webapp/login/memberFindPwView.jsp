<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/memberFindPw.css"  rel="stylesheet" type="text/css"/>
	<div class="find_cont">
		<form action="MemberFindPw.do" method="post">
			<div class="find_form row">
				<h1>아이디 찾기</h1>
				<p>사용자 아이디</p>
				<input type="text" name="user_id" placeholder="사용자 아이디를 입력해주세요." required>
				<p>사용자 이메일</p>
				<input type="text" name="user_email" placeholder="사용자 이메일을 입력해주세요." required>
				<input type="submit" value="비밀번호 찾기">
				<div class="find_password">
					<a href="memberFindIdView.jsp"><h5>아이디 찾기</h5></a>
				</div>
			</div>
		</form>
	</div>

<jsp:include page="/layout/footer.jsp"/>