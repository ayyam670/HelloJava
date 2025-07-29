package com.yedam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

interface Controller
{
	public void exe();
}

class Sample implements Controller
{
	@Override
	public void exe() {
		System.out.println("Sample 클래스");
	}
	
}

public class Main {
	public static void main(String[] args)
	{
		ArrayList<Book> list = new ArrayList<>();
//		Book book = list.get(0);
		
		// 키 = 값
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("홍길동", 80);
		map.put("박길동", 78);
		
		Integer result = map.get("홍길동");
		System.out.println(result);
		
		Map<String, Controller> controls = new HashMap<>();
		controls.put("abc.do", new Sample());
		controls.put("ddc.do", new Controller()
			{
				@Override
				public void exe() {
					System.out.println("Test 입니다.");
				}
			});
		
		Controller val = controls.get("Test");
		val.exe();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		BoardService svc = new BoardServiceImpl(); // 업무기능.
//		
//		int searchNo = 1;
//		
//		
//		
//		// 조회. 조회수 증가. => 업무 (조회 : 글번호조회 + 조회카운트)
//		BoardVO board = svc.searchBoard(searchNo);
//		
//		
//		System.out.println(board.toString());
//		
//		List<BoardVO> list = mapper.selectList();
//		for (BoardVO board : list)
//		{
//			System.out.println(board.toString());
//		}
	}
}//end main
