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
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.RegisterControl;

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
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		map.put("/register.do", new RegisterControl());
		map.put("/addBoard.do", new AddBoardControl());
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
		                                                       //substring = ~ 부터 ~ 까지 잘라서 문자열을 반환하겠다
		
		Control control = map.get(page);
		control.execute(req, resp);
	}
}
