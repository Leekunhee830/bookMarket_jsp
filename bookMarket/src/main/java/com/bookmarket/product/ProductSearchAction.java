package com.bookmarket.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.product.ProductListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class ProductSearchAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		String prodName=request.getParameter("prodName");
		ProductDao dao=ProductDao.getInstance();
		ArrayList<ProductListDto> list=new ArrayList<ProductListDto>();
		
		list=dao.getSearchProd(prodName);
		request.setAttribute("list", list);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/product/search_productView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
