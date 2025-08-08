package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yedam.common.Control;
import com.yedam.service.EventService;
import com.yedam.service.EventServiceImpl;

public class DeleteEventControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json;charset=utf-8");
		EventService svc = new EventServiceImpl();
		String eventNo = req.getParameter("eventNo");

		// 2. 응답 데이터 준비
		Map<String, Object> map = new HashMap<>();

		try {
			if (eventNo == null || !eventNo.matches("\\d+")) {
				map.put("retCode", "INVALID_PARAM");
				map.put("message", "eventNo가 올바르지 않습니다.");
			} else {
				boolean result = svc.deleteEvent(Integer.parseInt(eventNo));
				map.put("retCode", result ? "OK" : "NG");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("retCode", "EXCEPTION");
			map.put("message", e.getMessage());
		}
		
		

		// 5. JSON 응답
		Gson gson = new Gson();
		resp.getWriter().print(gson.toJson(map));
	
		
	}

}
