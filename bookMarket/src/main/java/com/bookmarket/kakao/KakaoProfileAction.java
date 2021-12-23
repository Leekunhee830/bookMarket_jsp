package com.bookmarket.kakao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmarket.dto.kakao.KakaoUser;
import com.bookmarket.dto.kakao.OAuthToken;
import com.bookmarket.util.Action;
import com.bookmarket.util.ActionForward;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class KakaoProfileAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OAuthToken oauthToken= (OAuthToken)request.getAttribute("OAuthToken");
		URL url=new URL("https://kapi.kakao.com/v2/user/me");
		
		HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Bearer "+oauthToken.getAccess_token());
		conn.setDoOutput(true);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String input="";
		StringBuilder sb=new StringBuilder();
		while((input=br.readLine())!=null) {
			sb.append(input);
		}
		
		Gson gson=new Gson();
		
		JsonParser parser=new JsonParser();
		JsonElement element=parser.parse(sb.toString());
		
		int id=element.getAsJsonObject().get("id").getAsInt();
		JsonObject properites=element.getAsJsonObject().get("properties").getAsJsonObject();
		KakaoUser kakaoUser=gson.fromJson(properites, KakaoUser.class);
		kakaoUser.setId(id);
		
		request.setAttribute("kakaoUser", kakaoUser);
		
		ActionForward actionForward=new ActionForward();
		actionForward.setNextPath("/kakao/kakaoFindId.ka");
		actionForward.setRedirect(false);
		
		return actionForward;
	}
}
