package com.yedam.control;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수정한 글 저장
		req.setCharacterEncoding("utf-8");
		
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		String page = req.getParameter("page");
		
		BoardVO param = new BoardVO();
		param.setBoardNo(Integer.parseInt(bno));
		param.setTitle(title);
		param.setContent(content);
		
		//DB조회
		BoardService svc = new BoardServiceImpl();
		
		if(svc.modifyBoard(param))
		{
			
			resp.sendRedirect("boardList.do?page=" + page);
			
		}else
		{
			System.out.println("에러발생");
			//req.setAttribute("board_info", param);
			//req.getRequestDispatcher("WEB-INF/html/board.jsp").forward(req, resp);
		}
		
		
		
		
		
		
		
	}

}
