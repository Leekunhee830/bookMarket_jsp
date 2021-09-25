package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	
}
