package servlet5_company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;



public class qnaDao {
	public static ArrayList<qnaDto> list2() throws SQLException{
		ArrayList<qnaDto> list2 = new ArrayList<qnaDto>();
		
			
			Connection conn = null; //DB연결 클래스
			ResultSet rs = null; //검색결과를 담는 클래스
			Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
			
			conn = DBConnection.getConnection();
			//SQL 문자열 
			String query = "SELECT * FROM company_qna" ;
			System.out.println( query );
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			//next() 다음값이 있는지 T/F 리턴
			while( rs.next() ) {
				
				int qna_idx = rs.getInt("qna_idx");
				String qna_name = rs.getString("qna_name");
				String qna_pw = rs.getString("qna_pw");
				String qna_title = rs.getString("qna_title");
				String qna_content = rs.getString("qna_content");
				String qna_date = rs.getString("qna_date");


				qnaDto dto = new qnaDto(qna_idx,qna_name,qna_pw,qna_title,qna_content,qna_date);
				list2.add(dto);
				}
		
		return list2;
	}
	public static qnaDto Info(String qna_idx) throws SQLException {
		qnaDto dto = new qnaDto();
	
		Connection conn = null; //DB연결 클래스
		ResultSet rs = null; //검색결과를 담는 클래스
		Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
		conn = DBConnection.getConnection();
		//SQL 문자열 
		String query = "SELECT * FROM company_qna where qna_idx="+qna_idx ;
		System.out.println( query );
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		
		//next() 다음값이 있는지 T/F 리턴
		while( rs.next() ) {
			dto.setQna_idx(rs.getInt("qna_idx"));
			dto.setQna_name(rs.getString("qna_name"));
			dto.setQna_pw(rs.getString("qna_pw"));
			dto.setQna_title(rs.getString("qna_title"));
			dto.setQna_content(rs.getString("qna_content"));
			dto.setQna_date(rs.getString("qna_date"));
		
			}


	return dto;
}public static int qnaWriteAction( HttpServletRequest request ) throws SQLException {
	Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
	Connection conn = null; //DB연결 클래스
	ResultSet rs = null; //검색결과를 담는 클래스
	Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
	//String custno = request.getParameter("custno");
	String qna_name = request.getParameter("qna_name");
	String qna_pw = request.getParameter("qna_pw");
	String qna_title = request.getParameter("qna_title");
	String qna_content = request.getParameter("qna_content");
	Date qna_date = date_now;
	
	conn = DBConnection.getConnection();
	//SQL 문자열 
	//insert into users_table( custno, custname, phone, address, joindate, grade, city ) 
    //  values ( 1001, '홍길동', '010-2222-3333', '한양', '20210719', 'A', '01' );
	
	String query = "INSERT INTO company_qna( qna_idx, qna_name, qna_pw, qna_title, qna_content, qna_date)" + 
			" VALUES ( company_qna_seq.nextval, "
			+ "'" + qna_name + "'" + ","
			+ "'" + qna_pw    + "'" + ","
			+ "'" + qna_title + "'" + ","
			+ "'" + qna_content + "'" + ","
			+ "'" + qna_date + "'" + ")"; 
	//INSERT INTO users_table( custno, custname, phone, address, joindate, grade, city ) 
	//VALUES ( users_table_seq.nextval, '홍길동','010-1111-2222','강남구','2021-07-19','A','01');
	System.out.println( "query:" + query);
	try {
		stmt = conn.createStatement();
		rs = stmt.executeQuery( query );
		conn.commit(); //실제 DB에 확정
		//dual테이블 
		//
		
//		
	} catch (SQLException e) {
		e.printStackTrace();
		return 2; //실패
	}
	return 1; //성공
}
public static int pwConfirm( HttpServletRequest request ) throws SQLException {
	Connection conn = null; //DB연결 클래스
	ResultSet rs = null; //검색결과를 담는 클래스
	Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
	String qna_idx = request.getParameter("qna_idx");
	String qna_pw = request.getParameter("qna_pw");
	conn = DBConnection.getConnection();
	System.out.println("qna_idx:"+qna_idx);
	System.out.println("qna_pw:"+qna_pw);
	//SQL 문자열 SELECT * FROM Customers
	
	String query = "SELECT * FROM company_qna WHERE qna_pw=" +"'"+ qna_pw +"'" +"and qna_idx="+"'"+qna_idx+"'";
	System.out.println( query );
	stmt = conn.createStatement();
	rs = stmt.executeQuery(query);
	int result = 0;  //1 : 로그인 성공, 0 : 아이디없음, 2 : 이름없음
	if (rs.next()) {

		result = 0;  //틀림

	} else { // 아이디 없으면 0 반환

		result = 1; //맞음

	}return result;

}
public static qnaDto Info1(String qna_idx) throws SQLException {
	qnaDto dto = new qnaDto();

	Connection conn = null; //DB연결 클래스
	ResultSet rs = null; //검색결과를 담는 클래스
	Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
	conn = DBConnection.getConnection();
	//SQL 문자열 
	String query = "SELECT * FROM company_qna where qna_idx="+qna_idx ;
	System.out.println( query );
	stmt = conn.createStatement();
	rs = stmt.executeQuery(query);
	
	//next() 다음값이 있는지 T/F 리턴
	while( rs.next() ) {
		dto.setQna_idx(rs.getInt("qna_idx"));
		dto.setQna_name(rs.getString("qna_name"));
		dto.setQna_pw(rs.getString("qna_pw"));
		dto.setQna_title(rs.getString("qna_title"));
		dto.setQna_content(rs.getString("qna_date"));
		dto.setQna_date(rs.getString("qna_date"));
		
		}


return dto;
}public static int Update( HttpServletRequest request ) throws SQLException {
	Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
	Connection conn = null; //DB연결 클래스
	ResultSet rs = null; //검색결과를 담는 클래스
	Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
	//String custno = request.getParameter("custno");
	String qna_idx = request.getParameter("qna_idx");
	String qna_name = request.getParameter("qna_name");
	
	String qna_pw = request.getParameter("qna_pw");
	String qna_title = request.getParameter("qna_title");
	String qna_content = request.getParameter("qna_content");
	Date qna_date = date_now;
	
	conn = DBConnection.getConnection();
	//SQL 문자열 
	//insert into users_table( custno, custname, phone, address, joindate, grade, city ) 
    //  values ( 1001, '홍길동', '010-2222-3333', '한양', '20210719', 'A', '01' );
	
	String query = "UPDATE company_qna SET qna_name=" + "'" + qna_name +"'" + "," +
			"qna_pw=" + "'" + qna_pw +"'" + "," +
			"qna_title=" + "'" + qna_title +"'" + "," +
			"qna_content=" + "'" + qna_content +"'" +","+
			"qna_date=" + "'" + qna_date +"'" +
			"WHERE qna_idx=" + qna_idx;
System.out.println( "query:" + query);
try {
stmt = conn.createStatement();
rs = stmt.executeQuery( query );
conn.commit(); //실제 DB에 확정
} catch (SQLException e) {
e.printStackTrace();
return 2; //실패
}
return 1; //성공
}//end of writing
public static int deleteAction(HttpServletRequest request) {
	Date date_now = new Date(System.currentTimeMillis()); // 현재시간을 가져와 Date형으로 저장한다
	Connection conn = null; //DB연결 클래스
	ResultSet rs = null; //검색결과를 담는 클래스
	Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
	//String custno = request.getParameter("custno");
	String qna_idx = request.getParameter("qna_idx");
	String qna_name = request.getParameter("qna_name");
	
	String qna_pw = request.getParameter("qna_pw");
	String qna_title = request.getParameter("qna_title");
	String qna_content = request.getParameter("qna_content");
	Date qna_date = date_now;
	
	conn = DBConnection.getConnection();
	//SQL 문자열 
	//insert into users_table( custno, custname, phone, address, joindate, grade, city ) 
    //  values ( 1001, '홍길동', '010-2222-3333', '한양', '20210719', 'A', '01' );


	String query = "DELETE FROM company_qna WHERE qna_idx=" + "'"+qna_idx+"'";
			
System.out.println( "query:" + query);
try {
stmt = conn.createStatement();
rs = stmt.executeQuery( query );
conn.commit(); //실제 DB에 확정
} catch (SQLException e) {
e.printStackTrace();
return 2; //실패
}
return 1; //성공
}
}
