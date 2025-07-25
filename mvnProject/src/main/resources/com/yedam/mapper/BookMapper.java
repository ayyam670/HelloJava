package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.Book;

public interface BookMapper {
	public Book selectBook(int id);
	public List<Book> List();
}
