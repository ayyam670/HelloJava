/**
 * array2.js
 * filter 배열메소드
 * 요소의 값 -> true일 때 그 요소를 새로운 배열에 생성.
 */

function makeRow(member)
{
	//tr > td*7 만들어주는 기능.
	let tr = document.createElement('tr');
			
	for(let prop in member)
		{
			let td = document.createElement('td');
			td.innerText = member[prop]; // <td>Messi</td>
			tr.appendChild(td);
		}//for in
		
	//삭제버튼 <td><button>삭제</button></td>
	let td = document.createElement('td');
	let btn = document.createElement('button');
	// 이벤트 & 이벤트핸들러.
	btn.addEventListener('click', (e)=> {
		//console.dir(e.target);
		let parent = e.target.parentElement.parentElement;
		
		let fn = parent.children[1].innerText;
		let ln = parent.children[2].innerText;
		
		if(confirm(`${fn} ${ln}을 삭제하시겠습니까?`))
			{
				e.target.parentElement.parentElement.remove();
			}
		
	});
	btn.innerText = '삭제';
	td.appendChild(btn);
	tr.appendChild(td);
	
	return tr;
}

// 급여가 7000 이상인 사람들의 목록.
/*members.filter(elem =>
	{
		if(elem.salary >= 7000)
			{
				return true;
			}
	}).forEach(elem =>
		{
			let tr = makeRow(elem);
			document.querySelector('#show tbody').appendChild(tr);
		})
밑에랑 같은거
*/
//obj = {id : 1, fn : 'hong', ln : 'kil', salary : 7000}
members
	.filter(elem => elem.salary >= 7000)
	.filter(elem => elem.gender == 'Female')
	.map(elem =>
		{
			let {id, first_name, last_name, salary} = elem; //{id,fn,ln,email,gender,salary}
			let obj =  {id, first_name, last_name, salary} // !important
			return obj;
		})
	.forEach(elem => document.querySelector('#show tbody')
		.appendChild(makeRow(elem)));


			
			
let result = [10, 20, 30, 40, 50].filter((elem, idx, ary) =>
{
	if(elem >= 30)
		{
			return true;
		}
});

console.log(result);