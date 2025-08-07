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
		result => result.forEach(reply =>
			{
				// insertAdjacentHTML
				let target = document.querySelector('div.content>ul');
				let text = `<li>
								<span class="col-sm-2">${reply.replyNo}</span>
								<span class="col-sm-5">${reply.reply}</span>
								<span class="col-sm-2">${reply.logId}</span>
								<span class="col-sm-2"><button onclick='deleteRowFnc(event)'>삭제</button></span>
							</li>`;
				target.insertAdjacentHTML('beforeend', text); // position, text
				
				//let li = makeRow(reply);
				//document.querySelector('div.content>ul').appendChild(li);
			}),   // 두번째 param
		err => console.error(err)  // 세번째 param
	);
	pagingList();
}// END showReplyList
showReplyList(); // 최초목록 출력.
	


// 페이징 목록 출력.
function pagingList()
{
	svc.replyTotalCount(bno,
		result => 
		{
			let totalCnt = result.totalCnt; // 80
			let paging = new PageVO(page, totalCnt);
			console.log(paging);
			
			// parent 요소.
			let target = document.querySelector('div.pagination');
			target.innerHTML = ''; //기존에 있던 목록 삭제
			
			// 이전 페이지 여부
			if (paging.prev)
			{
				let atag = document.createElement('a');
				atag.href = paging.start - 1;
				atag.setAttribute('data-page', paging.start -1);
				atag.innerHTML = '&laquo;';
				target.appendChild(atag);
			}
			
			// start ~ end
			for(let p = paging.start;  p <= paging.end; p++)
			{
				let atag = document.createElement('a');
				atag.href = p; //setAttribute('href', p); // <a href ="3">
				atag.setAttribute('data-page', p);
				atag.innerText = p;
				
				if(p == paging.currPage)
				{
					atag.setAttribute('class', 'active');
				}
				
				
				target.appendChild(atag); // <div class="pagination"><a/><div>
			}
			// 이후 페이지
			if (paging.next)
			{
				let atag = document.createElement('a');
				atag.href = paging.end + 1;
				atag.setAttribute('data-page', paging.end + 1);
				atag.innerHTML = '&raquo;';
				target.appendChild(atag);
			}
			// a태그에 클릭이벤트.
			addEventClick();
		},
		err => console.error(err)
	);
}



// 이벤트 등록.
//function addEvent()
//{
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
						showReplyList();
						//let r = result.retVal;
						//let li = makeRow(r);
						//document.querySelector('div.content>ul').appendChild(li);
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
//}

	
// 페이지 링크에 클릭 이벤트
function addEventClick()
{
	document.querySelectorAll('div.footer>div.pagination>a')
	.forEach(atag =>
	{
		atag.addEventListener('click', e =>
		{
			e.preventDefault(); // 태그의 기본기능을 막는 기능
			page = e.target.dataset.page; // data-page => dataset.page
			//console.log(page);
			//목록 그려주기
			showReplyList();
			//console.log(e);
		})
	})
}



	
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
	rno = e.target.closest('li').firstElementchildren[0].innerText;
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
				alert('삭제실패!!')
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
				//e.target.parentElement.parentElement.remove();
				showReplyList()
				
			}else if (result.retCode == 'NG')
			{
				alert('삭제 실패!!')
			}else
			{
				alert('알수 없는 코드입니다.')	
			}
		},
		err => console.error(err)
	);
		
}// end deleteRowFnc

