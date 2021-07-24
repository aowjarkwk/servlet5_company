package servlet5_company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class one2oneDao {
	public static int one2oneAction( HttpServletRequest request ) throws SQLException {
		Date time = new Date(); // 현재시간을 가져와 Date형으로 저장한다
		Connection conn = null; //DB연결 클래스
		ResultSet rs = null; //검색결과를 담는 클래스
		Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
		//String custno = request.getParameter("custno");
		String one2one_name = request.getParameter("one2one_name");
		String one2one_phone = request.getParameter("one2one_phone");
		String one2one_email = request.getParameter("one2one_email");
		String one2one_address = request.getParameter("one2one_address");
		String one2one_title = request.getParameter("one2one_title");
		String one2one_content = request.getParameter("one2one_content");
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
		String time1 = format1.format(time);

		String one2one_date = String.valueOf(time1);
		
		conn = DBConnection.getConnection();
		//SQL 문자열 
		//insert into users_table( custno, custname, phone, address, joindate, grade, city ) 
	    //  values ( 1001, '홍길동', '010-2222-3333', '한양', '20210719', 'A', '01' );
		
		String query = "INSERT INTO company_one2one( one2one_idx, one2one_name, one2one_phone, one2one_email, one2one_address,one2one_title,one2one_content,one2one_date  )" + 
				" VALUES ( company_one2one_seq.nextval, "
				+ "'" + one2one_name + "'" + ","
				+ "'" + one2one_phone    + "'" + ","
				+ "'" + one2one_email + "'" + ","
				+ "'" + one2one_address + "'" + ","
				+ "'" + one2one_title + "'" + ","
				+ "'" + one2one_content + "'" + ","
				+ "'" + one2one_date + "'" + ")"; 
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
}
