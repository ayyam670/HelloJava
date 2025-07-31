package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl {
	
	
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// param : uname, psw
		String id = req.getParameter("uname");
		String pw = req.getParameter("id");
		
		// DB 처리
		MemberService svc = new MemberServiceImpl();
		MemberVO member = svc.userCheck(id, pw);
		
		// 세션.
		if(member == null)
		{
			
		}else
		{
			//정상 id, pw
			HttpSession session = req.getSession(); //
		}
	}
}
