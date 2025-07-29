package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class RegisterControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// WEB-INF/html/register_form.html
		
			// 요청 재지정.
			req.getRequestDispatcher("WEB-INF/html/register_form.jsp").forward(req, resp);
			//여기 try catch 하거나 throws ServletException, IOException , Control에도 

	}

}
