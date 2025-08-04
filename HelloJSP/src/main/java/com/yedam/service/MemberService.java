package com.yedam.service;

import java.util.List;

import com.yedam.common.MemberDTO;
import com.yedam.vo.MemberVO;

//회원관련 업무.

public interface MemberService {
	public boolean addMember(MemberVO member); //회원등록
	public MemberVO userCheck(String id, String pw);
	public List<MemberVO> MemberList(MemberDTO memberList);
}
