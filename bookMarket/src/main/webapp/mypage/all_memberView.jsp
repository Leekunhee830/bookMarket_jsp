<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/layout/header.jsp"/>

<link href="${pageContext.request.contextPath}/css/all_memberView.css"  rel="stylesheet" type="text/css"/>


	<div class="all_member_wrap">
		<div class="all_member_cont">
			<div>
				<h2>모든 회원 정보</h2>
				<c:choose>
					<c:when test="${requestScope.list==null}">
						<h3>회원 정보가 없습니다.</h3>
					</c:when>
					<c:otherwise>
						<table border="1">
							<tr align="center">
								<th width="100">NUM.</th>
								<th >ID.</th>
								<th >NAME</th>
								<th >EMAIL</th>
								<th >PHONE</th>
								<th >PASSWORD</th>
								<th>REGDATE</th>
							</tr>
							<c:forEach var="dto" items="${requestScope.list}">
								<tr align="center">
									<td>${dto.num}</td>
									<td>${dto.id }</td>
									<td>${dto.name }</td>
									<td>${dto.email }</td>
									<td>${dto.phone }</td>
									<td>${dto.password }</td>
									<td>${dto.regdate }</td>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

<jsp:include page="/layout/footer.jsp"/>