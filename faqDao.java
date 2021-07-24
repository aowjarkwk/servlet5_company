package servlet5_company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class faqDao {
	public static ArrayList<faqDto> list3() throws SQLException{
		ArrayList<faqDto> list3= new ArrayList<faqDto>();
		
			
			Connection conn = null; //DB연결 클래스
			ResultSet rs = null; //검색결과를 담는 클래스
			Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
			
			conn = DBConnection.getConnection();
			//SQL 문자열 
			String query = "SELECT * FROM company_faq" ;
			System.out.println( query );
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			 
			//next() 다음값이 있는지 T/F 리턴
			while( rs.next() ) {
				
				int faq_idx = rs.getInt("faq_idx");
				String faq_title = rs.getString("faq_title");
				String faq_content = rs.getString("faq_content");



				faqDto dto = new faqDto(faq_idx,faq_title,faq_content);
				list3.add(dto);
				}
		
		return list3;
	}
}
