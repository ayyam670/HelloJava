package chap04;

public class Gugudan {

	public static void main(String[] args) {
		// 구구단
		//단 반복
//		for(int dan = 2; dan < 10; dan++) {
//			System.out.println("----" + dan + "단----");
//			for(int gob = 1; gob < 10; gob++) {
//				System.out.printf("%d X %d = %d\n",dan, gob, dan*gob);
//			}
//			System.out.println();
//		}
		
		// 구구단2
		int dan =0;
		
		for(dan = 2; dan < 10; dan++) {
			System.out.print("----" + dan + "단----\t");
		}
			System.out.println();
		for(dan = 1; dan < 10; dan ++) {
			for(int gob = 2; gob < 10; gob++) {
				System.out.printf("%d X %d = %2d\t", gob ,dan ,dan*gob );
			}
			System.out.println();
			
		}
		
		//183p 문제 5
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		

	}//end main

}//end class
