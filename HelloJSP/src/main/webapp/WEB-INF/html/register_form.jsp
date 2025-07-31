<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

	
<jsp:include page = "includes/header.jsp" />    <!-- 액션태그 -->

<h3>게시글 작성(register_form.jsp)</h3>
	
<form action='addBoard.do' method='post'>
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
			<td colspan='2' align='center'><input type="submit"></td>
		</tr>
	</table>
</form>

<jsp:include page="includes/footer.jsp" />