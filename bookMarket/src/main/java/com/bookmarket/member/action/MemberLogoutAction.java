package com.bookmarket.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class MemberLogoutAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		session.removeAttribute("currentName");
		session.removeAttribute("currentId");
		session.invalidate();
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/index.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
