package com.bookmarket.order;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.OrderDao;
import com.bookmarket.dto.order.OrderAddDto;
import com.google.gson.Gson;

public class OrderAdd {
	public String orderAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		BufferedReader br=request.getReader();
		String requestData=br.readLine();
		Gson gson=new Gson();
		
		OrderAddDto dto=gson.fromJson(requestData, OrderAddDto.class);
		
		//주문번호생성
		OrderDao dao=OrderDao.getInstance();
		int seq=dao.order_seq();
		Date now=new Date();
		SimpleDateFormat vans=new SimpleDateFormat("yyyyMMdd");
		String wdate=vans.format(now);
		String order_num=seq+"_"+wdate;
		dto.setOrder_num(order_num);
		
		//주문데이터 삽입
		boolean result=dao.add_detail_order(dto);
		if(!result) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('결제 오류'); location.href='/index.jsp';</script>");
			out.flush();
		}
		
		return order_num;
	}
}
