package com.bookmarket.kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dto.kakao.OAuthToken;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;
import com.google.gson.Gson;



public class KakaoTokenAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String authorize_code=request.getParameter("code");
		String client_id="e6438c922f7b9530b1f4308a8f0c0154";
		String redirect_uri="http://localhost:8002/bookMarket/kakaoLogin.ka";
		String code=authorize_code;
		
		URL url=new URL("https://kauth.kakao.com/oauth/token");
		String bodyData="grant_type=authorization_code";
		bodyData+="&client_id="+client_id;
		bodyData+="&redirect_uri="+redirect_uri;
		bodyData+="&code="+code;
		
		HttpsURLConnection conn=(HttpsURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
		
		bw.write(bodyData);
		bw.flush();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String input="";
		StringBuilder sb=new StringBuilder();
		while((input=br.readLine())!=null) {
			sb.append(input);
		}
		
		Gson gson=new Gson();
		OAuthToken oauthToken=gson.fromJson(sb.toString(), OAuthToken.class);
		request.setAttribute("OAuthToken", oauthToken);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/kakao/kakaoProfile.ka");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
