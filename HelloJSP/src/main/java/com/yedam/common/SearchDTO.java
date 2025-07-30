package com.yedam.common;
// 글목록에 사용되는 파라미터를 클래스로 등록

import lombok.Data;

@Data
public class SearchDTO {
	private int page;
	private String searchCondition;
	private String keyword;
}
