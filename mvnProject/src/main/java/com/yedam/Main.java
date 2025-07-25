package com.yedam;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DBUtil;
import com.yedam.mapper.BookMapper;
import com.yedam.vo.Book;


public class Main {
	public static void main(String[] args) {
		
		Object obj;
		//RunExe 는 Runnable 구현하는 클래스.
		//Runnable exe = new Runnable(); 도 가능 RunExe 3줄 참고 Runnable이 RunExe 포함
		RunExe exe = new RunExe();
		exe.run();  // 인터페이스 - 구현클래스
		
		
		//DBUtil util = new DBUtil();  //인스턴스를 통해서 메모리 로딩.
		SqlSessionFactory factory = DBUtil.getInstance();  //static을 선언하면 instance를 만들지 않아도 사용가능 -- DBUtil 14줄
		SqlSession sqlSession = factory.openSession();    //SqlSession 객체를 반환.
		
		// 인터페이스 - 구현클래스.
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		Book book = mapper.selectBook(1001); // = 단건조회
		List<Book> list = mapper.List(); // = 목록조회
		System.out.println(list);
		
		
		//단건조회. = selectOne
		//Book book = sqlSession.selectOne("com.yedam.mapper.BookMapper.selectBook", 1000);
		
		
		//List<Book> list = sqlSession.selectList("com.yedam.mapper.BookMapper.List");
		//for(Book book : list)
		{
			System.out.println(book.toStr());
		}
		
	}
}
