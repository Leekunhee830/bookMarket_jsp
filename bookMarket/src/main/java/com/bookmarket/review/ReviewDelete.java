package com.bookmarket.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ReviewDao;

public class ReviewDelete {
	public int delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boolean result=false;
		int review_num=Integer.parseInt(request.getParameter("review_num"));
		ReviewDao dao=ReviewDao.getInstance();
		result=dao.deleteReview(review_num);
		
		
		return result?1:0;
	}
}
