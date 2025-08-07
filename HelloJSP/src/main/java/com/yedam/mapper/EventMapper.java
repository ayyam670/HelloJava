package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.EventVO;

public interface EventMapper {
	List<EventVO> eventList(int eventNo);
	int insertEvent(EventVO eventTitle); // 등록
	int deleteEvent(int eventNo);  // 삭제
}
