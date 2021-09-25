package com.bookmarket.product.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.controller.Action;
import com.bookmarket.controller.ActionForward;
import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.ProductDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddProductAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		ProductDto dto=new ProductDto();
		ProductDao dao=ProductDao.getInstance();
		boolean result=false;
		
		String realPath=request.getServletContext().getRealPath("/upLoadImg");
		int maxSize=1024*1024*100;
		String encoding="UTF-8";
		MultipartRequest multipartRequest
		=new MultipartRequest(request,
				realPath,
				maxSize,
				encoding,
				new DefaultFileRenamePolicy());
		String pd_imgName=multipartRequest.getOriginalFileName("pd_img");
		String pd_code=multipartRequest.getParameter("pd_code");
		String pd_name=multipartRequest.getParameter("pd_name");
		String pd_contents=multipartRequest.getParameter("pd_contents");
		int pd_price=Integer.parseInt(multipartRequest.getParameter("pd_price"));
		int pd_amount=Integer.parseInt(multipartRequest.getParameter("pd_amount"));
		String pd_category=multipartRequest.getParameter("pd_category");
		String pd_manufacturer=multipartRequest.getParameter("pd_manufacturer");
		
		dto.setPd_imgName(pd_imgName);
		dto.setPd_code(pd_code);
		dto.setPd_name(pd_name);
		dto.setPd_contents(pd_contents);
		dto.setPd_price(pd_price);
		dto.setPd_amount(pd_amount);
		dto.setPd_category(pd_category);
		dto.setPd_manufacturer(pd_manufacturer);
		
		result=dao.addProduct(dto);
		request.setAttribute("result", result);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("add_productResultView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
