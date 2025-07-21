package chap06;

public class StudentDao {
	//학생 데이터 생성
	//필드
	//생성자 : 기본생성자 => 컴파일 할 때 자동으로 생성
	//메소드
	Student[] stData()
	{
		Student[] students = 
			{
				new Student("홍길동", 100, 100, 100),
				new Student("강길동", 90, 90, 90),
				new Student("이길동", 100, 50, 100),
				new Student("황길동", 100, 40, 100),
				new Student("고길동", 70, 100, 100),
				new Student("김씨", 60, 80, 50),
				new Student("강씨", 90, 90, 90),
				new Student("성씨", 60, 50, 80),
				new Student("최씨", 70, 40, 70),
				new Student("박씨", 70, 50, 90)
			};
		return students;
		
	}
	
	
	
}//end class
