package com.bookmarket.product;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dto.ProductDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class ModifyProduct{
	
	public void modify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
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
		String pd_tmpImg=multipartRequest.getParameter("tmp_pd_img");
		int pd_num=Integer.parseInt(multipartRequest.getParameter("pd_num"));
		String pd_code=multipartRequest.getParameter("pd_code");
		String pd_name=multipartRequest.getParameter("pd_name");
		String pd_contents=multipartRequest.getParameter("pd_contents");
		int pd_price=Integer.parseInt(multipartRequest.getParameter("pd_price"));
		int pd_amount=Integer.parseInt(multipartRequest.getParameter("pd_amount"));
		String pd_category=multipartRequest.getParameter("pd_category");
		String pd_manufacturer=multipartRequest.getParameter("pd_manufacturer");
		
		if(multipartRequest.getFilesystemName("pd_img")==null) {
			dto.setPd_imgName(pd_tmpImg);
		}else {
			dto.setPd_imgName(pd_imgName);
			//기존 이미지 파일 삭제
			File file=new File(realPath+"/"+pd_tmpImg);
			file.delete();
		}
		
		dto.setPd_num(pd_num);
		dto.setPd_code(pd_code);
		dto.setPd_name(pd_name);
		dto.setPd_contents(pd_contents);
		dto.setPd_price(pd_price);
		dto.setPd_amount(pd_amount);
		dto.setPd_category(pd_category);
		dto.setPd_manufacturer(pd_manufacturer);
		
		result=dao.ModifyProduct(dto,pd_num);
		
		if(result) {
			out.println("<script>alert('상품 수정이 완료되었습니다.'); location.href='/bookMarket/index.jsp';</script>");
			out.flush();
		}else {
			out.println("<script>alert('상품 수정을 실패하였습니다.'); location.href='/bookMarket/index.jsp';</script>");
			out.flush();
		}
		
	}
}
