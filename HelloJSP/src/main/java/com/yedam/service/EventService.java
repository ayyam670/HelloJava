package com.yedam.service;

import java.util.List;

import com.yedam.vo.EventVO;

public interface EventService {
	List<EventVO> eventList(int eventNo);
	boolean removeEvent(int eventNo);
	boolean addEvent(EventVO eventTitle);
}
