package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bookmarket.dto.ProductDto;

public class ProductDao {
	private static ProductDao dao;
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
	
	private ProductDao() {}
	
	public static ProductDao getInstance() {
		if(dao==null) {
			dao=new ProductDao();
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
	
	//상품추가
	public boolean addProduct(ProductDto dto) {
		boolean result=false;
		sql="INSERT INTO products VALUES(products_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getPd_code());
			ps.setString(2, dto.getPd_name());
			ps.setString(3, dto.getPd_contents());
			ps.setInt(4, dto.getPd_price());
			ps.setInt(5, dto.getPd_amount());
			ps.setString(6, dto.getPd_category());
			ps.setString(7, dto.getPd_manufacturer());
			ps.setInt(8, 0);
			ps.setString(9, dto.getPd_imgName());
			
			result=ps.executeUpdate()==1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		
		return result;
	}
	
	//전체상품 조회
	public ArrayList<ProductDto> allProduct() {
		ArrayList<ProductDto> list=new ArrayList<ProductDto>();
		ProductDto dto=null;
		sql="SELECT * FROM products";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				dto=new ProductDto();
				dto.setPd_num(rs.getInt("pd_num"));
				dto.setPd_code(rs.getString("pd_code"));
				dto.setPd_name(rs.getString("pd_name"));
				dto.setPd_contents(rs.getString("pd_contents"));
				dto.setPd_price(rs.getInt("pd_price"));
				dto.setPd_amount(rs.getInt("pd_amount"));
				dto.setPd_category(rs.getString("pd_category"));
				dto.setPd_manufacturer(rs.getString("pd_manufacturer"));
				dto.setPd_views(rs.getInt("pd_views"));
				dto.setPd_imgName(rs.getString("pd_img"));
				dto.setPd_regdate(rs.getString("pd_regdate"));
				
				list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return list.isEmpty()? null:list;
	}
	
	//상품조회
	public ProductDto selectProduct(int pd_num) {
		ProductDto dto=null;
		sql="SELECT * FROM products WHERE pd_num=? ";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, pd_num);
			rs=ps.executeQuery();
			if(rs.next()) {
				dto=new ProductDto();
				dto.setPd_num(rs.getInt("pd_num"));
				dto.setPd_code(rs.getString("pd_code"));
				dto.setPd_name(rs.getString("pd_name"));
				dto.setPd_contents(rs.getString("pd_contents"));
				dto.setPd_price(rs.getInt("pd_price"));
				dto.setPd_amount(rs.getInt("pd_amount"));
				dto.setPd_category(rs.getString("pd_category"));
				dto.setPd_manufacturer(rs.getString("pd_manufacturer"));
				dto.setPd_views(rs.getInt("pd_views"));
				dto.setPd_imgName(rs.getString("pd_img"));
				dto.setPd_regdate(rs.getString("pd_regdate"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return dto;
	}
	
	//상품삭제
	public int deleteProduct(String pd_code) {
		sql="DELETE FROM products WHERE pd_code=?";
		boolean result=false;
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, pd_code);
			result=ps.executeUpdate()==1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result?1:0;
	}
}
