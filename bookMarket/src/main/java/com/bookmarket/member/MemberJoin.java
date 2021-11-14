package com.bookmarket.member;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.MemberDao;
import com.bookmarket.dto.member.MemberDto;
import com.bookmarket.dto.member.MemberJoinDto;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;
import com.bookmarket.util.SHA256;
import com.google.gson.Gson;

public class MemberJoin{
	
	public int member_Join(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boolean result=false;
		BufferedReader br=request.getReader();
		String requestData=br.readLine();
		Gson gson=new Gson();
		
		MemberJoinDto dto=gson.fromJson(requestData, MemberJoinDto.class);
		String password=SHA256.encodeSHA256(dto.getPassword());
		dto.setPassword(password);
		
		MemberDao dao=MemberDao.getInstance();
		result=dao.insert(dto);
		
		return result?1:0;
	}
}	

