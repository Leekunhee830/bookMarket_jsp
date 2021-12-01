package com.bookmarket.qna;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.QnaDao;

public class DeleteQna {
	public int delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boolean result=false;
		int qna_num=Integer.parseInt(request.getParameter("qna_num"));
		QnaDao dao=QnaDao.getInstance();
		result=dao.deleteQna(qna_num);
		
		
		return result?1:0;
	}
}
