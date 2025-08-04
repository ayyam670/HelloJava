/**
 * todo1.js
 */
const students = [];
students.push({sname: "이길동", score: 80});
//students.pop();


function showScore()
{
	students.forEach(function(elem, idx, ary)
	{
		let scr = `<tr><td>${elem.sname}</td><td>${elem.score}</td></tr>`;
		document.querySelector('#tlist').innerHTML += scr;
	});
}//end showScore
showScore();


document.querySelector('#addList').addEventListener('click', function()
{
	let name = document.querySelector('#std_name').value;
	let score = document.querySelector('#std_score').value;
	
	if(name == '' || score == '')
		{
			window.alert('필수값을 입력해주세요!!')
			return;
		}
		
	document.querySelector('#tlist').innerHTML = '';
	
	students.push({sname : name, score : score});
	showScore();
	document.querySelector('#std_name').value = '';
	document.querySelector('#std_score').value = '';
})
