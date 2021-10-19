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
	
	//�� �ֹ��� �߰�
	public boolean add_detail_order(OrderDtailDto dto){
		boolean result=false;
		sql="INSERT INTO order_detail VALUES(?,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getOrder_num());
			ps.setInt(2, dto.getProduct_num());
			ps.setInt(3, dto.getUser_num());
			ps.setString(4, dto.getOrder_phone());
			ps.setString(5, dto.getOrder_home_phone());
			ps.setString(6, dto.getOrder_address());
			ps.setString(7, dto.getOrder_message());
			ps.setInt(8, dto.getOrder_amount());
			ps.setInt(9, dto.getOrder_price());
			
			result=ps.executeUpdate()==1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		
		return result;
		
	}
	
	//���ֹ� ������ ��������
	public int order_seq(){
		sql="SELECT order_detail_seq.NEXTVAL seq_num FROM DUAL";
		int seq=0;
		try {
			
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				seq=rs.getInt("seq_num");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return seq;
	}
}
