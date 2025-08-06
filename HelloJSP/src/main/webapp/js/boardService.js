/**
 * boardService.js
 * fetch 여기 정리해서 메소드형태로 board.js에 호출하는 방식으로 변경
 */

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
	
}