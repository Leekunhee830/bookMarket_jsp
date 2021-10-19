package com.bookmarket.product.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.OrderDao;
import com.bookmarket.dto.OrderDtailDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class OrderProductAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		OrderDao dao=OrderDao.getInstance();
		OrderDtailDto dto=new OrderDtailDto();
		boolean result=false;
		
		//주문 번호 만들기
		Date now=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyyMMdd");
		String date=sd.format(now);
		int order_seq=dao.order_seq();
		String order_num=date+"_"+order_seq;
		
		//dto
		int user_num=Integer.parseInt(request.getParameter("user_num"));
		int product_num=Integer.parseInt(request.getParameter("product_num"));
		String order_phone=request.getParameter("order_phone1")+"-"+request.getParameter("order_phone2")+"-"
				+request.getParameter("order_phone3");
		String order_home_phone=request.getParameter("order_home_phone1")+"-"+request.getParameter("order_home_phone2")+"-"
				+request.getParameter("order_home_phone3");
		String order_address=request.getParameter("order_zipcode")+" "+request.getParameter("order_address")+" "
				+request.getParameter("order_detail_address");
		String order_message=request.getParameter("order_message");
		int order_amount=Integer.parseInt(request.getParameter("order_amount"));
		int order_price=Integer.parseInt(request.getParameter("order_price"));
		
		
		dto.setOrder_num(order_num);
		dto.setUser_num(user_num);
		dto.setProduct_num(product_num);
		dto.setOrder_phone(order_phone);
		dto.setOrder_home_phone(order_home_phone);
		dto.setOrder_address(order_address);
		dto.setOrder_message(order_message);
		dto.setOrder_amount(order_amount);
		dto.setOrder_price(order_price);
		
		result=dao.add_detail_order(dto);
		
		
		request.setAttribute("result", result);
		request.setAttribute("order_num", order_num);
		

		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("order_productResultView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
