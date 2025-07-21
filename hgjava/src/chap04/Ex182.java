package chap04;


public class Ex182 {

	public static void main(String[] args) {
		// p182 문제 2
		//1에서 100까지 정수 중 3의 배수 합, 3의 배수의 갯수
		
		int sum = 0;
		int cnt = 0;
		
		for(int i=1; i<=100; i++) {
			
			if(i % 3 == 0) {
				sum += i;
				cnt++;
			}
			
		}
		
		System.out.println("sum = " + sum);
		System.out.println("cnt = " + cnt);
		
		
		//183p 문제 3  추가 - 몇 번 만에 탈출하는지
		int dice1 = 0;
		int dice2 = 0;
		int cnt3 = 0;
		
		while((dice1 + dice2) != 5) {
			dice1 = (int)(Math.random() * 6) +1;
			dice2 = (int)(Math.random() * 6) +1;
			
			System.out.printf("(%d , %d)\n", dice1, dice2);
			cnt3++;
		}
		System.out.println("!!탈출!!");
		System.out.println("주사위 던진 횟수 = " + cnt3);
		
		
		// 문제 4
		for(int x = 1; x <= 10; x++) {
			
			for(int y = 1; y <= 10; y++) {
				
				if((4*x + 5*y) == 60) {
					System.out.printf("(%d , %d)\n", x, y);
				}
				
			}
			
		}
		
		
		
		//문제 5
		for(int i=1; i < 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		//문제 6
		for(int i = 1; i < 5; i++)
		{
			for(int j = 4; j > 0; j--)
			{
				if(i<j)
				{
					System.out.print(" ");
				}else
				{
					System.out.print("*");
				}
			}
			System.out.println();
		}
			
		
		
		

	}//end main

}//end class
