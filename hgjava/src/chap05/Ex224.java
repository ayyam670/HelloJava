package chap05;

import java.util.Scanner;

public class Ex224 {

	public static void main(String[] args) {
		// 확인문제 6번
		// switch문 이용
		
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);
		
		
		
		while(run)
		{
			System.out.println("-----------------------------------------------");
			System.out.println("1.학생수 | 2. 점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			
			
				switch(selectNo)
				{
				case 1 :
					System.out.println("학생 수> ");
					studentNum = Integer.parseInt(scanner.nextLine());
					scores = new int[studentNum];
					break;
				case 2 :
					for(int i = 0; i < studentNum; i++)
					{
						System.out.println("점수 입력>");
						scores[i] = Integer.parseInt(scanner.nextLine());
					}
					break;
				case 3 :
					for(int i = 0; i < studentNum; i++)
					{
						System.out.printf("\n scores[%d]> %d \n",i , scores[i]);
					}
					break;
				case 4 :
					int sum = 0;
					int max = 0;
					
					for(int i = 0; i < studentNum; i++)
					{
						if(max < scores[i])
						{
							max = scores[i];
						}
						sum += scores[i];
					}
					System.out.println("최고 점수 : " + max);
					System.out.println("평균 점수 : " + sum/studentNum);
					break;
				case 5 :
					System.out.println("프로그램 종료");
					run = false;
					
				}
		
			
		}
		
	
		scanner.close();
		
		

	}//end main

}//end class
