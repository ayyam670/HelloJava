package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVO;

public class EventServiceImpl implements EventService{
	SqlSession sqlSession = DBUtil.getInstance().openSession();
	EventMapper mapper = sqlSession.getMapper(EventMapper.class);
	
	@Override
	public List<EventVO> eventList(int eventNo) {
		return mapper.eventList(eventNo);
	}
	
	
	@Override
	public boolean removeEvent(int eventNo) {
		int r = mapper.deleteEvent(eventNo);
		
		if(r > 0)
		{
			sqlSession.commit();
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean addEvent(EventVO eventTitle) {
		int r = mapper.insertEvent(eventTitle);
		
		if(r > 0)
		{
			sqlSession.commit();
			return true;
		}
		return false;
	}
	
}
