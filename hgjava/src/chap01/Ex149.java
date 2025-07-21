package chap01;

import java.util.Scanner;

public class Ex149 {

	public static void main(String[] args) {
		// p149 이유를 주석으로 표시, 오류 수정
		// 문제1
		byte b =5;
		//b = -b;                   //byte 는 연산하면 int로 출력
		b = (byte)-b;
		int result = 10 / b;
		
		System.out.println(result);
		
		//문제2
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		// z = 11 + 20 y=20-1
		
		System.out.println(z);
		
		//문제3
		//!stop
		
		//문제4
		int pencils = 534;
		int students = 30;
		//학생 1명이 가지는 연필 개수
		int pencilsPerStudent = pencils / students;
		
		System.out.println(pencilsPerStudent);
		
		//남은 연필 갯수
		int pencilsLeft = pencils % students;
		
		System.out.println(pencilsLeft);
		
		//문제5
		/*
		int var1 = 5;
		int var2 = 2;
		double var3 = (double)var1 / var2;
		int var4 = (int) (var3*var2);
		System.out.println(var4);
		*/
		//var4 = 5 = var3 * 2 => var3 를 2.5로 만들어줘야함
		
		//문제6
		int value = 356;
		
		System.out.println(value / 100 * 100);
		
		//문제7
		/*
		float var1 = 10f;
		float var2 = var1 / 100;
		if(var2 == 0.1f) {                      //var2를 float로 변환해주거나 0.1을 float로 만들어줘야 true
			System.out.println("10%입니다.");
		}else {
			System.out.println("10%가 아닙니다.");
		}
		*/
		
		//문제8
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = ((double)(lengthTop+lengthBottom) * height /2);
		
		System.out.println(area);
		
		//문제9
//		
//		Scanner sc9 = new Scanner(System.in);
//		
//		System.out.print("첫 번째 수 입력>>");
//		double num1 = Double.parseDouble(sc9.nextLine());
//		
//		System.out.print("두 번째 수 입력>>");
//		double num2 = Double.parseDouble(sc9.nextLine());
//		double result9 = num1 / num2;
//		
//		 if(num2 == 0 & num2 == 0.0) {
//			  System.out.println("결과 : 무한대");
//		  }else {
//			  System.out.println("결과 : " + result9);
//		  }
//
//		sc9.close();
//		
		
		//문제10
		
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("원의 넓이 : " + var4);
		
		//문제11
//		
//		Scanner sc11 = new Scanner(System.in);
//		
//		System.out.print("아이디: ");
//		String name = sc11.nextLine();
//		
//		System.out.print("패스워드:");
//		String strPw = sc11.nextLine();
//		int password = Integer.parseInt(strPw);
//		
//		if(name.equals("java")) {
//			if(password == 12345) {
//				System.out.println("로그인 성공");
//			}else {
//				System.out.println("로그인 실패 : 패스워드가 틀림");
//			}
//		}else {
//			System.out.println("로그인 실패 : 아이디가 존재하지 않음");
//		}
//		
//		sc11.close();
//
//		
		
		//문제12
		/*
		int x = 10;
		int y = 5;
		
		System.out.println( (x>7) && (y<=5) );                       //true
		System.out.println( (x%3 == 2) || (y%2 != 1) );              //false
		*/
		
		
		
		//문제14
		int score = 85;
		String result14 = (!(score>90)) ? "가" : "나";
		System.out.println(result14); //"가"
		
		
		
		
		//입력된 년도가 윤년인지 계산하는 프로그램 작성
		 //4로 나누어 떨어지고, 100으로 나누어 떨어지지 않으면 윤년
		 //400으로 나누어 떨어지면 윤년
		
		Scanner sc15 = new Scanner(System.in);
		
		System.out.print("## 년도를 입력 : >>");
		int year = Integer.parseInt(sc15.nextLine());
		
		if(year % 4 == 0) {
			if(year % 400 == 0 || year % 100 != 0) {
				System.out.println(year + "년 윤년");
			}else {
				System.out.println(year + "년 평년");
			}
		}else {
			System.out.println(year + "년 평년");
		}
			
		
		sc15.close();
		
		//if(year % 4 == 0 && (year % 400 == 0 || year % 100 !=0))
		
		
		
	}//end main

}//end class
