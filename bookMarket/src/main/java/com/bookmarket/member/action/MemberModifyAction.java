package com.bookmarket.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class MemberModifyAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		boolean result=false;
		String user_password=request.getParameter("user_password");
		int user_num=Integer.parseInt(request.getParameter("user_num"));
		MemberDao dao=MemberDao.getInstance();
		
		result=dao.memberModify(user_num, user_password);
		
		request.setAttribute("result", result);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("modifyResultView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
