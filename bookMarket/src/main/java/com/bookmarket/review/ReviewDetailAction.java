package com.bookmarket.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ReviewDao;
import com.bookmarket.dto.review.ReviewListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class ReviewDetailAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int review_num=Integer.parseInt(request.getParameter("reviewNum"));
		ReviewDao dao=ReviewDao.getInstance();
		ReviewListDto dto=new ReviewListDto();
		
		dto=dao.detailReview(review_num);
		request.setAttribute("dto", dto);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/review/reviewDetail.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
