/**
 * Exam.js
 * 문자열 메소드(indexOf, substring, slice, split, toUpperCase, toLowerCase, trim, replace, includes, charAt)
 */

//1번)

let strAry = [" Hello, Java          "
			, " HTML, Css, JavaScript  "
			, "     Java is complier    "
			, "          Java and Javascript     "];
let filterWord = "java";

/*결과 => "HELLO, ****"
       "HTML, CSS, ****SCRIPT"
	   "**** IS COMPILER"
	   "**** AND ****SCRIPT"
*/ 
/*	for(let i=0; i < strAry.length; i++)
		{
			let result = strAry[i].trim().toLowerCase().replace(/java/g, "****").toUpperCase();
			console.log(result);
		}
*/		

		strAry.forEach(elem =>
			{
			let result = elem.trim().toLowerCase().replace(/java/g, "****").toUpperCase();
			console.log(result);
		});	




//2번

let noAry = ["920304-1213421", "990508 2928123", "030702-4323123"]

/*결과 => "920304-1213421"은 남자입니다
	   "990508 2928123"은 여자입니다
	   "030702-4323123"은 여자입니다
*/	   
	
		noAry.forEach(elem =>
			{
			if(elem.slice(-7)[0] == 1 || elem.slice(-7)[0] == 3)
				{
				console.log(elem+ '은 남자입니다.');
				}else if(elem.slice(-7)[0] == 2 || elem.slice(-7)[0] == 4)
				{
					console.log(elem + '은 여자입니다.');
				}
		});
		
		/*for(let i = 0; i < noAry.length; i++)
			{
				if(noAry[i].slice(-7)[0] == 1 || noAry[i].slice(-7)[0] == 3)
					{
						console.log(`${noAry[i]} 는 남자입니다.`);
					}else
					{
						console.log(`${noAry[i]} 는 여자입니다.`);
					}
			}
			*/





