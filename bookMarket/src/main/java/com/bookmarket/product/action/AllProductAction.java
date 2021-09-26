package com.bookmarket.product.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.controller.Action;
import com.bookmarket.controller.ActionForward;
import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.ProductDto;


public class AllProductAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<ProductDto> list=new ArrayList<ProductDto>();
		ProductDao dao=ProductDao.getInstance();
		
		list=dao.allProduct();
		request.setAttribute("list", list);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("all_productView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
