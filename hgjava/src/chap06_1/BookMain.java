package chap06_1;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁

		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		BookData bookdata = new BookData();
		Book[] books = null;
		
		int bookea = 0;
		
		
		while(run)
		{
			System.out.println("--------------------------------------------------------------");
			System.out.println("1.도서수 입력  2.도서정보 등록  3.도서정보 전체조회  4.도서정보 분석  5.종료");
			System.out.println("--------------------------------------------------------------");
			
			System.out.print("선택 > ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num)
			{
			case 1 : 
				System.out.print("도서 수 > ");
				bookea = Integer.parseInt(sc.nextLine()); break;
			case 2 : 
				books = bookdata.bkData(bookea); break;
			case 3 : 
				for(int i = 0; i < bookea; i++)
				{
					System.out.printf("도서번호 : %d  가격 : %d원\n", books[i].bookNum, books[i].price);
				}                                                   //books[i].getbookNum
				break;
			case 4 :
				int max = books[0].price;
				int min = books[0].price;
				int sum = 0;
				double avg = 0;
				
				for(int i = 0; i < bookea; i++)
				{
					if(max < books[i].price)
					{
						max = books[i].price;
					}
					
					if(min > books[i].price)
					{
						min = books[i].price;
						
					}
					sum += books[i].price;
				}
				avg = sum / bookea;
				
				System.out.printf("최고 가격 : %d\t", max);
				System.out.printf("최저 가격 : %d\t", min);
				System.out.printf("평균 가격은 %.1f원 입니다.\n",avg);
				break;
				
			case 5 : 
				System.out.println("프로그램 종료");
				run = false;
				break;
			default : 
				System.out.println("입력 오류");
				run = false;
			}
			
			
		}
		
		sc.close();
		
		
	}//end main

}//end class
