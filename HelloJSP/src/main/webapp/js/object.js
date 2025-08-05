/**
 * object.js
 */
console.log(members);

console.log(members[0]);

for(let member of members)
	{
		//let member = members[1]; // {id:?, fn:?, ln:?...}
		//let id = member.id;
		//let first_name = member.first_name;
		//한번에 하려면 디스트럭칭
		let {id, first_name, last_name, email} = member;
		console.log(`${id}, ${first_name}, ${last_name}, ${email}`);
		let tr = document.createElement('tr');
		
		// member.id
		// member['id'] 두개 같음
		// for .. in ..
		for(let prop in member)
			{
				console.log(`속성: ${prop}, 값: ${member[prop]}`);
				if(prop == 'gender')
					{
						if(member[prop] == 'Female')
							{
								tr.style.backgroundColor = 'pink';
							}else if(member[prop] == 'Male')
								{
									tr.style.backgroundColor = 'yellow';
								}
					}
				
				let td = document.createElement('td');
				td.innerText = member[prop]; // <td>Messi</td>
				tr.appendChild(td);
			}//for in
			
		//삭제버튼 <td><button>삭제</button></td>
		let td = document.createElement('td');
		let btn = document.createElement('button');
		// 이벤트 & 이벤트핸들러.
		btn.addEventListener('click', (e)=> {
			console.dir(e.target.parentElement.parentElement);
			//console.dir(e.target);
			let parent = e.target.parentElement.parentElement;
			console.log(parent.children);
			let fn = parent.children[1].innerText;
			let ln = parent.children[2].innerText;
			
			if(confirm(`${fn} ${ln}을 삭제하시겠습니까?`))
				{
					e.target.parentElement.parentElement.remove();
				}
			
			//e.target.parentElement.parentElement.remove(); // td -> td -> tr    tr = e.target.parentElement.parentElement을 삭제
			
			
		});
		btn.innerText = '삭제';
		td.appendChild(btn);
		tr.appendChild(td);
			
		document.querySelector('#show tbody').appendChild(tr);

	}//for of
	
let sum = 0;	
	                                            //nth-of-type 그 중에 6번째
document.querySelectorAll('#show tbody tr td:nth-of-type(6)').forEach(elem => sum += parseInt(elem.innerText));
/* 위에랑 같은데 children[]사용한것
document.querySelectorAll('#show tbody tr').forEach(elem => 
	{
		let salary = elem.children[5].innerText;
		sum += parseInt(salary);
	});
*/
console.log(`급여 합계는 ${sum} 입니다`);