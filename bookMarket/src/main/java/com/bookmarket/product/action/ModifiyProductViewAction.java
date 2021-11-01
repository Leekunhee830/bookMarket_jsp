package com.bookmarket.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.ProductDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class ModifiyProductViewAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int pd_num=Integer.parseInt(request.getParameter("pd_num"));
		ProductDao dao=ProductDao.getInstance();
		ProductDto dto=new ProductDto();
		
		dto=dao.selectProduct(pd_num);
		request.setAttribute("dto", dto);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("modify_productView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
