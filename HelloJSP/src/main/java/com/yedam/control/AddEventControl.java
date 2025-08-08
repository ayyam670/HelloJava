package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.EventService;
import com.yedam.service.EventServiceImpl;

public class AddEventControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EventService svc = new EventServiceImpl();
		Map<String, String> map = new HashMap<>();
		
		map.put("title", req.getParameter("title"));
		map.put("startDate", req.getParameter("start"));
		map.put("endDate", req.getParameter("end"));
		
		try {
			svc.insertEvent(map);
			resp.getWriter().print("{\"retCode\":\"OK\"}");
		} catch (Exception e)
		{
			//e.printStackTrace();
			resp.getWriter().print("{\"retCode\":\"NG\"}");
		}
	}

}
