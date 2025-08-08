package com.yedam.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.EventService;
import com.yedam.service.EventServiceImpl;
import com.yedam.vo.EventVO;

public class EventControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");             // 콘텐츠 타입을 json으로 설정, utf-8은 한글이 깨지지 않도록 문자 인코딩 지정
		
		
		EventService svc = new EventServiceImpl();                // 비즈니스 로직을 담당하는 EventServiceImpl 객체 생성
		
		// 전체 이벤트 목록 가져오기
		List<EventVO> list = svc.eventList();              // 매개변수 없이 eventList() 메서드를 호출해서 전체 이벤트의 목록을 가져옴
		
		// 최종 결과 담을 리스트 생성
		List<Map<String, Object>> evList = new ArrayList<>();

		// 각각의 EventVO 객체를 Map으로 변환
		for (EventVO ev : list) {
			Map<String, Object> map = new HashMap<>();
			map.put("title", ev.getTitle());
			map.put("start", ev.getStartDate());
			map.put("end", ev.getEndDate());
			map.put("id", ev.getEventNo());
			evList.add(map);
		}
		
		
		
		//Gson 라이브러리 활용해서 json 문자열 객체 생성
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(evList);         // list 객체를 json 문자열로 변환  ex) [ 
		                                             //                              {"event":1, "reply":"댓글1", "replyer":"홍길동"},
		                                             //                              {"replyNo":2, "reply":"댓글2", "replyer":"김철수"}
		                                             //                            ]
		
		//출력 스트림.
		resp.getWriter().print(json);            // json 문자열을 클라이언트(브라우저) 로 응답 -> 이 응답을 ajax나 fetch로 받은 쪽 화면에 뿌릴 수 있음
	}

}
