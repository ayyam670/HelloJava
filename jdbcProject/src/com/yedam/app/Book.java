package com.yedam.app;
//DAO 클래스 (데이터 오브젝트)
public class Book {
	private int id;
	private String title;
	private String author;
	private int price;
	
	
	//생성자.
	public Book() {}
	public Book(int id, String title, String author, int price) {
		super(); // 부모 클래스
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	
	//getter, setter 생성
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
}//end class
