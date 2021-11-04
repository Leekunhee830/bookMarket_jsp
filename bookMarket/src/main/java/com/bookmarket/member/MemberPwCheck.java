package com.bookmarket.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.util.SHA256;


public class MemberPwCheck{
	public int pwCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean result=false;
		request.setCharacterEncoding("UTF-8");
		String user_id=request.getParameter("user_id");
		String rawPassword=request.getParameter("user_password");
		String user_pw=SHA256.encodeSHA256(rawPassword);
		MemberDao dao=MemberDao.getInstance();
		
		result=dao.memberCheck(user_id, user_pw);
		
		return result?1:0;
	}
}
