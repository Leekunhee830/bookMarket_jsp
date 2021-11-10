package com.bookmarket.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.OrderDao;
import com.bookmarket.dto.OrderDetailDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class OrderDetailAction implements Action{
	 @Override
	 public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 request.setCharacterEncoding("UTF-8");
		 String order_num=request.getParameter("orderNum");
		 OrderDao dao=OrderDao.getInstance();
		 OrderDetailDto dto=new OrderDetailDto();
		 dto=dao.getOrder_detail(order_num);
		 
		 request.setAttribute("dto", dto);
		 
		 ActionForward actionForward=new ActionForward();
		 actionForward.setNextPath("/product/order_detailView.jsp");
		 actionForward.setRedirect(false);
		
		 
		 return actionForward;
	 }
}
