package com.bookmarket.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.product.ProductDto;
import com.bookmarket.dto.product.ProductListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class MainProductAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<ProductListDto> list=new ArrayList<ProductListDto>();
		ProductDao dao=ProductDao.getInstance();
		list=dao.allProduct_20();
		
		request.setAttribute("list", list);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/main.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
