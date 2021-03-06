package com.bookmarket.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.product.ProductDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class ProductManagerAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<ProductDto> list=new ArrayList<ProductDto>();
		ProductDao dao=ProductDao.getInstance();
		list=dao.managerAllProd();
		
		request.setAttribute("list", list);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/product/manager_productView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
