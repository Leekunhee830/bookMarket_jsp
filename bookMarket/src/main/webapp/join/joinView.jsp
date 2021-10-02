<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/join.css"  rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/check.js"></script>


	<div class="join_wrap">
		<div class="join_cont">
			<div class="join_form">
				<div><h2>회원가입</h2></div>
				<form action="MemberJoin.do" method="post" id="join_submit">
					<div class="join_font">아이디</div>
					<div>
						<input type="text" id="user_id" name="user_id" placeholder="Id를 입력하세요." required>
						<input type="button" value="아이디 중복체크" id="id_check_btn">
					</div>
					<div id="id_check" class="check_font"></div>
					
					<div class="join_font">비밀번호</div>
					<div>
						<input type="password" id="user_password1" name="user_password" placeholder="PW를 입력하세요." required>
					</div>
					<div class="repassword">
						<input type="password" id="user_password2" name="user_password" placeholder="PW를 다시 입력하세요." required>
					</div>
					<div id="password_check" class="check_font"></div>
					
					<div class="join_font">이름</div>
					<div>
						<input type="text" id="user_name" name="user_name" placeholder="이름을 입력하세요." required>
					</div>
					
					<div class="join_font">전화번호</div>
					<div>
						<select name="user_phone1" id="user_phone1">
							<option value="010">010</option>
							<option value="070">070</option>
							<option value="011">011</option>
						</select>
						-
						<input type="text" id="user_phone2" name="user_phone2" required size="5" maxlength='4'>
						-
						<input type="text" id="user_phone3" name="user_phone3" required size="5" maxlength='4'>
					</div>
					
					<div class="join_font">이메일</div>
					<div>
						<input type="text" id="user_email1" name="user_email1" placeholder="이메일을 입력하세요." required size="15">
						@
						<select name="user_email2" id="user_email2">
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="daum.com">daum.com</option>
						</select>
						<input type="button" value="인증번호 받기" id="send_email_btn"/>
					</div>
					<div class="join_font">인증번호</div>
					<div>
						<input type="text" id="user_email_checkNum">
						<input type="button" value="인증하기" id="send_email_check"/>
					</div>
					
					<div class="join_submit">
						<input type="button" value="회원가입" id="join_button"/>
					</div>
				</form>
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>