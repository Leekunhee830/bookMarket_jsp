<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/join.css"  rel="stylesheet" type="text/css"/>

	<div class="join_wrap">
		<div class="join_cont">
			<div class="join_form">
				<div><h2>회원가입</h2></div>
				<form action="#" method="post">
					<div class="join_font">아이디</div>
					<div>
						<input type="text" name="user_id" placeholder="Id를 입력하세요." required>
					</div>
					
					<div class="join_font">비밀번호</div>
					<div>
						<input type="password" name="user_password" placeholder="PW를 입력하세요." required>
					</div>
					
					<div class="join_font">이름</div>
					<div>
						<input type="text" name="user_name" placeholder="이름을 입력하세요." required>
					</div>
					
					<div class="join_font">전화번호</div>
					<div>
						<input type="text" name="user_phone" placeholder="전화번호를 입력하세요." required>
					</div>
					
					<div class="join_font">이메일</div>
					<div>
						<input type="text" name="user_email" placeholder="이메일을 입력하세요." required>
					</div>
					
					<div class="join_submit">
						<input type="submit" value="회원가입"/>
					</div>
				</form>
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>