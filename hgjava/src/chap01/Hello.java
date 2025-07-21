package chap01;

public class Hello {

	public static void main(String[] args) {
		// 출력문
		System.out.println("hello java!!!");
		int a = 7;
		System.out.println(a);
		
		//변수의 값 교환
		int x = 10;
		int y = 50;
		int temp = y;
		y = x;
		x = temp;
		System.out.println("x= " + x + " y= " + y);
		
		//기본타입
		char font = 'A';
		int intchar = font +1;
		char font2 = (char)intchar;
		System.out.println(font);
		System.out.print(intchar + "\n");
		System.out.println(font2);
		
		//문자열 저장 => String 객체타입 변수 생성
		String str = "홍길동";
		System.out.println(str);
		
		//연산 : 정수 => 기본타입 int, 실수 => 기본타입 double
		int su1 = 1;
		int su2 = 3;
//		int result = su1 / su2;
		double result = su1 / su2;   // int / int = int
		
		//결과 - 0.33333....
		result = (double)su1 / su2;
		System.out.println(result);
		
		//문자열 비교
		String str1 = "신용권";
		String str2 = "신용권";
		String str3 = new String("신용권");
		boolean resultStr = str1 == str2;        // 주소비교 => 같은 객체인지 확인
		boolean resultobj = str2 == str3;
		System.out.println(resultStr);             //같은 객체
		System.out.println(resultobj);             //다른 객체
		System.out.println(str1.equals(str3));   // 객체 데이터 자체를 비교
		
		//&=, |=, ^=   연산
		int r1 = 1 & 2;
		int r2 = 1 | 2;
		int r3 = 1 ^ 2;
		System.out.println("and 연산 = " + r1);
		System.out.println("or 연산 = " + r2);
		System.out.println("xor 연산 = " + r3);
		
		
		// 수 20이 4의 배수이면서 5의 배수인지 체크 if
		// 결과 = 20은 4와 5의 배수입니다. 출력 printf
		// 아니면 20은 4와 5의 배수가 아닙니다. 출력 printf
		int num = 55;
		if (num % 4 == 0 && num % 5 == 0) {
			System.out.printf("%d은 4와 5의 배수입니다\n",num);
		}else {
			System.out.printf("%d은 4와 5의 배수가 아닙니다\n",num);
		}
		
		//홀수 짝수 구별(삼항연산자)
		// 수는 20 이용
		String result12 = num % 2 == 0 ? "짝수" : "홀수";
		System.out.println(result12);
		
		
		
	}

}
