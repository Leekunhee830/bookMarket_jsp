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
				<li><a href="#prod_detail_info_box">상품상세정보</a></li>
				<li><a href="#prod_review_box">리 뷰</a></li>
				<li><a href="#prod_qna_box">Q & A</a></li>
				<li><a href="#prod_exchange_box">반품/교환</a></li>
			</ul>
		</div>
		<!-- 상품정보/리뷰/Q&A 끝 -->
	
		<!-- 상품 상세정보 시작 -->
		<div id="prod_detail_info_box">
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
		<div class="review_box" id="prod_review_box">
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
		<div class="review_box" id="prod_qna_box">
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
		<!-- 반품/교환 시작 -->
		<div class="exchange_box">
			<div id="prod_exchange_box"><h2 class="exchange_font">반품 및 교환안내</h2></div>
			<p>반품 / 교환 안내</p>
			<p>&nbsp;</p>
			<p>1. 구매자 단순 변심은 상품 수령 후 7일 이내 교환 / 반품 가능합니다.</p>
			<p>1-1 반품 배송비는 구매자에게 부담됩니다.</p>
			<p>&nbsp;</p>
			<p>2. 표시/광고와 상이, 상품 하자의 경우 상품 후령 후 3개월 이내 혹은 표시/광고와 다른 사실을 안 날로부터 30일 이내 교환 / 반품 가능합니다.</p>
			<p>2-1 둘 중 하나 경과 시 반품/교화 불가</p>
			<p>2-2 반품 배송비는 판매자에게 부담됩니다.</p>
			<p>&nbsp;</p>
			<p>반품 / 교환 불가능 사유</p>
			<p>&nbsp;</p>
			<p>1. 반품요청 기간이 지난 경우</p>
			<p>2. 구매자의 책임이 있는 사유로 상품이 훼손 된 경우</p>
			<p>3. 보장을 개봉하였거나 포장이 훼손 되어 상품 가치가 현저히 상실 된 경우</p>
			<p>4. 구매자의 사용 또는 일부 소비에 의하여 상품의 가치가 현저히 감소한 경우</p>
			<p>5. 시간의 경과에 의하여 재판매가 곤란할 정도로 상품 등의 가치가 현저히 감소한 경우</p>
			<p>6. 복제가 가능한 상품 등의 포장을 훼손한 경우 </p>
			<p>&nbsp;&nbsp;</p>
			<p>환불안내</p>
			<p>- 상품 청약철회 가능기간은 상품 수령일로 부터 7일 이내 입니다.</p>
			<p>&nbsp;&nbsp;</p>
			<p>AS안내</p>
			<p>- 소비자분쟁해결 기준(공정거래위원회 고시)에 따라 피해를 보상받을 수 있습니다.</p>
			<p>- A/S는 판매자에게 문의하시기 바랍니다.</p>
		</div>
		<!-- 반품/교환 끝 -->
	</div>
	<!-- 하단 박스 끝 -->
<jsp:include page="/layout/footer.jsp"/>