package 황지원;

import java.util.Scanner;

public class Study01 {

	public static void main(String[] args) {
		//  1. 윤년 계산 프로그램
		//  입력된 년도가 윤년인지 계산하는 프로그램 작성
		//  4로 나누어 떨어지고, 100으로 나누어 떨어지지 않으면 윤년 , 400으로 나누어 떨어지면 윤년
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("##년도 입력 >> ");
		int year = Integer.parseInt(sc.nextLine());
		
		if(year % 4 == 0)
		{
			if(year % 400 == 0 || year % 100 != 0 )
			{
				System.out.println(year + "년은 윤년입니다.");
			}else
			{
				System.out.println(year + "년은 평년입니다.");
			}
		}else
		{
			System.out.println(year + "년은 평년입니다.");
		}
		
		sc.close();
	}//end main

}//end class
