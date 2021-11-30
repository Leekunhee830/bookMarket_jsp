package com.bookmarket.qna;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.QnaDao;
import com.bookmarket.dto.qna.QnaListDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class QnaDetailAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int qna_num=Integer.parseInt(request.getParameter("qnaNum"));
		QnaDao dao=QnaDao.getInstance();
		QnaListDto dto=new QnaListDto();
		dto=dao.detailQna(qna_num);
		
		ActionForward actionForward=new ActionForward();
		
		
		if(dto.getQna_password()!=null) {
			request.setAttribute("qna_num",dto.getQna_num());
			actionForward.setNextPath("");
			actionForward.setRedirect(false);
		}else {
			request.setAttribute("dto", dto);
			actionForward.setNextPath("/qna/qnaDetail.jsp");
			actionForward.setRedirect(false);
		}
		
		return actionForward;
	}
}
