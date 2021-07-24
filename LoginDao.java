package servlet5_company;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;





public class LoginDao {
	
	public static int LoginAction( HttpServletRequest request ) throws SQLException {
		Connection conn = null; //DB연결 클래스
		ResultSet rs = null; //검색결과를 담는 클래스
		Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		conn = DBConnection.getConnection();
		//SQL 문자열 
		String query = "SELECT * FROM company_member WHERE member_id=" +"'"+ member_id +"'";
		System.out.println( query );
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		int result = 0;  //1 : 로그인 성공, 0 : 아이디없음, 2 : 이름없음
		String check_pw = null;
		String check_id = null;
		//next() 다음값이 있는지 T/F 리턴
		while( rs.next() ) {
			check_pw = rs.getString("member_pw");
			check_id = rs.getString("member_id");
			System.out.println( "check_pw:" + check_pw );
			System.out.println( "check_id:" + check_id );
			if( check_id.equals( member_id ) ) {
				//아이디와 이름 모두 동일
				System.out.println("로그인 성공!");
				//세션에 저장
				HttpSession session = request.getSession();
				session.setAttribute("check_pw", check_pw);
				session.setAttribute("member_id", member_id);
				result = 1;
			}else {
				//이름만 틀림
				result = 2; //이름 없음.
			}
		}
		return result;
	}
	public static int joinFirst( HttpServletRequest request ) throws SQLException {
		Connection conn = null; //DB연결 클래스
		ResultSet rs = null; //검색결과를 담는 클래스
		Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
		String member_name = request.getParameter("member_name");
		String member_email = request.getParameter("member_email");
		conn = DBConnection.getConnection();
		//SQL 문자열 
		String query = "SELECT * FROM company_member WHERE member_email=" +"'"+ member_email +"'";
		System.out.println( query );
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		int result = 0;  //1 : 로그인 성공, 0 : 아이디없음, 2 : 이름없음
		String check_name = null;
		String check_email = null;
		//next() 다음값이 있는지 T/F 리턴
		while( rs.next() ) {
			check_name = rs.getString("member_name");
			check_email = rs.getString("member_email");
			System.out.println( "check_name:" + check_name );
			System.out.println( "check_email:" + check_email );
			if( check_email.equals( member_email ) ) {
				//아이디와 이름 모두 동일
				System.out.println("이미 가입한회원");
				//세션에 저장
				HttpSession session = request.getSession();
				session.setAttribute("check_name", check_name);
				session.setAttribute("check_email", check_email);
				result = 2;
			}else {
				//이름만 틀림
				result = 1; //이름 없음.
			}
		}
		return result;
	}public static int joinMember( HttpServletRequest request ) throws UnsupportedEncodingException {
		Connection conn = null; //DB연결 클래스
		ResultSet rs = null; //검색결과를 담는 클래스
		Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
		//String custno = request.getParameter("custno");
		Date time = new Date();
		
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		String member_name = request.getParameter("member_name");
		String member_email = request.getParameter("member_email");
		String member_email_receive = request.getParameter("member_email_receive");
		String member_pw_question = request.getParameter("member_pw_question");
		String member_pw_answer = request.getParameter("member_pw_answer");
		String member_gender = request.getParameter("member_gender");
		String member_birth_date = request.getParameter("member_birth_date");
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");

		String time1 = format1.format(time);

		String member_join_date = String.valueOf(time1);
	
		conn = DBConnection.getConnection();
//		 member_idx       number(4) primary key,
//		    member_id      varchar2(20),
//		    member_pw     varchar2(20),
//		    member_name   varchar2(20),
//		    member_email   varchar2(100),
//		    member_email_receive   number(1),	--0: 비수신 1: 수신
//		    member_pw_question   number(4),
//		    member_pw_answer   varchar2(100),
//		    member_gender   varchar2(10),
//		    member_birth_date      date,
//		    member_join_date      date default sysdate
//		);
		//SQL 문자열 
		//insert into users_table( custno, custname, phone, address, joindate, grade, city ) 
	    //  values ( 1001, '홍길동', '010-2222-3333', '한양', '20210719', 'A', '01' );
		String query = "insert into company_member(member_idx, member_id, member_pw, member_name, member_email, member_email_receive, member_pw_question, member_pw_answer, member_gender, member_birth_date, member_join_date)" + 
				" VALUES ( company_member_seq.nextval, "
				+ "'" + member_id + "'" + ","
				+ "'" + member_pw    + "'" + ","
				+ "'" + member_name + "'" + ","
				+ "'" + member_email + "'" + ","
				+ "'" + member_email_receive + "'" + ","
				+ "'" + member_pw_question + "'" + ","
				+ "'" + member_pw_answer + "'" + ","
				+ "'" + member_gender + "'" + ","
				+ "'" + member_birth_date + "'" + ","
				+ "'" + member_join_date + "'" + ")"; //세미콜로 없애면 됨.
		//INSERT INTO users_table( custno, custname, phone, address, joindate, grade, city ) 
		//VALUES ( users_table_seq.nextval, '홍길동','010-1111-2222','강남구','2021-07-19','A','01');
		System.out.println( "query:" + query);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery( query );
			conn.commit(); //실제 DB에 확정
			//dual테이블 
			//
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 2; //실패
		}
		return 1; //성공
	}
	public static int idCheck( HttpServletRequest request ) throws SQLException {
		Connection conn = null; //DB연결 클래스
		ResultSet rs = null; //검색결과를 담는 클래스
		Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
		String member_id = request.getParameter("member_id");
		conn = DBConnection.getConnection();
		//SQL 문자열 
		String query = "SELECT * FROM company_member WHERE member_id=" +"'"+ member_id +"'";
		System.out.println( query );
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		int result = 0;  //1 : 로그인 성공, 0 : 아이디없음, 2 : 이름없음
		if (rs.next()) {

			result = 1;

		} else { // 아이디 없으면 0 반환

			result = 0;

		}return result;

	}public static int emailCheck( HttpServletRequest request ) throws SQLException {
		Connection conn = null; //DB연결 클래스
		ResultSet rs = null; //검색결과를 담는 클래스
		Statement stmt = null; //쿼리(SQL)을 전송하는 클래스
		String member_email = request.getParameter("member_email");
		conn = DBConnection.getConnection();
		//SQL 문자열 
		String query = "SELECT * FROM company_member WHERE member_email=" +"'"+ member_email +"'";
		System.out.println( query );
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		int result = 0;  //1 : 로그인 성공, 0 : 아이디없음, 2 : 이름없음
		if (rs.next()) {

			result = 1;

		} else { // 아이디 없으면 0 반환

			result = 0;

		}return result;

	}

	}

	
	



