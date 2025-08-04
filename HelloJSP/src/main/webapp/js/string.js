/**
 * string.js
 * 문자열 메소드(indexOf, substring, slice, split, toUpperCase, toLowerCase, trim, replace, includes, charAt)
 */

let idx = "Hello, World".indexOf('W');
console.log(idx); // 찾는 값이 없을경우 -> -1 값을 반환.
idx = "Hello, World".indexOf("Hel");
if(idx == -1)
	{
		console.log("찾는 문자열이 없습니다.")
	}
console.log(idx);

const names = ['홍길동', '이길동', '삼길동', '사길동'];
// '길동' 이름이 총 몇명인지를 반환하는 함수를 생성.
let cnt = 0;
function getKildong()
{
	for(let i = 0; i < names.length; i++)
		{
			idx = names.indexOf('길동')
			cnt++;
		}
	console.log("'" + cnt + "'" + "명 입니다.");
}
getKildong();


/*function getKildong()
{
	names.forEach(elem =>
		{
			if(elem.indexOf('이') == 0) // ('길동') != -1 없으면 -1이 반환 , 인덱스[0]  = 성
				{
					cnt++;
				};
		});
	console.log(`'${cnt}'명 입니다.`);
}
getKildong();
*/

const obj =
{
	name : '홍길동', //obj.name
	age : 20,
	info : function()
	{
		return `이름은 ${this.name}, 나이는 ${this.age}`;
	}
}
console.log(obj.name); 

Array.prototype.sum = function(num1)
{
	this.push(num1);
}

const numbers = [1,2];
numbers.push(3);
numbers.sum(4);

console.log(numbers);