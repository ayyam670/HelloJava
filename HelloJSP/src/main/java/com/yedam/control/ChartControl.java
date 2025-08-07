package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;

public class ChartControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		Map<String, Integer> map = new HashMap<>();
		map.put("user01", 30);
		map.put("user02", 20);
		map.put("user03", 60);
		map.put("user04", 40);
		map.put("user05", 130);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		
		resp.getWriter().print(json);
		
		
	}

}
