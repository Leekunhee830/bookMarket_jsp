package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bookmarket.dto.OrderDetailDto;
import com.bookmarket.dto.order.OrderAddDto;
import com.bookmarket.dto.order.OrderListDto;

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
	public boolean add_detail_order(OrderAddDto dto){
		boolean result=false;
		sql="INSERT INTO order_detail VALUES(?,?,?,?,?,?,?,?,1,SYSDATE)";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getOrder_num());
			ps.setInt(2, dto.getUser_num());
			ps.setInt(3, dto.getProd_num());
			ps.setString(4, dto.getOrder_name());
			ps.setString(5, dto.getOrder_phone());
			ps.setString(6, dto.getOrder_address());
			ps.setString(7, dto.getOrder_message());
			ps.setInt(8, dto.getOrder_price());
			
			result=ps.executeUpdate()==1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		
		return result;
	}
	
	//상세주문 시퀀스 가져오기
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
	
	//전체구매내역 가져오기
	public ArrayList<OrderListDto> getOrderList(int user_num){
		ArrayList<OrderListDto> list=new ArrayList<OrderListDto>();
		OrderListDto dto=null;
		sql="SELECT od.order_num,pd.pd_num,pd.pd_name,pd.pd_img,od.regdate,pd.pd_price,od.order_result"
				+ " FROM order_detail od INNER JOIN products pd"
				+ " ON(pd.pd_num=od.prod_num) WHERE user_num=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, user_num);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				dto=new OrderListDto();
				dto.setOrder_num(rs.getString("order_num"));
				dto.setProd_num(rs.getInt("pd_num"));
				dto.setProd_name(rs.getString("pd_name"));
				dto.setOrder_price(rs.getInt("pd_price"));
				dto.setRegdate(rs.getTimestamp("regdate"));
				dto.setOrder_result(rs.getInt("order_result"));
				dto.setProd_img(rs.getString("pd_img"));
				list.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return list.isEmpty()?null:list;
	}
	
	//주문 상세 내역 가져오기
		public OrderDetailDto  getOrder_detail(String order_num){
			sql="SELECT * FROM order_detail WHERE order_num=?";
			OrderDetailDto dto=null;
			
			try {
				con=ds.getConnection();
				ps=con.prepareStatement(sql);
				ps.setString(1, order_num);
				rs=ps.executeQuery();
				
				if(rs.next()) {
					dto=new OrderDetailDto();
					dto.setOrder_num(rs.getString("order_num"));
					dto.setProduct_num(rs.getInt("product_num"));
					dto.setUser_num(rs.getInt("user_num"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setProduct_img(rs.getString("product_img"));
					dto.setOrder_name(rs.getString("order_name"));
					dto.setOrder_phone(rs.getString("order_phone"));
					dto.setOrder_home_phone(rs.getString("order_home_phone"));
					dto.setOrder_address(rs.getString("order_address"));
					dto.setOrder_message(rs.getString("order_message"));
					dto.setOrder_amount(rs.getInt("order_amount"));
					dto.setOrder_price(rs.getInt("order_price"));
					dto.setOrder_result(rs.getInt("order_result"));
					dto.setRegdate(rs.getString("regdate"));
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(con, ps, rs);
			}
			return dto;
		}
}
