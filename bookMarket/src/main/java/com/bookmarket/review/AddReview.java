package com.bookmarket.review;

import java.io.BufferedReader;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dao.ReviewDao;
import com.bookmarket.dto.review.ReviewAddDto;
import com.google.gson.Gson;



public class AddReview {
	public int add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		boolean result=false;
		BufferedReader br=request.getReader();
		String requestData=br.readLine();
		Gson gson=new Gson();
		
		ReviewAddDto dto=gson.fromJson(requestData, ReviewAddDto.class);
		
		ReviewDao dao=ReviewDao.getInstance();
		result=dao.addReview(dto);

		return result?1:0;
	}
}
