package com.bookmarket.qna;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bookmarket.dao.QnaDao;
import com.bookmarket.dto.qna.QnaDetailDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class QnaPasswordCheckAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		int qna_num=Integer.parseInt(request.getParameter("qna_num"));
		String qna_password=request.getParameter("qna_password");
		boolean result=false;
		
		QnaDao dao=QnaDao.getInstance();
		result=dao.passwordCheck(qna_num,qna_password);
		
		ActionForward actionForward=new ActionForward();
		if(result) {
			QnaDetailDto dto=new QnaDetailDto();
			dto=dao.detailQna(qna_num);
			request.setAttribute("dto", dto);
			actionForward.setNextPath("/qna/qnaDetail.jsp");
			actionForward.setRedirect(false);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('비밀번호를 다시 확인해주세요.'); location.href=document.referrer;</script>");
			out.flush();
		}
		
		return actionForward;
	}
}
