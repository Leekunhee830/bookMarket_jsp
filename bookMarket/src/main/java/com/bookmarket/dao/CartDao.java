package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CartDao {
	private static CartDao dao;
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
	
	private CartDao() {}
	
	public static CartDao getInstance() {
		if(dao==null) {
			dao=new CartDao();
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
	
	//카트추가
	public boolean addCart(int user_num,int product_num) {
		sql="INSERT INTO cart VALUES(cart_seq.NEXTVAL,?,?,SYSDATE)";
		boolean result=false;
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, user_num);
			ps.setInt(2, product_num);
			result=ps.executeUpdate()==1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		
		return result;
	}
}
