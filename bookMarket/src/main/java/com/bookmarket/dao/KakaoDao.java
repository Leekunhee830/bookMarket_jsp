package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bookmarket.dto.member.MemberDto;

public class KakaoDao {
	private static KakaoDao dao;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	private static DataSource ds;
	
	static {
		try {
			System.out.println("start DBCP");
			Context context=new InitialContext();
			ds=(DataSource)context.lookup("java:comp/env/jdbc/oracle");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private KakaoDao() {}
	
	public static KakaoDao getInstance() {
		if(dao==null) {
			dao=new KakaoDao();
		}
		return dao;
	}
	
	private static void close(Connection con,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(con!=null) {
				con.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con,PreparedStatement ps) {
		close(con, ps, null);
	}
	
	public MemberDto kakaofindId(int kakaoId) {
		MemberDto dto=null;
		sql="SELECT user_num,user_name FROM member WHERE kakaoId=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, kakaoId);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto=new MemberDto();
				dto.setNum(rs.getInt("user_num"));
				dto.setName(rs.getString("user_name"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
}
