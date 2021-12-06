package com.bookmarket.cart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.CartDao;
import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.product.ProductBuyDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class CartAllBuy implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int user_num=Integer.parseInt(request.getParameter("userNum"));
		ArrayList<Integer> prodNumList=new ArrayList<Integer>();
		
		//장바구니 상품 번호 가져오기
		CartDao ctDao=CartDao.getInstance();
		prodNumList=ctDao.getProdNum(user_num);
		
		//상품 정보 가져오기
		ArrayList<ProductBuyDto> ProdList=new ArrayList<ProductBuyDto>();
		ProductDao prodDao=ProductDao.getInstance();
		ProdList=prodDao.getProdInfo(prodNumList);
		request.setAttribute("prodList",ProdList);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/product/productBuy.jsp");
		actionForward.setRedirect(false);
		
		return null;
	}
}
