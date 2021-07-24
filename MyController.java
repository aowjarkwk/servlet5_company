package servlet5_company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet(urlPatterns= {"/", "*.do"})
public class MyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String requestURI = request.getRequestURI();
		int cmdIndex = requestURI.lastIndexOf("/")+1;
		String command = requestURI.substring(cmdIndex); 
		if(command.equals("")||command.equals("/")) {
			response.sendRedirect("index");
			System.out.println(requestURI);
		}else if(command.equals("index")) {
			RequestDispatcher dp = request.getRequestDispatcher("/index/index.jsp");
			dp.forward(request, response);
		}else if(command.equals("login")) {
			RequestDispatcher dp = request.getRequestDispatcher("/member/login.jsp");
			dp.forward(request, response);
		}
		else if(command.equals("join")) {
			RequestDispatcher dp = request.getRequestDispatcher("/member/join.jsp");
			dp.forward(request, response);
		}else if(command.equals("LoginAction")) {
			request.setCharacterEncoding("utf-8");
			//아이디,이름으로 로그인 처리를 해줌.
			
			int result = 0;//1 : 로그인 성공, 0:아이디가 없음 , 2:이름없음
			
			try {
				result = LoginDao.LoginAction(request);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result == 1) { //성공
				response.sendRedirect("index");
			}else if(result ==0 ||result==2) { //실패
				response.sendRedirect("login");
			}
			
			
		}else if(command.equals("logoutAction")) {
			HttpSession session = request.getSession();
			session.invalidate(); //세션 종료
			response.sendRedirect("index");
			
		}else if(command.equals("joinFirst")) {
			request.setCharacterEncoding("utf-8");
			RequestDispatcher dp = request.getRequestDispatcher("/member/join.jsp");
			dp.forward(request, response);
			
			
		}
		else if(command.equals("join2")) {
			RequestDispatcher dp = request.getRequestDispatcher("/member/join2.jsp");
			dp.forward(request, response);
			
	}else if(command.equals("join3")) {
		RequestDispatcher dp = request.getRequestDispatcher("/member/join3.jsp");
		dp.forward(request, response);
		
	}else if(command.equals("join2?checkbox1=on&checkbox2=on&checkbox3=on")) {
		RequestDispatcher dp = request.getRequestDispatcher("/member/join3.jsp");
		dp.forward(request, response);
		
	}		
	else if(command.equals("idCheck")) {
		
		try {
			if(LoginDao.idCheck(request)==1) {
				response.getWriter().print("1"); //중복
			}else {
				response.getWriter().print("0");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else if(command.equals("emailCheck")) {
		
		try {
			if(LoginDao.emailCheck(request)==1) {
				response.sendRedirect("wndqhr"); //중복
			}else {
				response.sendRedirect("join2");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else if(command.equals("wndqhr")) {
		RequestDispatcher dp = request.getRequestDispatcher("/member/wndqhr.jsp");
		dp.forward(request, response);

	}
	else if(command.equals("joinAction")) {
		
		
		
		int result = 0;//1 : 회원가입 성공, 2:실패
		
		result = LoginDao.joinMember(request);
		
		if(result == 1) { //성공
			response.sendRedirect("login");
		}else if(result==2) { //실패
			response.sendRedirect("join3");
		}
	}
	else if(command.equals("one2one")) {
		RequestDispatcher dp = request.getRequestDispatcher("/customer/customer01.jsp");
		dp.forward(request, response);
	}
	else if(command.equals("one2oneAction")) {
		request.setCharacterEncoding("utf-8");
		//아이디,이름으로 로그인 처리를 해줌.
		
		int result = 0;//1 : 로그인 성공, 0:아이디가 없음 , 2:이름없음
		
		try {
			result = one2oneDao.one2oneAction(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result == 1) { //성공
			response.sendRedirect("one2one");
		}else if(result ==0 ||result==2) { //실패
			response.sendRedirect("index");
		}
	}else if(command.equals("community")) {
		
		ArrayList<CommunityDto> list = null;

		try {
			list = CommunityDao.list();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		
		RequestDispatcher dp = request.getRequestDispatcher("/community/community01.jsp");
		dp.forward(request, response);
		
	}else if(command.equals("qna")) {
		
		ArrayList<qnaDto> list2 = null;

		try {
			list2 = qnaDao.list2();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list2", list2);
		
		RequestDispatcher dp = request.getRequestDispatcher("/customer/customer02.jsp");
		dp.forward(request, response);
		
	}else if(command.equals("faq")) {
		
		ArrayList<faqDto> list3 = null;

		try {
			list3 = faqDao.list3();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list3", list3);
		
		RequestDispatcher dp = request.getRequestDispatcher("/customer/customer03.jsp");
		dp.forward(request, response);
		
	
	}else if(command.equals("content")) {
		String notice_idx = (String)request.getParameter("notice_idx");
		
		CommunityDto dto = null;
		
		try {
			dto = CommunityDao.Info(notice_idx);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("dto", dto);
		
		RequestDispatcher dp = request.getRequestDispatcher("/community/content.jsp");
		dp.forward(request, response);
	}else if(command.equals("qnadetail")) {
		String qna_idx = (String)request.getParameter("qna_idx");
		
		qnaDto dto2 = null;
		
		try {
			dto2 = qnaDao.Info(qna_idx);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("dto2", dto2);
		
		RequestDispatcher dp = request.getRequestDispatcher("/customer/qnadetail.jsp");
		dp.forward(request, response);
	}
	else if(command.equals("qnaWriteAction")) {
		request.setCharacterEncoding("utf-8");
		//아이디,이름으로 로그인 처리를 해줌.
		
		int result = 0;//1 : 로그인 성공, 0:아이디가 없음 , 2:이름없음
		
		try {
			result = qnaDao.qnaWriteAction(request);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result == 1) { //성공
			response.sendRedirect("qna");
		}else if(result ==0 ||result==2) { //실패
			response.sendRedirect("qna");
		}
	}
	else if(command.equals("qnaWrite")) {
		RequestDispatcher dp = request.getRequestDispatcher("/customer/qnaWrite.jsp");
		dp.forward(request, response);
	}else if(command.equals("qnapw")) {
		RequestDispatcher dp = request.getRequestDispatcher("/customer/qnapw.jsp");
		dp.forward(request, response);
	}
	}
}

