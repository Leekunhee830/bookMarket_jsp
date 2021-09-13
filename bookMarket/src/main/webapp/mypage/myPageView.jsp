<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>
<link href="${pageContext.request.contextPath}/css/myPageView.css"  rel="stylesheet" type="text/css"/>

<c:set var="dto" value="${requestScope.memberDto}" scope="page"/>
<c:remove var="memberDto" scope="request"/>

	<div class="mypage_wrap">
		<div class="mypage_cont">
			<div class="mypage_form">
				<div><h2>내정보</h2></div>
				<form action="memberModify.do" method="post">
					<input type="hidden" name="user_num" value="${dto.num}">
					<div class="mypage_font">아이디</div>
					<div>
						${dto.id}
					</div>
					
					<div class="mypage_font">비밀번호</div>
					<div>
						<input type="password" name="user_password" value="${dto.password}" required>
					</div>
					
					<div class="mypage_font">이름</div>
					<div>
						${dto.name}
					</div>
					
					<div class="mypage_font">전화번호</div>
					<div>
						${dto.phone }
					</div>
					
					<div class="mypage_font">이메일</div>
					<div>
						${dto.email }
					</div>
					
					<div class="mypage_btn">
						<input type="submit" value="회원정보 수정"/>
					</div>
					<div class="mypage_btn">
						<input type="button" value="회원 탈퇴" onclick="location.href='/bookMarket/mypage/signoutView.jsp'"/>
					</div>
					<c:if test="${sessionScope.currentId=='admin'}">
						<div class="mypage_btn">
							<input type="button" value="모든 회원 정보" onclick="location.href='/bookMarket/mypage/all_members.do'"/>
						</div>					
					</c:if>
				</form>
				
			</div>
		</div>
	</div>


<jsp:include page="/layout/footer.jsp"/>