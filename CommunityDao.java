package servlet5_company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CommunityDao {
	public static ArrayList<CommunityDto> list() throws SQLException{
		ArrayList<CommunityDto> list = new ArrayList<CommunityDto>();
		
			
			Connection conn = null; //DB연결 클래스
			ResultSet rs = null; //검색결과를 담는 클래스
			Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
			
			conn = DBConnection.getConnection();
			//SQL 문자열 
			String query = "SELECT * FROM company_notice" ;
			System.out.println( query );
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			//next() 다음값이 있는지 T/F 리턴
			while( rs.next() ) {
				
				int notice_idx = rs.getInt("notice_idx");
				String notice_title = rs.getString("notice_title");
				String notice_content = rs.getString("notice_content");
				String notice_member_id = rs.getString("notice_member_id");
				String notice_date = rs.getString("notice_date");
				
				CommunityDto dto = new CommunityDto(notice_idx,notice_title,notice_content,notice_member_id,notice_date);
				list.add(dto);
				}
		
		return list;
	}
	public static CommunityDto Info(String notice_idx) throws SQLException {
		CommunityDto dto = new CommunityDto();
	
		Connection conn = null; //DB연결 클래스
		ResultSet rs = null; //검색결과를 담는 클래스
		Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
		conn = DBConnection.getConnection();
		//SQL 문자열 
		String query = "SELECT * FROM company_notice where notice_idx="+notice_idx ;
		System.out.println( query );
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		
		//next() 다음값이 있는지 T/F 리턴
		while( rs.next() ) {
			dto.setNotice_idx(rs.getInt("notice_idx"));
			dto.setNotice_title(rs.getString("notice_title"));
			dto.setNotice_content(rs.getString("notice_content"));
			dto.setNotice_member_id(rs.getString("notice_member_id"));
			dto.setNotice_date(rs.getString("notice_date"));
		
			}


	return dto;
}
}
