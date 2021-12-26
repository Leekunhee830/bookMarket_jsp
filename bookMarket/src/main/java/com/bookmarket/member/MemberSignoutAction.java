package com.bookmarket.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;
import com.bookmarket.util.SHA256;

public class MemberSignoutAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		int user_num=Integer.parseInt(request.getParameter("user_num"));
		String rawPassword=request.getParameter("user_password");
		String password=SHA256.encodeSHA256(rawPassword);
		boolean result=false;
		MemberDao dao=MemberDao.getInstance();
		
		result=dao.signout(user_num, password);
		
		if(result) {
			HttpSession session=request.getSession();
			session.removeAttribute("currentName");
			session.removeAttribute("currentId");
			session.invalidate();
		}
		
		request.setAttribute("result", result);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/mypage/signoutResultView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}

}
