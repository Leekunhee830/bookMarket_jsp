package com.bookmarket.product.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;

public class ProductDelete {
	public int product_delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("UTF-8");
		int pd_num=Integer.parseInt(request.getParameter("pd_num"));
		String pd_img=request.getParameter("pd_img");
		String realPath=request.getServletContext().getRealPath("/upLoadImg/");
		ProductDao dao=ProductDao.getInstance();
		int result=0;
		
		result=dao.deleteProduct(pd_num);
		if(result==1) {
			File file=new File(realPath+pd_img);
			file.delete();
		}
		
		
		return result;
	}
}
