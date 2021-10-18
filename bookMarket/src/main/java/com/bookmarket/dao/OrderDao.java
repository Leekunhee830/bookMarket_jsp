package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bookmarket.dto.OrderDtailDto;

public class OrderDao {
	private static OrderDao dao;
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
	
	private OrderDao() {}
	
	public static OrderDao getInstance() {
		if(dao==null) {
			dao=new OrderDao();
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
	
	//상세 주문서 추가
	public boolean add_order_detail(OrderDtailDto dto){
		boolean result=false;
		sql="INSERT INTO order_detail VALUES(order_detail_seq.NEXTVAL,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, dto.getProduct_num());
			ps.setInt(2, dto.getUser_num());
			ps.setString(3, dto.getOrder_phone());
			ps.setString(4, dto.getOrder_home_phone());
			ps.setString(5, dto.getOrder_address());
			ps.setString(6, dto.getOrder_message());
			ps.setInt(7, dto.getOrder_amount());
			ps.setInt(8, dto.getOrder_price());
			
			result=ps.executeUpdate()==1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		
		return result;
		
	}
	
}
