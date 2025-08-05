/**
 * array3.js
 */

let students1 = 
[
	{name: "홍길동", score: 80},
	{name: "이길동", score: 85},
	{name: "삼길동", score: 88},
	{name: "사길동", score: 76}
];

let newAry = students1.reduce((s, elem) =>
{
	let tr = document.createElement('tr');
	
	for(let prop in elem)
		{
			let td = document.createElement('td');
			td.innerText = elem[prop];
			tr.appendChild(td)	;		
		}
		s.appendChild(tr);
		return s;
}, document.querySelector('#item tbody'));
//console.log(`최고점자는 ${result.name}, 점수는 ${result.score} 입니다.`); // 최고점자는 삼길동, 점수는 88점 입니다.

/*
let numAry = [10, 15, 34, 77, 20, 25, 30];
let result = numAry.reduce((acc, elem, idx, ary) =>}
			{
				console.log(`${acc}, ${elem}`);
				//acc => [10]
				
				if(elem % 2 == 0)
				{
					acc.push(elem);
				}
				return acc; //[10, 34, 20, 30]
			}, []);
			
	console.log(result);
	*/