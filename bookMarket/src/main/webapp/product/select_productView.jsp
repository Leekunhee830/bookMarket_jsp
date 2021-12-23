<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	int reviewNo=1;
	int qnaNo=1;
%>
<jsp:include page="/layout/header.jsp"/>

	<link href="${pageContext.request.contextPath}/css/pd_css/select_productView.css"  rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/product/product.js"></script>
	
	<c:set var="pddto" value="${requestScope.pddto}" scope="page"/>
	
	<!-- 상품 정보 시작 -->
	<div class="prod_info_box">
		<div class="prod_info_box_img"><img src="${pageContext.request.contextPath}/upLoadImg/${pddto.pd_imgName}"/></div>
		<div class="prod_info_box_cont">
			<div>
				<div class="prod_info_box_cont_name">${pddto.pd_name}</div>
				<div class="prod_info_box_cont_publisher">${pddto.pd_manufacturer}</div>
				<div class="prod_info_box_cont_price"><fmt:formatNumber value="${pddto.pd_price}" type="number"/>원</div>
				<div class="prod_info_box_cont_button">
					<c:choose>
						<c:when test="${sessionScope.currentNum ne null}">
							<button type="button" onclick="location.href='${pageContext.request.contextPath}/product/directBuy.pd?prodNum=${pddto.pd_num}&userNum=${sessionScope.currentNum}'">주문하기</button>					
						</c:when>
						<c:otherwise>
							<button type="button" onclick="needLogin();">주문하기</button>							
						</c:otherwise>
						</c:choose>
					<button type="button" onclick="addCart('${sessionScope.currentNum }','${pddto.pd_num}')">장바구니</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 상품 정보 끝 -->
	
	<!-- 하단 박스 시작 -->
	<div class="wrap_detail_info">
		<!-- 상품정보/리뷰/Q&A/주문정보 시작 -->
		<div class="tab_detail_info row">
			<ul class="tab">
				<li><a href="#">상품상세정보</a></li>
				<li><a href="#">리 뷰</a></li>
				<li><a href="#">Q & A</a></li>
				<li><a href="#">반품/교환</a></li>
			</ul>
		</div>
		<!-- 상품정보/리뷰/Q&A 끝 -->
	
		<!-- 상품 상세정보 시작 -->
		<div>
			<h2>상품상세정보</h2>
		</div>
		<div>
			${pddto.pd_contents}
		</div>
		<div>
			<c:if test="${not empty pddto.pd_imgName2}">
				<img src="${pageContext.request.contextPath}/upLoadImg/${pddto.pd_imgName2}"/>
			</c:if>
			<c:if test="${not empty pddto.pd_imgName3}">
				<img src="${pageContext.request.contextPath}/upLoadImg/${pddto.pd_imgName3}"/>
			</c:if>
			<c:if test="${not empty pddto.pd_imgName4}">
				<img src="${pageContext.request.contextPath}/upLoadImg/${pddto.pd_imgName4}"/>
			</c:if>
		</div>
		<!-- 상품 상세정보 끝 -->
		
		<!-- 리뷰 박스 시작 -->
		<div class="review_box">
			<div class="review_header_box">
				<div>
					<h2>리뷰 (${requestScope.reviewCount})</h2>
				</div>
				<div class="review_header_font">
					<c:if test="${sessionScope.currentId!=null}">
						<a href="${pageContext.request.contextPath}/review/reviewWriteView.rv?prodNum=${pddto.pd_num}" class="review_write">리뷰 작성</a>				
					</c:if>
					<a href="${pageContext.request.contextPath}/review/reviewAllList.rv?prodNum=${pddto.pd_num}">전체 보기</a>
				</div>
			</div>
			<div class="review_item_box">
				<c:if test="${requestScope.reviewList!=null}">
					<c:forEach var="review" items="${requestScope.reviewList}">
						<div class="review_item">
							<div class="review_item_reviewNo"><%=reviewNo %></div>
							<div class="review_item_contents"><a href="${pageContext.request.contextPath}/review/reviewDetail.rv?reviewNum=${review.review_num}">${review.contents}</a></div>
							<div class="review_item_id">${review.user_id}</div>
							<div class="review_item_regdate"><fmt:formatDate value="${review.regdate}" type="date"/></div>
						</div>
						<%reviewNo+=1; %>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<!-- 리뷰 박스 끝 -->
		
		<!-- Q&A 박스 시작 -->
		<div class="review_box">
			<div class="review_header_box">
				<div>
					<h2>Q&A (${requestScope.qnaCount})</h2>
				</div>
				<div class="review_header_font">
					<c:if test="${sessionScope.currentId!=null}">
						<a href="${pageContext.request.contextPath}/qna/qnaWriteView.qna?prodNum=${pddto.pd_num}" class="review_write">문의하기</a>				
					</c:if>
					<a href="${pageContext.request.contextPath}/qna/qnaAllList.qna?prodNum=${pddto.pd_num}">전체 보기</a>
				</div>
			</div>
			<div class="review_item_box">
				<c:if test="${requestScope.qnaList!=null}">
					<c:forEach var="qna" items="${requestScope.qnaList}">
						<div class="review_item">
							<div class="review_item_reviewNo"><%=qnaNo %></div>
							<c:choose>
								<c:when test="${empty qna.qna_password}">
									<div class="review_item_contents"><a href="${pageContext.request.contextPath}/qna/qnaDetail.qna?qnaNum=${qna.qna_num}">${qna.contents}</a></div>
								</c:when>
								<c:otherwise>
									<div class="review_item_contents"><a href="${pageContext.request.contextPath}/qna/qnaDetail.qna?qnaNum=${qna.qna_num}">비밀글입니다.</a></div>
								</c:otherwise>
							</c:choose>
							<div class="review_item_id">${qna.user_id}</div>
							<div class="review_item_regdate"><fmt:formatDate value="${qna.regdate}" type="date"/></div>
						</div>
						<%qnaNo+=1; %>
					</c:forEach>
				</c:if>
			</div>
		</div>
		<!-- Q&A 박스 끝 -->
		
	</div>
	<!-- 하단 박스 끝 -->
<jsp:include page="/layout/footer.jsp"/>