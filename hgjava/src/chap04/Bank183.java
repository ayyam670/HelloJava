package chap04;

import java.util.Scanner;

public class Bank183 {

	public static void main(String[] args) {
		// 183p 문제 7
		Scanner sc = new Scanner(System.in);
		int balance = 0;
		boolean run = true;
		
		
		while(run)
		{
			System.out.println("------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------------");
			
			System.out.print("선택 >");
			int selNum = Integer.parseInt(sc.nextLine());
			
			switch(selNum)
			{
			case 1 :
				System.out.print("예금액 > ");
				int money = Integer.parseInt(sc.nextLine());
				balance += money;
				System.out.println("예금 후 잔액 : " + balance);
				break;
			case 2 :
				//출금액이 부족할 경우 잔액 부족 출력
				//출금 가능 금액 출력
				//가능하면 출금처리
				System.out.print("출금액 > ");
				money = Integer.parseInt(sc.nextLine());
				if(balance < money)
				{
					System.out.println("잔액 부족\n 출금 가능 금액 : " + balance);
				}else
				{
					System.out.println((balance - money));
					balance -= money;
					System.out.println("출금 후 잔액 : " + balance);
				}
				break;
			case 3 :
				System.out.println("잔액 : " + balance);
				break;
			default :
				run = false;
			}
			
			
		}
		System.out.println("프로그램 종료");
		
		
		
		
		
		
		sc.close();
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
