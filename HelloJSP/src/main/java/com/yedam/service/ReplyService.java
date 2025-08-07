package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo, int page); // 목록
	boolean removeReply(int replyNo); // 삭제
	boolean addReply(ReplyVO reply); // 등록
	int replyCount(int bno); // 댓글 건수 계산
}
