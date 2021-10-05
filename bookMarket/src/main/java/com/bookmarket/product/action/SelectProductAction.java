package com.bookmarket.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.ProductDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;


public class SelectProductAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ProductDao dao=ProductDao.getInstance();
		ProductDto dto=new ProductDto();
		
		int pd_num=Integer.parseInt(request.getParameter("productNum"));
		
		System.out.println(pd_num);

		
		dto=dao.selectProduct(pd_num);
		request.setAttribute("dto", dto);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("select_productView.jsp");
		actionForward.setRedirect(false);
		
		System.out.println(dto);

		return actionForward;
	}
}