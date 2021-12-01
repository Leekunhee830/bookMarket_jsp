package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bookmarket.dto.qna.QnaAddDto;
import com.bookmarket.dto.qna.QnaDetailDto;
import com.bookmarket.dto.qna.QnaListDto;

public class QnaDao {
	private static QnaDao dao;
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
	
	private QnaDao() {}
	
	public static QnaDao getInstance() {
		if(dao==null) {
			dao=new QnaDao();
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
	
	//qna등록
	public boolean addQna(QnaAddDto dto) {
		boolean result=false;
		sql="INSERT INTO qna VALUES(qna_seq.NEXTVAL,?,?,?,?,?,SYSDATE)";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, dto.getUser_num());
			ps.setInt(2, dto.getProduct_num());
			ps.setInt(3, dto.getOption_num());
			ps.setString(4, dto.getContents());
			ps.setString(5, dto.getQna_password());
			
			result=ps.executeUpdate()==1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		
		return result;
	}
	
	//qna 목록 가져오기
	public ArrayList<QnaListDto> qnalist(int product_num,int check){
		ArrayList<QnaListDto> list=new ArrayList<QnaListDto>();
		QnaListDto dto=null;
		//최근 Q&A 글 5개 가져오기
		if(check==0) {
			sql="SELECT q.qna_num,q.contents,q.regdate,q.qna_password,m.user_id from qna q "
					+ "INNER JOIN member m ON q.user_num=m.user_num "
					+ "WHERE q.product_num=? AND ROWNUM<=5 "
					+ "ORDER BY q.qna_num DESC";	
		}
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, product_num);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				dto=new QnaListDto();
				dto.setQna_num(rs.getInt("qna_num"));
				dto.setUser_id(rs.getString("user_id"));
				//<p>,<br>태그제거
				String contents=rs.getString("contents").replaceAll("<p>", "").replaceAll("</p>", "").replaceAll("<br>", "");
				dto.setContents(contents);
				dto.setQna_password(rs.getString("qna_password"));
				dto.setRegdate(rs.getTimestamp("regdate"));
				list.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return list.isEmpty()?null:list;
	}
	
	//Q&A 개수
	public int qnaCount(int product_num) {
		int count=0;
		sql="SELECT count(*) FROM qna WHERE product_num=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, product_num);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt("count(*)");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return count;
	}
	
	//Q&A 상세 보기
	public QnaDetailDto detailQna(int qna_num) {
		QnaDetailDto dto=null;
		sql="SELECT q.qna_num,q.option_num,q.contents,q.qna_password,q.regdate,m.user_id from qna q "
				+  "INNER JOIN member m ON q.user_num=m.user_num "
				+  "WHERE q.qna_num=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, qna_num);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				dto=new QnaDetailDto();
				dto.setQna_num(rs.getInt("qna_num"));
				dto.setOption_num(rs.getInt("option_num"));
				dto.setUser_id(rs.getString("user_id"));
				String contents=rs.getString("contents").replaceAll("<p>", "").replaceAll("</p>", "<br>");
				dto.setContents(contents);
				dto.setQna_password(rs.getString("qna_password"));
				dto.setRegdate(rs.getTimestamp("regdate"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {			
			close(con, ps, rs);
		}
		return dto;
	}
	
	//Q&A 패스워드 확인
	public boolean passwordCheck(int qna_num,String password) {
		boolean result=false;
		sql="SELECT * FROM qna WHERE qna_num=? AND qna_password=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, qna_num);
			ps.setString(2, password);
			result=ps.executeUpdate()==1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);			
		}
		return result;
	}
	
	//Q&A 글 삭제
	public boolean deleteQna(int qna_num) {
		boolean result=false;
		sql="DELETE FROM qna WHERE qna_num=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, qna_num);
			result=ps.executeUpdate()==1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
}
