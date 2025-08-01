<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
 <!-- 액션태그 -->

<h3>게시글 작성(register_form.jsp)</h3>
	
<form action='addBoard.do' method='post' enctype="multipart/form-data">  <!-- enctype="multipart/form-data  데이터(첨부)자료 처리하려면 써줘야함 -->
	<input type="hidden" name="writer" value="${logId }" class='form-control'>
	<table border='1'class='table table-striped'>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" class='form-control'></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${logId }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" class='form-control'></textarea></td>
		</tr>
		<tr>
			<th>이미지</th>
			<td><input type="file" name="images" class='form-control'></td>
		</tr>
		<tr>
			<td colspan='2' align='center'><input type="submit"></td>
		</tr>
	</table>
</form>
