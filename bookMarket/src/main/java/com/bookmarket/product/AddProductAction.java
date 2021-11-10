package com.bookmarket.product;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.ProductDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;
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
		String pd_imgName=multipartRequest.getFilesystemName("pd_img");
		String pd_imgName2=multipartRequest.getFilesystemName("pd_img2");
		String pd_imgName3=multipartRequest.getFilesystemName("pd_img3");
		String pd_imgName4=multipartRequest.getFilesystemName("pd_img4");
		String pd_code=multipartRequest.getParameter("pd_code");
		String pd_name=multipartRequest.getParameter("pd_name");
		String pd_contents=multipartRequest.getParameter("pd_contents");
		pd_contents=pd_contents.replace("\r\n", "<br>");
		int pd_price=Integer.parseInt(multipartRequest.getParameter("pd_price"));
		int pd_amount=Integer.parseInt(multipartRequest.getParameter("pd_amount"));
		String pd_category=multipartRequest.getParameter("pd_category");
		String pd_manufacturer=multipartRequest.getParameter("pd_manufacturer");
		
		dto.setPd_imgName(pd_imgName);
		dto.setPd_imgName2(pd_imgName2);
		dto.setPd_imgName3(pd_imgName3);
		dto.setPd_imgName4(pd_imgName4);
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
		actionForward.setNextPath("/product/add_productResultView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
