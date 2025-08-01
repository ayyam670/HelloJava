package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		// key=value + 파일 -> 처리.
		// cos.jar 활용해서 Multipart 요청을 처리.
		// 게시글 DB insert.
		
		// 서버상의 upload 폴더에 저장.   context = 프로젝트        upload 라는 폴더찾기
		String upload = req.getServletContext().getRealPath("upload");
		System.out.println(upload);
		
		MultipartRequest mr = new MultipartRequest(
				req, // 요청정보
				upload, // 업로드 경로
				1024 * 1024 * 5, // 최대 파일크기
				"UTF-8", // 인코딩 방식
				new DefaultFileRenamePolicy() // 리네임정책.
				);
		
		
		
		// addBoard.co?title=???&writer=????&content=????
		String title = mr.getParameter("title");
		String writer = mr.getParameter("writer");
		String content = mr.getParameter("content");
		String img = mr.getFilesystemName("images"); //파일이름.
		
		//
		BoardVO param = new BoardVO();
		param.setTitle(title);
		param.setWriter(writer);
		param.setContent(content);
		param.setImage(img);
		
		
		BoardService svc = new BoardServiceImpl();
		if(svc.registerBoard(param))
		{
			//목록이동
			resp.sendRedirect("boardList.do");
			
		}else
		{
			System.out.println("에러발생");
		}
	}

}//end execute
