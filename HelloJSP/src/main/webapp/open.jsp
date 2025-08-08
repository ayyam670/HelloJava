<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<title>Insert title here</title>
<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
	<header>
        <div class="col-sm-2">검색</div>
        <select class="form-control" id="search"></select>
    </header>
    <main>
        <div id="show">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>센터ID</th>
                        <th>센터명</th>
                        <th>전화번호</th>
                    </tr>
                </thead>
                <tbody id="list"></tbody>
            </table>
        </div>
    </main>
	<script>
	let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=qbMm0VxCZ9isUyfHfVs3TQxD%2BRbu8GFJGvI8Uw9guJnlMg3kmJC7LlVMMjKwLy1bsRdynUNVyBYkPULfMZ1tfg%3D%3D`;
	
	document.querySelector('#search').addEventListener('change', (e) =>
	{
		let sido = e.target.value;
		searchCenterList(sido);
	});
	
	// 검색목록 생성
searchCenterList('서울특별시');
	
fetch(url)
	.then(resolve => resolve.json())
	.then(result =>
	{
		const search = document.getElementById('search');
		result.data.reduce((acc, elem) =>
		{
			if(acc.indexOf(elem.sido) == -1)
			{
				acc.push(elem.sido); // ['서울특별시', '제주자치도']
			}
			return acc; // 다음순번의 acc 값으로 활용.
		}, [])
			.forEach(elem => 
			{
				//<option value="서울특별시"></option>
				let opt = document.createElement('option');
				opt.value = elem;
				opt.innerHTML = elem;
				search.appendChild(opt);
			});
	})
	.catch(err => console.error(err));


function searchCenterList(sido)
{	

	fetch(url)
		.then(resolve => resolve.json())
		.then(result =>
		{
			document.querySelector('#list').innerHTML = ''; // 기존목록 지우기
			//console.log(result.data[0]);
			
			result.data.forEach(elem => // 전체목록배열
			{
				console.log(elem);
				if(sido == '전체' || elem.sido == sido)
				{
					let tr = document.createElement('tr');
					tr.addEventListener('click', function(e){
						window.open('daumApi.jsp?lat=' + elem.lat + '&lng=' + elem.lng);
					});
					['id', 'centerName', 'phoneNumber'].forEach(prop =>  // 속성배열
					{
						let td = document.createElement('td');
						td.innerText = elem[prop];
						tr.appendChild(td);
						
					})
					// 생성한 tr을 tbody에 하위요소로 등록.
					document.getElementById('list').appendChild(tr);
				}
			})
		})
		.catch(err => console.error(err));
}

	</script>
</body>
</html>