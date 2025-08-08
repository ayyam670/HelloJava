package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVO;

public class EventServiceImpl implements EventService{
	SqlSession sqlSession = DBUtil.getInstance().openSession();
	EventMapper mapper = sqlSession.getMapper(EventMapper.class);
	

	@Override
	public List<EventVO> eventList() {
		
		return mapper.eventList();
	}
	
	
	@Override
	public boolean insertEvent(Map<String, String> map) {
		int r = mapper.insertEvent(map);
		
		if(r > 0)
		{
			sqlSession.commit();
			return true;
		}
		
		return false;
		
		//return mapper.insertEvent(title) == 1;           // insert가 1건 성공하면 true 반환.
	}
	
	@Override
	public boolean deleteEvent(int eventNo) {
		int r = mapper.deleteEvent(eventNo);
		
		if(r > 0)
		{
			sqlSession.commit();
			return true;
		}
		
		return false;
		
		//return mapper.deleteEvent(eventNo) == 1;         // delete가 1건 성공하면 true 반환.
	}




	@Override
	public boolean updateEvent(EventVO event) {
		int r = mapper.updateEvent(event);
		
		if(r > 0)
		{
			sqlSession.commit();
			return true;
		}
		
		return false;
	}


	
	
}
