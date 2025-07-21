package 황지원;

import java.util.Scanner;

public class Study02 {

	public static void main(String[] args) {
		// 2. 동전 교환 프로그램
		// 입력된 액수만큼 500원, 100원, 50원, 10원짜리 동전으로
		// 교환 해주는 프로그램 작성 - 동전의 총개수는 최소화 - 고액의 동전 먼저 교환
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("##교환할 금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		int jan = 0;
		
		if(money != 0 )
		{
			
			int won500 = money / 500;
			jan = money % 500;
			int won100 = jan / 100;
			int jan1 = jan % 100;
			int won50 = jan1 / 50;
			int jan2 = jan1 % 50;
			int won10 = jan2 / 10;
			int jan3 = jan2 % 10;
			
			System.out.println("500원 짜리 : " + won500 + "개");
			System.out.println("100원 짜리 : " + won100 + "개");
			System.out.println("50원 짜리 : " + won50 + "개");
			System.out.println("10원 짜리 : " + won10 + "개");
			System.out.println("교환 금액 : " + (money-jan3) + "원");
			System.out.println("남은 금액 : " + jan3 + "원");
			
			if(jan != 0)
			{
				System.out.println("500원 짜리 : " + won500 + "개");
				System.out.println("100원 짜리 : " + won100 + "개");
				System.out.println("50원 짜리 : " + won50 + "개");
				System.out.println("10원 짜리 : " + won10 + "개");
				System.out.println("교환 금액 : " + (money-jan3) + "원");
				System.out.println("남은 금액 : " + jan3 + "원");
				
				if(jan1 != 0)
				{
					System.out.println("500원 짜리 : " + won500 + "개");
					System.out.println("100원 짜리 : " + won100 + "개");
					System.out.println("50원 짜리 : " + won50 + "개");
					System.out.println("10원 짜리 : " + won10 + "개");
					System.out.println("교환 금액 : " + (money-jan3) + "원");
					System.out.println("남은 금액 : " + jan3 + "원");
					
					if(jan2 != 0)
					{
						System.out.println("500원 짜리 : " + won500 + "개");
						System.out.println("100원 짜리 : " + won100 + "개");
						System.out.println("50원 짜리 : " + won50 + "개");
						System.out.println("10원 짜리 : " + won10 + "개");
						System.out.println("교환 금액 : " + (money-jan3) + "원");
						System.out.println("남은 금액 : " + jan3 + "원");
					}
					
				}
			}
			
		}
			
			
		
		sc.close();

		
		

	}//end main

}//end class
