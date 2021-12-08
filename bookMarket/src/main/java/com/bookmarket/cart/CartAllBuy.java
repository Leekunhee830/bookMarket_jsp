package com.bookmarket.cart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.CartDao;
import com.bookmarket.dao.MemberDao;
import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.member.MemberBuyDto;
import com.bookmarket.dto.product.ProductBuyDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class CartAllBuy implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int user_num=Integer.parseInt(request.getParameter("userNum"));
		ArrayList<Integer> prodNumList=new ArrayList<Integer>();
		
		//���� ���� ��������
		MemberBuyDto mDto=new MemberBuyDto();
		MemberDao mDao=MemberDao.getInstance();
		mDto=mDao.getMemberInfo(user_num);
		request.setAttribute("userDto", mDto);
		
		//��ٱ��� ��ǰ ��ȣ ��������
		CartDao ctDao=CartDao.getInstance();
		prodNumList=ctDao.getProdNum(user_num);
		
		//��ǰ ���� ��������
		ArrayList<ProductBuyDto> ProdList=new ArrayList<ProductBuyDto>();
		ProductDao prodDao=ProductDao.getInstance();
		ProdList=prodDao.getProdInfo(prodNumList);
		request.setAttribute("prodList",ProdList);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/product/prodListBuy.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
