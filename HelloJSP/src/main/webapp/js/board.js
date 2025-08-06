/**
 * board.js
 * 144 댓글 정보 => json 반환.
 * svc.increaseCount(); 
 *  console.log(svc.showCount());
 */

let page = 1; // page 값을 변경

// fetch 는 페이지 로딩 시점에 바로 실행.
/*
fetch('replyList.do?bno=' + bno) // bno는 board.jsp에 선언되어있음
	.then(function(resolve)
	{
		return resolve.json(); // fetch 의 결과값이 readablsStream
	})
	.then(function(result)
	{
		console.log(result);
		result.forEach(reply =>
		{
			let li = makeRow(reply);
			document.querySelector('div.content>ul').appendChild(li);
		})
	})
	.catch(function(err)
	{
		console.error(err);	
	});
*/	

//boardService svc에 넣는 내용
function showReplyList()
{
	// 기존 목록을 지우고 새로 보여주는 기능
	document.querySelectorAll('div.content>ul>li').forEach((elem,idx) =>
	{
		if(idx >= 2)
		{
			elem.remove();
		}
	});
	
	// 목록 출력
	svc.replyList({bno, page}, // 첫번째 param
		result =>
		{
			result.forEach(reply =>
			{
				let li = makeRow(reply);
				document.querySelector('div.content>ul').appendChild(li);
			})
		},   // 두번째 param
		err => console.error(err)  // 세번째 param
	);
}// END showReplyList
showReplyList(); // 최초목록 출력.
	
// 이벤트 등록.
document.querySelector('#addReply').addEventListener('click', function(e)
{
	// 필요한 값 = 게시글 번호(bno), 작성자(logId), 댓글(reply) -> board.jsp 젤 밑에 선언 , reply 는 id = reply로 선언되있음
	let reply = document.querySelector('#reply').value;
	
	if(!bno || !reply || !logId) // true/false => falsy(0, '', null, undefined) 거짓으로 받아들임
	{
		alert('댓글을 입력하거나 로그인을 해주세요.');
		return;
	}
	
	// 서버 호출
/*
	fetch('addReply.do?bno=' + bno + '&reply=' + reply + '&replyer=' + logId)
		.then(resolve => resolve.json()) // js객체
		.then(result =>
			{
				console.log(result);
				if(result.retCode == 'OK')
				{
					let r = result.retVal;
					let li = makeRow(r);
					document.querySelector('div.content>ul').appendChild(li);
				}
				else if(result.retCode == 'NG')
				{
					alert('처리중 예외발생');
				}
				else{
					alert('알수 없는 코드');
				}
			})
		.catch(err => console.error(err));
*/
		
		svc.registerReply({bno, reply, replyer: logId}, // 첫번째 param
		result =>
			{
				console.log(result);
				if(result.retCode == 'OK')
				{
					let r = result.retVal;
					let li = makeRow(r);
					document.querySelector('div.content>ul').appendChild(li);
				}
				else if(result.retCode == 'NG')
				{
					alert('처리중 예외발생');
				}
				else{
					alert('알수 없는 코드');
				}
			},  // 두번째 param
			err => console.error(err) // 세번째 param
		);
});
	
// 페이지 링크에 클릭 이벤트
document.querySelectorAll('div.footer>div.pagination>a')
.forEach(atag =>
{
	atag.addEventListener('click', e =>
	{
		e.preventDefault(); // 태그의 기본기능을 막는 기능
		page = e.target.innerText;
		//목록 그려주기
		showReplyList();
	})
})



	
// 댓글 정보를 활용해서 li>span 구조 만들기
function makeRow(reply)
{
	let li = document.createElement('li');
	['replyNo', 'reply', 'replyer'].forEach(elem =>
	{
		let span = document.createElement('span');
		span.innerText = reply[elem];
		if(elem == 'reply')
		{
			span.setAttribute('class', 'col-sm-5')	
		}else
		{
			span.setAttribute('class', 'col-sm-2')
		}
		li.appendChild(span);
	})//반복
	
	//삭제버튼
	let span = document.createElement('span');
	span.setAttribute('class', 'col-sm-2');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRowFnc)
	
	btn.innerText = '삭제';
	span.appendChild(btn);
	li.appendChild(span);
	
	return li;
}//end  makeRow



//데이터 삭제 이벤트 핸들러.
function deleteRowFnc(e)
{
	let rno = e.target.parentElement.parentElement.children[0].innerText;
	console.log(rno);
	if(!confirm(`${rno} 번 글을 삭제하시겠습니까?`))
	{
		alert('삭제를 취소했습니다.');
		return;
	}
	
	// fetch 서버프로그램(servlet) 호출.
/*	fetch('removeReply.do?rno=' + rno)
		.then(resolve => resolve.json())
		.then(result =>
		{
			if(result.retCode =='OK')
			{
				e.target.parentElement.parentElement.remove();
				
			}else if (result.retCode == 'NG')
			{
				alert('삭제살패!!')
			}else
			{
				alert('알수 없는 코드입니다.')	
			}
		})
*/
	svc.removeReply(rno,
		result =>
		{
			if(result.retCode =='OK')
			{
				e.target.parentElement.parentElement.remove();
				
			}else if (result.retCode == 'NG')
			{
				alert('삭제살패!!')
			}else
			{
				alert('알수 없는 코드입니다.')	
			}
		},
		err => console.error(err)
	);
		
}// end deleteRowFnc

