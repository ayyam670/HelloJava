package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.common.MemberDTO;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	SqlSession sqlSession = DBUtil.getInstance().openSession();
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public boolean addMember(MemberVO member)
	{
		int r = mapper.insertMember(member);
		
		if( r > 0 )
		{
			sqlSession.commit();
			return true;
		}
		return false;
	}
	
	@Override
	public MemberVO userCheck(String id, String pw)
	{
		return mapper.selectMember(id, pw);
	}

	@Override
	public List<MemberVO> MemberList(MemberDTO memberList) {
		// TODO 자동 생성된 메소드 스텁
		return null;
	}
	
}
