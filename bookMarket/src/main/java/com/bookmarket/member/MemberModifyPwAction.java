package com.bookmarket.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;
import com.bookmarket.util.SHA256;

public class MemberModifyPwAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		boolean result=false;
		String rawPassword=request.getParameter("user_password");
		String user_id=request.getParameter("user_id");
		MemberDao dao=MemberDao.getInstance();
		String password=SHA256.encodeSHA256(rawPassword);
		
		result=dao.memberModifyPw(user_id, password);
		
		request.setAttribute("result", result);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("modifyResultView.jsp");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
