package com.bookmarket.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.product.ProductListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class ProductCategoryAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int category=Integer.parseInt(request.getParameter("category"));
		ArrayList<ProductListDto> list=new ArrayList<ProductListDto>();
		ProductDao dao=ProductDao.getInstance();
		
		list=dao.getItProdList(category);
		request.setAttribute("list", list);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/product/categoryProdView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
