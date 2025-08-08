package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddEventControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.CalendarControl;
import com.yedam.control.ChartControl;
import com.yedam.control.DeleteEventControl;
import com.yedam.control.EventControl;
import com.yedam.control.JSControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.RegisterControl;
import com.yedam.control.RemoveControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.SignFormControl;
import com.yedam.control.SignUpControl;
import com.yedam.control.TotalCntControl;

// init - service - destroy
// *.do -> 실행할 컨트롤.
// 요청url ===실행할 컨트롤.


public class FrontController extends HttpServlet
{
	Map<String, Control> map;
	
	//생성자
	public FrontController()
	{
		map = new HashMap<String, Control>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException
	{
		map.put("/boardList.do", new BoardListControl());//글목록
		map.put("/board.do", new BoardControl());        //상세화면
		map.put("/register.do", new RegisterControl());  //등록화면
		map.put("/addBoard.do", new AddBoardControl());  //등록처리
		map.put("/modifyForm.do", new ModifyFormControl()); //수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl());   //수정처리
		map.put("/remove.do", new RemoveControl()); //삭제
		// 회원관련
		map.put("/signForm.do", new SignFormControl()); //회원등록
		map.put("/signup.do", new SignUpControl()); //회원가입
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl()); // 실제 로그인 
		map.put("/logout.do", new LogoutControl()); //로그아웃
		map.put("/memberList.do", new MemberListControl()); // 회원관리
		
		//기타
		map.put("/js.do", new JSControl());
		
		// 댓글관련.
		map.put("/replyList.do", new ReplyListControl()); // 글번호 -> 댓글목록
		map.put("/removeReply.do", new RemoveReplyControl()); // 댓글 삭제
		map.put("/addReply.do", new AddReplyControl()); // 댓글 등록
		map.put("/totalReply.do", new TotalCntControl()); // 댓글 갯수 조회 bno {"totalCnt" : 78}
		
		// 기타
		map.put("/chartData.do", new ChartControl());
		
		// 캘린더 연습
		map.put("/eventList.do", new EventControl());   // 이벤트 목록
		map.put("/addEvent.do", new AddEventControl()); // 이벤트 등록 . {retCode:"OK"/"NG"}
		map.put("/calendar.do", new CalendarControl());
		map.put("/deleteEvent.do", new DeleteEventControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// url vs. uri
		// http://localhost:8080/HelloJSP/boardList.do => url
		// /HelloJSP/boardList.do                      => uri
		String uri = req.getRequestURI();
		String context = req.getContextPath();                 //  /HelloJSP       프로젝트
		String page = uri.substring(context.length());         //  /boardList.do     /HelloJSP  9글자 부터~.length() ~글자인지 파악
		        // System.out.println(page);                   //substring = ~ 부터 ~ 까지 잘라서 문자열을 반환하겠다
		
		Control control = map.get(page);
		control.execute(req, resp);
	}
}
