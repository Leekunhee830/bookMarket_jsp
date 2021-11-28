package com.bookmarket.qna;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.QnaDao;
import com.bookmarket.dto.qna.QnaAddDto;
import com.google.gson.Gson;

public class AddQna {
	public int add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boolean result=false;
		BufferedReader br=request.getReader();
		String requestData=br.readLine();
		Gson gson=new Gson();
		QnaAddDto dto=gson.fromJson(requestData, QnaAddDto.class);
		
		QnaDao dao=QnaDao.getInstance();
		result=dao.addQna(dto);
		
		return result?1:0;
	}
}
