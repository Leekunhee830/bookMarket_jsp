package com.bookmarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.bookmarket.dto.member.MemberBuyDto;
import com.bookmarket.dto.member.MemberDto;
import com.bookmarket.dto.member.MemberJoinDto;

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
	public boolean insert(MemberJoinDto dto) {
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
		sql="SELECT * FROM member WHERE user_id=? AND user_password=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, user_password);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				dto=new MemberDto();
				dto.setNum(rs.getInt("user_num"));
				dto.setId(rs.getString("user_id"));
				dto.setPassword(rs.getString("user_password"));
				dto.setName(rs.getString("user_name"));
				dto.setEmail(rs.getString("user_email"));
				dto.setPhone(rs.getString("user_phone"));
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
		sql="SELECT user_id FROM member WHERE user_email=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_email);
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				id=rs.getString("user_id");
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
		sql="SELECT * FROM member WHERE user_id=? AND user_email=?";
		
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
	
	//임시 비밀번호로 변경
	public boolean modifyPw(String user_id,String user_email,String ranPw) {
		boolean result=false;
		sql="UPDATE member SET user_password=? WHERE user_id=? AND user_email=?";
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
	public MemberDto myPage(int currentNum) {
		MemberDto dto=null;
		sql="SELECT * FROM member WHERE user_num=?";
	
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, currentNum);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				dto=new MemberDto();
				dto.setNum(rs.getInt("user_num"));
				dto.setId(rs.getString("user_id"));
				dto.setPassword(rs.getString("user_password"));
				dto.setName(rs.getString("user_name"));
				dto.setEmail(rs.getString("user_email"));
				dto.setPhone(rs.getString("user_phone"));
				dto.setRegdate(rs.getString("regdate"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		
		return dto;
	}
	
	//비밀번호 수정
	public boolean memberModifyPw(String user_id,String user_password) {
		boolean result=false;
		sql="UPDATE member SET user_password=? WHERE user_id=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_password);
			ps.setString(2, user_id);
			result=ps.executeUpdate()==1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		return result;
	}
	
	//회원탈퇴
	public boolean signout(String user_id,String user_password) {
		boolean result=false;
		sql="DELETE FROM member WHERE user_id=? AND user_password=?";
		
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
				dto.setNum(rs.getInt("user_num"));
				dto.setId(rs.getString("user_id"));
				dto.setName(rs.getString("user_name"));
				dto.setEmail(rs.getString("user_email"));
				dto.setPhone(rs.getString("user_phone"));
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
		sql="SELECT user_id FROM member WHERE user_id=?";
		
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
	
	//회원 아이디,비번 확인
	public boolean memberCheck(String user_id,String user_password) {
		boolean result=false;
		sql="SELECT * FROM member WHERE user_id=? AND user_password=?";
		
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
	
	//구매 회원 정보 가져오기
	public MemberBuyDto getMemberInfo(int user_num) {
		MemberBuyDto dto=null;
		sql="SELECT user_num,user_id,user_name,user_email,user_phone FROM member WHERE user_num=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, user_num);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				dto=new MemberBuyDto();
				dto.setUser_num(rs.getInt("user_num"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_email(rs.getString("user_email"));
				dto.setUser_phone(rs.getString("user_phone"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps, rs);
		}
		return dto;
	}

	//카카오 아이디 가입확인
	public boolean kakaoIdck(String user_id) {
		boolean result=false;
		sql="SELECT * FROM kakao_member WHERE id=?";
		
		try {
			con=ds.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user_id);
			
			result=ps.executeUpdate()==1;
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, ps);
		}
		
		return result;
	}
	
}
