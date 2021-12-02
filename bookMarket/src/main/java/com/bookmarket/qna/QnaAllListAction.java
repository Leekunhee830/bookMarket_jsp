package com.bookmarket.qna;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ProductDao;
import com.bookmarket.dao.QnaDao;
import com.bookmarket.dto.product.ProductDto;
import com.bookmarket.dto.qna.QnaListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class QnaAllListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int product_num=Integer.parseInt(request.getParameter("prodNum"));
		
		//상품정보 가져오기
		ProductDao pdDao=ProductDao.getInstance();
		ProductDto pdDto=new ProductDto();
		pdDto=pdDao.selectProduct(product_num);
		request.setAttribute("pdDto", pdDto);
		
		//Q&A 전체 목록
		ArrayList<QnaListDto> qna_list=new ArrayList<QnaListDto>();
		QnaDao qnaDao=QnaDao.getInstance();
		qna_list=qnaDao.qnalist(product_num, 1);
		request.setAttribute("qnaList", qna_list);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/qna/qnaAllList.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
