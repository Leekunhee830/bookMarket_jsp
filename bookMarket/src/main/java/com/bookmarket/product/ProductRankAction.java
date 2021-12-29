package com.bookmarket.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.product.ProductListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class ProductRankAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int list_num=Integer.parseInt(request.getParameter("list"));
		int category_num=Integer.parseInt(request.getParameter("category"));
		ArrayList<ProductListDto> list=new ArrayList<ProductListDto>();
		
		ProductDao dao=ProductDao.getInstance();
		list=dao.getRankProd(list_num,category_num);
		
		request.setAttribute("list", list);
		ActionForward actionForward=new ActionForward();
		if(category_num==0) {
			actionForward.setNextPath("/product/all_productView.jsp");
			actionForward.setRedirect(false);
		}else {
			String strCategory="";
			if(category_num==2) {
				strCategory="컴퓨터/모바일";
			}else if(category_num==3) {
				strCategory="자격증";
			}else if(category_num==4) {
				strCategory="외국어";
			}
			
			request.setAttribute("strCategory",strCategory);
			request.setAttribute("categoryNum", category_num);
			actionForward.setNextPath("/product/categoryProdView.jsp");
			actionForward.setRedirect(false);
		}
		
		return actionForward;
	}
}
