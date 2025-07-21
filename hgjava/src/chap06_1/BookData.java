package chap06_1;

import java.util.Scanner;

public class BookData {

	Scanner sc = new Scanner(System.in);
	
	Book[]  bkData(int n)
	{
		Book[] books = new Book[n];
		
		for(int i = 0; i < n; i++)
		{
			System.out.printf("%d번째 도서 정보 입력\n", i+1);
			
			System.out.printf("도서번호 > ");
			int bookNum = Integer.parseInt(sc.nextLine());
			
			System.out.printf("도서제목 > ");
			String bookName = (sc.nextLine());
			
			System.out.printf("도서가격 > ");
			int bookPrice = Integer.parseInt(sc.nextLine());
			
			books[i] = new Book(bookNum, bookName, bookPrice);
		}
		return books;
		
	}
	
}//end class
