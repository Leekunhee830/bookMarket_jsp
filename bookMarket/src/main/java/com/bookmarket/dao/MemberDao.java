package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bookmarket.dto.MemberDto;

public class MemberDao {
	private static MemberDao dao;
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
	
	private MemberDao() {}
	
	public static MemberDao getInstance() {
		if(dao==null) {
			dao=new MemberDao();
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
	
	//회원가입
	public boolean insert(MemberDto dto) {
		boolean result=false;
		sql="INSERT INTO member VALUES(member_seq.NEXTVAL,?,?,?,?,?,SYSDATE)";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getEmail());
			ps.setString(5, dto.getPhone());
			
			result=ps.executeUpdate()==1;
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
	
		return result;
	}
	
	//로그인
	public MemberDto login(String user_id,String user_password) {
		MemberDto dto=null;
		sql="SELECT * FROM member WHERE id=? AND password=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, user_password);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				dto=new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setRegdate(rs.getString("regdate"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return dto;
	}
	
	//아이디찾기
	public ArrayList<String> findId(String user_email) {
		ArrayList<String> find_user_id=new ArrayList<String>(); 
		String id=null;
		sql="SELECT id FROM member WHERE email=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_email);
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				id=rs.getString("id");
				find_user_id.add(id);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return find_user_id.isEmpty() ? null:find_user_id;
	}
	
	//비밀번호찾기
	public boolean findPw(String user_id,String user_email) {
		boolean result=false;
		sql="SELECT * FROM member WHERE id=? AND email=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, user_email);
			result=ps.executeUpdate()==1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	
	//비밀번호 변경
	public boolean modifyPw(String user_id,String user_email,String ranPw) {
		boolean result=false;
		sql="UPDATE member SET password=? WHERE id=? AND email=?";
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, ranPw);
			ps.setString(2, user_id);
			ps.setString(3, user_email);
			
			result=ps.executeUpdate()==1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	
	//마이페이지
	public MemberDto myPage(String currentId) {
		MemberDto dto=null;
		sql="SELECT * FROM member WHERE id=?";
	
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, currentId);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setRegdate(rs.getString("regdate"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return dto;
	}
	
	//회원정보 수정
	public boolean memberModify(int num,String user_password) {
		boolean result=false;
		sql="UPDATE member SET password=? WHERE num=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_password);
			ps.setInt(2, num);
			result=ps.executeUpdate()==1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	
	//회원탈퇴
	public boolean memberSignout(String user_id,String user_password) {
		boolean result=false;
		sql="DELETE FROM member WHERE id=? AND password=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, user_password);
			result=ps.executeUpdate()==1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	
	//모든 회원 정보
	public ArrayList<MemberDto> allSelect(){
		ArrayList<MemberDto> list=new ArrayList<MemberDto>();
		MemberDto dto=null;
		String tmpPassword;
		int passwordIndex=0;
		
		
		sql="SELECT * FROM member";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				dto=new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setId(rs.getString("id"));
				
				tmpPassword=rs.getString("password");
				passwordIndex=tmpPassword.length()-2;
				tmpPassword=tmpPassword.substring(0,2);
				while(passwordIndex>0) {
					tmpPassword+="*";
					--passwordIndex;
				}
				
				dto.setPassword(tmpPassword);
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				dto.setRegdate(rs.getString("regdate"));
				list.add(dto);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return list.isEmpty()? null:list;
	}
	
	//중복아이디검사
	public int checkId(String user_id) {
		int result=0;
		sql="SELECT id FROM member WHERE id=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_id);
			result=ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
}
