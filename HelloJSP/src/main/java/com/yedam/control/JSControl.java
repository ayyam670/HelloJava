package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class JSControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		
		req.getRequestDispatcher("WEB-INF/html/js.jsp").forward(req, resp);
		
	}

}
