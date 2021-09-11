package com.bookmarket.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.controller.Action;
import com.bookmarket.controller.ActionForward;
import com.bookmarket.dao.MemberDao;

public class MemberSignoutAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		String user_id=request.getParameter("user_id");
		String user_password=request.getParameter("user_password");
		boolean result=false;
		MemberDao dao=MemberDao.getInstance();
		
		result=dao.memberSignout(user_id, user_password);
		
		if(result) {
			HttpSession session=request.getSession();
			session.removeAttribute("currentName");
			session.removeAttribute("currentId");
			session.invalidate();
		}
		
		request.setAttribute("result", result);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("signoutResultView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}

}
