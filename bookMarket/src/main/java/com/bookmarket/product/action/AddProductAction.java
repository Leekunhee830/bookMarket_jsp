package com.bookmarket.product.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.controller.Action;
import com.bookmarket.controller.ActionForward;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddProductAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		String realPath=request.getServletContext().getRealPath("/upLoadImg");
		int maxSize=1024*1024*100;
		String encoding="UTF-8";
		MultipartRequest multipartRequest
		=new MultipartRequest(request,
				realPath,
				maxSize,
				encoding,
				new DefaultFileRenamePolicy());
		String fileName=multipartRequest.getOriginalFileName("pd_img");
		
		
		return null;
	}
}
