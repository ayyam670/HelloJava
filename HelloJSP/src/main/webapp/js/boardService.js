/**
 * boardService.js
 * fetch 여기 정리해서 메소드형태로 board.js에 호출하는 방식으로 변경
 */

class PageVO
{
	// 생성자
	constructor(currPage, totalCnt)
	{
		this.currPage = currPage; // currPage 필드선언.
		this.totalCnt = totalCnt;
		// start, end 계산.
		this.end = Math.ceil(currPage / 10) * 10; // ceil 올림, 10page.
		this.start = this.end - 9; // 1page.
		this.realEnd = Math.ceil(totalCnt / 5); // 페이지는 올림해줘야함
		//let realEnd = Math.ceil(totalCnt / 5); // 페이지는 올림해줘야함
		this.end = this.end > this.realEnd ? this.realEnd : this.end;
		// prev, next 계산.
		this.prev = this.start > 1;
		this.next = this.end < this.realEnd;
		
	}
}



const svc = 
{
	count:20, // 속성(property)
	increaseCount: function()  //메소드
	{
		this.count++;
	},
	showCount()
	{
		return this.count;
	},
	//목록 ajax 메소드
	replyList(param = {bno: 1, page: 1}, successCallback, errorCallback)
	{
		fetch('replyList.do?bno=' + param.bno + '&page=' + param.page)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	//삭제 ajax 메소드.
	removeReply(rno, successCallback, errorCallback)
	{
		fetch('removeReply.do?rno=' + rno)
			.then(resolve => resolve.json())
			.then(successCallback) //board.js 145째줄
			.catch(errorCallback) // board.js err
	},
	//등록 ajax 메소드
	registerReply(param = {bno, reply, replyer}, successCallback, errorCallback)
	{
		fetch('addReply.do?bno=' + param.bno + '&reply=' + param.reply + '&replyer=' + param.replyer)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	//추가 메소드
	//bno에 대한 전체건수 얻는 ajax 메소드
	replyTotalCount(bno, successCallback, errorCallback)
	{
		fetch('totalReply.do?bno=' + bno)
			.then(resolve => resolve.json())
			.then(successCallback)
			.catch(errorCallback)
	}
	
	
	
}