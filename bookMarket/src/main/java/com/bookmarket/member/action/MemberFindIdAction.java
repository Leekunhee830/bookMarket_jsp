package com.bookmarket.member.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;

public class MemberFindIdAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		MemberDao dao=MemberDao.getInstance();
		
		String user_email=request.getParameter("user_email");
		ArrayList<String> user_ids= dao.findId(user_email);
		request.setAttribute("find_id", user_ids);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("memberFindIdResult.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}

}
