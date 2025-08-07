package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.EventVO;

public interface EventMapper {
	
	//Mybatis SQL 인터페이스. DB에 접근하는 메서드 정의
	//eventList, insertEvent, deleteEvent
	
	List<EventVO> eventList();
	int insertEvent(EventVO event);             // insert delete update 같은 쿼리 실행 시 몇 개의 행이 처리되었는지 알려주기 위해 int로 반환
	int deleteEvent(int eventNo);               // boolean 타입은 성공 / 실패 만 알려줌
	int updateEvent(EventVO event);
} 
