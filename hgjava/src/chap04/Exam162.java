package chap04;

public class Exam162 {

	public static void main(String[] args) {
		// 주사위 게임
		// 주사위를 2개 던져서 합이 10을 넘으면 두 수를 더하고 > 덧셈결과 : 
		// 아니면 두 수를 곱한 결과를 출력 > 곱셈결과 : 
		
		int zu1 = (int)(Math.random() * 6 ) +1;
		int zu2 = (int)(Math.random() * 6 ) +1;
		int sum = zu1 + zu2;
		int gob = zu1 * zu2;
		
		if(sum >= 10 ) {
			System.out.printf("덧셈결과: %d , 주사위1= %d , 주사위2= %d\n", sum, zu1, zu2);
		}else {
			System.out.printf("곱셈결과: %d , 주사위1= %d , 주사위2= %d\n", gob, zu1, zu2);
		}
		
		//오전시간(9~12) 일정 출력
		//현재 시간 확인
		int time = (int)(Math.random() * 4 ) +9;
		System.out.println("현재시간 : " + time);
		//9시 : 출근합니다
		//10시 : 회의합니다
		//11시 : 업무를 봅니다
		//12시 : 외근을 나갑니다
		
		switch(time) {
		case 9 :
			System.out.println("출근합니다");
		case 10 :
			System.out.println("회의합니다");
		case 11 :
			System.out.println("업무를 봅니다");
		case 12 :
			System.out.println("외근을 나갑니다");
		}
		System.out.println("오늘 일정 끝");
		
		
		//p169 문제3 switch문으로 변경
		int score = 85;
		int gradeSco = score/10;
		
		System.out.println("등급은 ");
		
		switch(gradeSco) {
		case 10 :
		case  9 : 
			System.out.println("A"); break;
		case  8 :
			System.out.println("B"); break;
		case  7 :
			System.out.println("C"); break;
		default :
			System.out.println("D");
		}
		
		System.out.println("입니다.");
		
		
		// 주사위 게임
		// 주사위 2개를 던져서 합이 10이 되면 탈출
		  //주사위 순서쌍 출력 ex(5,2)
		// 5회 이상이 되면 게임오버 출력
		
		
		
		
		for(int i = 1; i <= 5; i ++) {
			System.out.println(i + "회");
			
			int dice1 = (int)(Math.random() * 6 ) +1;
			int dice2 = (int)(Math.random() * 6 ) +1;
			int diceSum = dice1 + dice2;
			
			System.out.printf("%d , %d \n" , dice1, dice2);
			
			if(diceSum == 10) {
				System.out.println("탈출");
				break;
			}
			if(i == 5) {
				System.out.println("게임오버");
			}
		} 
		
		
		
		

	}//end main

}//end class
