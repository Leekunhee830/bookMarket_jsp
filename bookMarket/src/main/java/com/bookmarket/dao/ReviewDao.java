package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bookmarket.dto.review.ReviewAddDto;

public class ReviewDao {
	private static ReviewDao dao;
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
	
	private ReviewDao() {}
	
	public static ReviewDao getInstance() {
		if(dao==null) {
			dao=new ReviewDao();
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
		close(con,ps,null);
	}
	
	//¸®ºäµî·Ï
	public boolean AddReview(ReviewAddDto dto) {
		boolean result=false;
		sql="INSERT INTO review VALUES(review_seq.NEXTVAL,?,?,?,SYSDATE)";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, dto.getUser_num());
			ps.setInt(2, dto.getProduct_num());
			ps.setString(3, dto.getContents());
			
			result=ps.executeUpdate()==1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		
		return result;
	}
}
