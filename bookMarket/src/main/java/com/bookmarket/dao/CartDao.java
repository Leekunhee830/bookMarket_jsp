package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bookmarket.dto.cart.CartAllDto;

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
	
	//장바구니 중복 확인
	public boolean checkCart(int user_num,int product_num) {
		sql="SELECT * FROM cart WHERE user_num=? AND product_num=?";
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
	
	//모든장바구니 목록 가져오기
	public ArrayList<CartAllDto> all_Cart(int user_num){
		ArrayList<CartAllDto> list=new ArrayList<CartAllDto>();
		CartAllDto dto=null;
		sql="SELECT cart.user_num,cart.product_num,products.pd_name,products.pd_manufacturer,products.pd_price,products.pd_img,cart.regdate "
				+ "FROM cart INNER JOIN products "
				+ "ON products.pd_num=cart.product_num where user_num=?";
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, user_num);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				dto=new CartAllDto();
				dto.setUser_num(rs.getInt("user_num"));
				dto.setPd_num(rs.getInt("product_num"));
				dto.setPd_name(rs.getString("pd_name"));
				dto.setPd_manufacturer(rs.getString("pd_manufacturer"));
				dto.setPd_price(rs.getInt("pd_price"));
				dto.setPd_img(rs.getString("pd_img"));
				dto.setRegdate(rs.getString("regdate"));
				list.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return list.isEmpty()?null:list;
	}
	
	//장바구니 삭제
	public boolean deleteCart(int user_num,int pd_num) {
		boolean result=false;
		sql="DELETE FROM cart WHERE user_num=? AND product_num=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, user_num);
			ps.setInt(2, pd_num);
			result=ps.executeUpdate()==1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	
	//유저 장바구니 상품 번호 가져오기
	public ArrayList<Integer> getProdNum(int user_num){
		ArrayList<Integer> list=new ArrayList<Integer>();
		int prodNum=0;
		sql="SELECT product_num FROM cart WHERE user_num=?";
		
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, user_num);
			rs=ps.executeQuery();
			while(rs.next()) {
				prodNum=rs.getInt("product_num");
				list.add(prodNum);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return list.isEmpty()?null:list;
	}
}
