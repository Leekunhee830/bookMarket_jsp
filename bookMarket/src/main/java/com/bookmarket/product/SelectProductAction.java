package com.bookmarket.product;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookmarket.dao.ProductDao;
import com.bookmarket.dao.ReviewDao;
import com.bookmarket.dto.product.ProductDto;
import com.bookmarket.dto.review.ReviewListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;


public class SelectProductAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		int pd_num=Integer.parseInt(request.getParameter("productNum"));
		
		//��ǰ���� ��������
		ProductDao pddao=ProductDao.getInstance();
		ProductDto pddto=new ProductDto();
		pddto=pddao.selectProduct(pd_num);
		request.setAttribute("pddto", pddto);
		//��ǰ���� �������� ��
		
		
		//���䰳�� ��������
		ReviewDao rvdao=ReviewDao.getInstance();
		int reviewCount=rvdao.reviewCount(pd_num);
		request.setAttribute("reviewCount", reviewCount);
		//���䰳�� �������� ��
		
		//���� ��� ��������
		ArrayList<ReviewListDto> reviewList=new ArrayList<ReviewListDto>();
		reviewList=rvdao.reviewList(pd_num,0);
		request.setAttribute("reviewList", reviewList);
		//���� ��� �������� ��
		
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/product/select_productView.jsp");
		actionForward.setRedirect(false);
		

		return actionForward;
	}
}
