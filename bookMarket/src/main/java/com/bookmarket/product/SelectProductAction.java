package com.bookmarket.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.product.ProductDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;


public class SelectProductAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ProductDao dao=ProductDao.getInstance();
		ProductDto dto=new ProductDto();
		
		int pd_num=Integer.parseInt(request.getParameter("productNum"));
		
		
		dto=dao.selectProduct(pd_num);
		request.setAttribute("dto", dto);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/product/select_productView.jsp");
		actionForward.setRedirect(false);
		

		return actionForward;
	}
}
