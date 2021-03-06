<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/member_css/login.css"  rel="stylesheet" type="text/css"/>

	<div class="login_wrap">
		<div class="login_cont">
			<div class="input_form">
				<h2>로그인</h2>
				<form action="MemberLogin.do" method="post" class="row">
					<p>
						<input type="text" name="user_id" placeholder="사용자 아이디" value="${cookie.user_id_remember.value }" class="width_100">
					</p>
					<p>
						<input type="password" name="user_password" placeholder="비밀번호" class="width_100">
					</p>
					<div class="login_fail">
						${requestScope.login_msg}
					</div>
					<div>
						<input type="checkbox" name="user_id_remember" value="true">아이디 기억하기
					</div>
					<div class="login_submit">
						<input type="submit" value="로그인" class="width_100">
					</div>
					<div class="login_find">
						<a href="memberFindIdView.jsp"><h5>나의 계정찾기<h5></a>
					</div>
				</form>
					<a href="https://kauth.kakao.com/oauth/authorize?client_id=e6438c922f7b9530b1f4308a8f0c0154&redirect_uri=http://localhost:8002/bookMarket/kakaoLogin.ka&response_type=code">
					<img class="width_100 kakao_img" src="/bookMarket/img/kakao_login_large_wide.png">
					</a>
			</div>
		</div>
	</div>
	
<jsp:include page="/layout/footer.jsp"/>