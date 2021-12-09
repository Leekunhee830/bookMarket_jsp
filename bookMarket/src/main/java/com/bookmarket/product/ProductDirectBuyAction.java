package com.bookmarket.product;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.member.MemberBuyDto;
import com.bookmarket.dto.product.ProductBuyDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class ProductDirectBuyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int product_num=Integer.parseInt(request.getParameter("prodNum"));
		int user_num=Integer.parseInt(request.getParameter("userNum"));
		
		//유저정보 가져오기
		MemberBuyDto mDto=new MemberBuyDto();
		MemberDao mDao=MemberDao.getInstance();
		mDto=mDao.getMemberInfo(user_num);
		request.setAttribute("userDto", mDto);
		
		//상품정보 가져오기
		ProductBuyDto pdDto=new ProductBuyDto();
		ProductDao pdDao=ProductDao.getInstance();
		pdDto=pdDao.getProdInfo(product_num);
		request.setAttribute("pdDto", pdDto);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/product/buy_productView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
