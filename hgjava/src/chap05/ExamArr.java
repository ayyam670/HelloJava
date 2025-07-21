package chap05;

public class ExamArr {

	public static void main(String[] args) {
		// 배열 과제 1
		
		int[] su = new int[10];
		
		int sum = 0;
		int max = 0;     //su[0];
		int min = 100;   //su[0];
		
		for(int i = 0; i < su.length; i++)
		{
			su[i] = (int)(Math.random() * 100) +1;
		}
		
		System.out.print("배열 값 : ");
		
		for(int i = 0; i < su.length; i++)
		{
			System.out.print(su[i] + " ");
			sum += su[i];
			if(max < su[i]) max = su[i];
			if(min > su[i]) min = su[i];
		}
		System.out.println();
		System.out.println("배열 값 합계 : " + sum);
		System.out.println("최댓값 : " + max);
		System.out.println("최솟값 : " + min);
		
		
		
		// 배열의 요소 중 4의 배수 출력
		// 4의 배수 갯수 출력
		
		int cnt = 0;
		
		System.out.println("4의 배수 : ");
		for(int i = 0; i < su.length; i++)
		{
			if(su[i] % 4 == 0)
			{
				cnt++;
				System.out.println(su[i]);
			}
			
		}
		
		
		System.out.println("4의 배수의 갯수 : " + cnt);
		
		
		// 2차원 배열
		// 배열의 선언
		int [][] twoArr = 
			{
					{80, 90},
					{70, 60, 50}
			};
		// 2차원 배열 출력
		for(int i = 0; i < twoArr.length; i++)  //행
		{
			for(int j = 0; j < twoArr[i].length; j++)  //열
			{
				System.out.printf("| %d |", twoArr[i][j]);
			}
			System.out.println();
		}
		
		
		// 과제 2
		
		int [][] fourArr =
			{
					{1,2,3},
					{1,2},
					{1},
					{1,2,3}
			};
		
		for(int i = 0; i < fourArr.length; i++)
		{
			for(int j = 0; j < fourArr[i].length; j++)
			{
				System.out.printf("%d ", fourArr[i][j]);
			}
			System.out.println();
		}
		
		
		
		
		int[][] mov = new int[3][10];
		
		int per = 0;
		
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j <10; j++)
			{
				mov[i][j] = (int)(Math.random()* 2);
				System.out.printf("%d ", mov[i][j]);
				
				per += mov[i][j];
			}
		}
		System.out.println("\n관객 수 : " + per);
		
		
		
		
		// 과제 문제4
		
		int[][] score4 = new int[3][5];
		double[] sum4= new double[3];
		
		for(int i = 0; i < score4.length; i++)
		{
			
			
			for(int j = 0; j < score4[i].length; j++)
			{
				score4[i][j] = (int)(Math.random()*51) + 50;
				System.out.print(score4[i][j]+ " ");
				
				sum4[i] += score4[i][j];
				
			}
			System.out.println();
		}
		
		for(int i = 0; i < sum4.length; i++)
		{
			System.out.printf("%d 번 학생 평균 = %.2f \n",i+1 , sum4[i] / 5);
		}
			
		// 과제 문제 5
		
		String[] card1 = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] card2 = {"2", "3", "4", "5", "6" , "7", "8", "9","10", "Jack", "Queen", "King", "Ace"};
		
		
		for(int i = 1; i < 6; i++)
		{
				System.out.println(card1 [ (int)(Math.random() * 4)] + " 의 " + card2 [ (int)(Math.random() * 13)] );
		}
		
		
//		String[][] card =
//			{
//				{"Clubs", "Diamonds", "Hearts", "Spades"},
//				{"2", "3", "4", "5", "6" , "7", "8", "9","10", "Jack", "Queen", "King", "Ace"}
//			};
//		
//		int k = (int)(Math.random() * 4) ;
//		int j = (int)(Math.random() * 13) ;
//		
//		for(int i = 1; i < 6; i++)
//		{
//			System.out.println(card[k][j]);
//		}
		
		
		//문제 6
		//3*5 크기의 2차원 배열 생성하고 초기값은 0으로 초기화
		//5개의 정수 1을 랜덤하게 배치
		//최종 배열 출력
		
		int[][] random = null;
		random = new int[3][5];
		
		for(int j = 1; j < 6; j++)
		{
			int w = (int)(Math.random() *3);
			int o = (int)(Math.random() *5);
			
			if(random[w][o] == 1)
			{
				j--;
			}else
			{
				random[w][o] = 1;
			}
		}
		
		
		
		for(int i = 0; i < random.length; i++)
		{
			for(int h = 0; h < random[i].length; h++)
			{
				
				System.out.print(random[i][h] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}//end main

}//end class
