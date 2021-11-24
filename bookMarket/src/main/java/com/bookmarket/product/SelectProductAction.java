package com.bookmarket.product;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookmarket.dao.ProductDao;
import com.bookmarket.dao.ReviewDao;
import com.bookmarket.dto.product.ProductDto;
import com.bookmarket.dto.review.ReviewListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;


public class SelectProductAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		int pd_num=Integer.parseInt(request.getParameter("productNum"));
		
		//상품정보 가져오기
		ProductDao pddao=ProductDao.getInstance();
		ProductDto pddto=new ProductDto();
		pddto=pddao.selectProduct(pd_num);
		request.setAttribute("pddto", pddto);
		//상품정보 가져오기 끝
		
		
		//리뷰개수 가져오기
		ReviewDao rvdao=ReviewDao.getInstance();
		int reviewCount=rvdao.reviewCount(pd_num);
		request.setAttribute("reviewCount", reviewCount);
		//리뷰개수 가져오기 끝
		
		//리뷰 목록 가져오기
		ArrayList<ReviewListDto> reviewList=new ArrayList<ReviewListDto>();
		reviewList=rvdao.reviewList(pd_num,0);
		request.setAttribute("reviewList", reviewList);
		//리뷰 목록 가져오기 끝
		
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/product/select_productView.jsp");
		actionForward.setRedirect(false);
		

		return actionForward;
	}
}
