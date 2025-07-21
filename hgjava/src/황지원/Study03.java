package 황지원;

import java.util.Scanner;

public class Study03 {

	public static void main(String[] args) {
		// 3. 숫자 추측 게임
		// 1에서 100까지의 수를 발생 시키고 어떤 수인지 알아 맞히는 게임 프로그램 작성
		
		Scanner sc = new Scanner(System.in);
		int ran = (int)(Math.random() * 100) +1;
		
		
		

		
		while(true)
		{
			System.out.print("숫자 입력 : ");
			int num = Integer.parseInt(sc.nextLine());
			
			if(ran < num)
			{
				System.out.println("down하세요!!");
				
			}else if(ran > num)
			{
				System.out.println("up하세요!!");
				
			}else
			{
				System.out.println("축하합니다!!");
				break;
			}
		}
		
		
		sc.close();
		
		
		

	}//end main

}//
