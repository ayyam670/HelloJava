package com.yedam.vo;

import lombok.Data;

@Data
public class EventVO {
	
	//테이블 컬럼에 맞춰 속성 정의
	
	private int eventNo;
	private String title;
	private String stDate;
	private String edDate;
}
