package 황지원;

public class Study04 {

	public static void main(String[] args) {
		//4. 구구단 프로그램
		int gob = 0;
		
		for(int i = 2; i < 10; i++)
		{
			System.out.print("\t  " + i + "단");
		}	
			System.out.println();
			
			
		for(int i = 1; i < 10; i++)
		{
			for(int j = 2; j < 10; j++)
			{
				gob = i * j;
				
				System.out.printf("\t%dx%d=%2d",j ,i , gob);
			}
			System.out.println();
		}
		

	}

}
