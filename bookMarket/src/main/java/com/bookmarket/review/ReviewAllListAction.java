package com.bookmarket.review;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dao.ReviewDao;
import com.bookmarket.dto.product.ProductDto;
import com.bookmarket.dto.review.ReviewListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class ReviewAllListAction implements Action{
	 @Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 int product_num=Integer.parseInt(request.getParameter("prodNum"));
		 
		 //상품정보 가져오기
		 ProductDao pdDao=ProductDao.getInstance();
		 ProductDto pdDto=new ProductDto();
		 pdDto=pdDao.selectProduct(product_num);
		 request.setAttribute("pdDto", pdDto);
		 
		 //리뷰전체목록 가져오기
		 ArrayList<ReviewListDto> review_list=new ArrayList<ReviewListDto>();
		 ReviewDao rvdao=ReviewDao.getInstance();
		 review_list=rvdao.reviewList(product_num, 1);
		 request.setAttribute("reviewList", review_list);
		 
		 ActionForward actionForward=new ActionForward();
		 actionForward.setNextPath("/review/reviewAllList.jsp");
		 actionForward.setRedirect(false);
		 
		 return actionForward;
	}
}
