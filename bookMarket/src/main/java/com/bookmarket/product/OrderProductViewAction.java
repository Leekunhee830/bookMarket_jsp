package com.bookmarket.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.member.MemberDto;
import com.bookmarket.dto.product.ProductDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class OrderProductViewAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		int pd_num=Integer.parseInt(request.getParameter("pd_num"));
		int user_num=Integer.parseInt(request.getParameter("user_num"));
		
		System.out.println("넘버1"+pd_num);
		System.out.println("넘버2"+user_num);
		
		ProductDao Pdao=ProductDao.getInstance();
		MemberDao Mdao=MemberDao.getInstance();
		ProductDto Pdto=new ProductDto();
		MemberDto Mdto=new MemberDto();
		
		Pdto=Pdao.selectProduct(pd_num);
		Mdto=Mdao.myPage(user_num);
		
		request.setAttribute("pdto", Pdto);
		request.setAttribute("mdto", Mdto);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/product/order_productView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
