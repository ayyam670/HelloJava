/**
 * dom.js
 * <ul id = "target">
			<li>apple</li>
			<li>banana</li>
		</ul>
*/
let ul = document.createElement('ul'); // <ul />
ul.setAttribute('id', 'target');
let li = document.createElement('li'); // <li />
li.innerText = 'apple';
ul.appendChild(li); // 앞에 있는 요소에 새로운 요소를 추가하겠습니다.

//banana 추가
li = document.createElement('li'); // <li />
li.innerText = 'banana';
ul.appendChild(li);

console.log(ul); // <ul id = 'target'><li>apple</li><li>banana</li></ul>

//<div id = 'show' />
document.querySelector('#show').appendChild(ul);