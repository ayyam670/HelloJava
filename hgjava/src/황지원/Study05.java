package 황지원;

import java.util.Scanner;

public class Study05 {

	public static void main(String[] args) {
		// 5. 섭씨-화씨 온도 변환 프로그램
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		while(run)
		{
			System.out.println("----------------------");
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			System.out.println("----------------------");
			System.err.print("▶ 번호 선택 : ");
			int num = Integer.parseInt(sc.nextLine());
			int tem = 0;
			
			switch(num)
			{
			case 1 :
				
				System.out.print("▶ 화씨 온도 입력 : ");
				tem = Integer.parseInt(sc.nextLine());
				System.out.println(" 섭씨온도 = " + (double)5/9*(tem-32));
				 break;
			case 2 :
				System.out.print("▶ 섭씨 온도 입력 : ");
				tem = Integer.parseInt(sc.nextLine());
				System.out.println("섭씨온도 = " + ((double)9/5*tem+32));
				 break;
			default :
				System.out.println("program end");
				run = false;
			}
//			if(num == 3)
//			{
//				 break;
//			}
		}
		
		
		
		sc.close();
		
		
		
		
	}//end main

}//end class
