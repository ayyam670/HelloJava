package 황지원;

import java.util.Scanner;

public class Study06 {

	public static void main(String[] args) {
		// 6. 가위,바위, 보 게임 프로그램 
		// 가위 바위 보 중에 하나를 선택하면, 컴퓨터가 생성한 난수값과 비교하여 
		// 누가 이겼는지 화면에 출력하는 프로그램 작성
		// 2보다 큰 수  입력하면 game over 출력 => 종료
		
		Scanner sc = new Scanner(System.in);
		
		
		
		boolean run = true;
		
		while(run)
		{
			int com = (int)(Math.random()*3);
			System.out.print("## 가위(0) 바위(1) 보(2) : ");
			int per = Integer.parseInt(sc.nextLine());
			
			System.out.printf("사람 %d, 컴 %d  ", per, com);
			
			switch(per)
			{
			case 0 :
				if(com == 0 )
				{
					System.out.printf("사람 %d, 컴 %d, 비겼음\n", per, com);
				}
				else if(com == 1)
				{
					System.out.printf("사람 %d, 컴 %d, 졌음\n", per, com);
				}
				else
				{
					System.out.printf("사람 %d, 컴 %d, 이겼음\n", per, com);
				}
				
			case 1 :
				if(com == 0 )
				{
					System.out.printf("사람 %d, 컴 %d, 이겼음\n", per, com);
				}
				else if(com == 1)
				{
					System.out.printf("사람 %d, 컴 %d, 비겼음\n", per, com);
				}
				else
				{
					System.out.printf("사람 %d, 컴 %d, 졌음\n", per, com);
				}
				
			case 2 :
				if(com == 0 )
				{
					System.out.printf("사람 %d, 컴 %d, 졌음\n", per, com);
				}
				else if(com == 1)
				{
					System.out.printf("사람 %d, 컴 %d, 이겼음\n", per, com);
				}
				else
				{
					System.out.printf("사람 %d, 컴 %d, 비겼음\n", per, com);
				}
			default :
				System.out.println("game over");
				run = false;
			}
			
		}
		
		sc.close();
		
		
	}//end main

}//end class
