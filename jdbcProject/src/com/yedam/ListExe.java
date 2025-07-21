package com.yedam;

import java.util.ArrayList;

public class ListExe {
	public static void main(String[] args) {
	  //ArrayList 클래스.
		int[] intAry = {10,20,30};
		for(int i=0; i < intAry.length; i++)
		{
			System.out.printf("[%d]번째 값 => %d\n",i+1, intAry[i]);
		}
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10); // 추가
		list.add(20);
		list.add(30);
		for(int i = 0; i < list.size(); i++)  //length 대신에 size()
		{
			System.out.printf("[%d]번째 값 => %d\n",i+1, list.get(i));  // get
		}
		
		System.out.println("end of prog.");
		
		//학생정보
		ArrayList<Student> stdList = new ArrayList<Student>();
		Student s1 = new Student(); //인스턴스
		s1.setStdNo(1000);
		s1.setStdName("홍길동");
		s1.setPhone("010-1234-5678");
		s1.setBloodType("o");
		
		
		Student s2 = new Student(2000, "최민정", "010-0000-0000", "B");
		
		
		
		stdList.add(s1);
		stdList.add(s2);
		stdList.add(new Student(3000, "최민식", "010-1111-2222", "A"));
		
		for(int i = 0; i < stdList.size(); i++)
		{
			System.out.println("학번 : " + stdList.get(i).getStdNo() + ", 이름 : " + stdList.get(i).getStdName());
		}
		
		
}//end main
	
	
	
}
