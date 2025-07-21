package com.yedam.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 조회, 등록, 수정, 삭제
public class BookDAO {
	// 목록조회(다건)
	public ArrayList<Book> findAll()
	{
		Connection conn = DBUtil.getConnect();
		ArrayList<Book> list = new ArrayList<Book>(); //컬렉션(Book)
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book");
			//반복
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id")); // id -> id 필드에 할당
				book.setTitle(rs.getString("title")); // title -> title 필드.
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getInt("price"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//end findAll()
	
	
	
	

}//end class
