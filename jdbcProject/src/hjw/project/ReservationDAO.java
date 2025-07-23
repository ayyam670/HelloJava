package hjw.project;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class ReservationDAO {

	public void showFromToday()
	{
		LocalDate today = LocalDate.now();
		YearMonth thisMonth = YearMonth.now();
		
		int startDay = today.getDayOfMonth();     // 오늘 날짜 (예: 23)
		int lastDay = thisMonth.lengthOfMonth();  // 이 달의 마지막 날 (예: 31)
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM월 dd일 (E)");
		System.out.println("예약 가능한 날짜:");
		
		int count = 0;
		
		for(int day = startDay; day <= lastDay; day++)
		{
			LocalDate date = thisMonth.atDay(day);
			System.out.print(date.format(formatter) + " ");
			
			count++;
			
			if (count % 7 == 0) {
                System.out.println(); // 7개마다 줄바꿈
            }
		}
		System.out.println();
	}
	
}//end class
