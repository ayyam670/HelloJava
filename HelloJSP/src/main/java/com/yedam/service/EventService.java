package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;

public interface EventService {
	List<EventVO> eventList();
	boolean insertEvent(Map<String, String> map);             // 이벤트 내용, 등록 성공 여부를 true 또는 false 로 반환
	boolean deleteEvent(int eventNo);            // 이벤트 번호로 이벤트 삭제
	boolean updateEvent(EventVO event);
}
