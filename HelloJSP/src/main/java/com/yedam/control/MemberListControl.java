package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.MemberDTO;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String responsibility = req.getParameter("responsibility");
		
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setName(name);
		member.setResponsibility(responsibility);
		
		
		MemberService mvs = new MemberServiceImpl();
		List<MemberVO> mList = mvs.MemberList(member);
		
		
	}

}
