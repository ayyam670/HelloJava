package 황지원;

public class Study07 {

	public static void main(String[] args) {
		// 7. 3, 6, 9게임 프로그램
		// 1~50까지 3, 6, 9가 들어가는 숫자마다 3, 6, 9가 들어가 있는 개수 만큼
		//  ♥ 출력하는 프로그램 작성 
		
		String result = "";
		
		for(int i = 1; i < 51; i++)
		{
			int ten = i / 10;
			int one = i % 10;
			int cnt = 0;
			
			
			if(ten == 3)
			{
				cnt++;
			}
			if(one == 3 || one == 6 || one == 9)
			{
				cnt++;
			}
			
			
			
			if(cnt == 2)
			{
				result += "♥♥\t";
			}else if(cnt == 1)
			{
				result += "♥\t";
			}else
				result += i + "\t";
			
			
			
			
			if(i % 10 == 0)
			{
				result += "\n";
			}
		}
		System.out.println(result);
	}//end

}//end
