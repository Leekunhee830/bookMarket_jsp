package com.bookmarket.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;

public class MemberIdCheck {
	
	public int idCheck(HttpServletRequest request, HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		int result=0;
		String user_id=request.getParameter("user_id");
		MemberDao dao=MemberDao.getInstance();
		
		result=dao.checkId(user_id);
		
		return result;
	}
}
