<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<h3>글상세화면(board.jsp)</h3>
	<!--<c:if test="${!empty msg }">
		<div style="color : red;">${msg }</div>
	</c:if>	-->
		
<form action="modifyForm.do">
<input type="hidden" value="${board_info.boardNo }" name="bno">
<input type="hidden" value="${page }" name="page">


<table class="table">
  <tr>
    <th>글번호</th>
    <td><c:out value = "${board_info.boardNo }" /></td>
    <th>조회수</th>
    <td><c:out value = "${board_info.viewCnt }" /></td>
  </tr>
  <tr>
    <th>제목</th>
    <td colspan='4'><c:out value = "${board_info.title }" /></td>
  </tr>
  <tr>
    <th>내용</th>
    <td colspan='4'><c:out value = "${board_info.content }" /></td>
  </tr>
  <tr>
    <th>작성자</th>
    <td><c:out value = "${board_info.writer }" /></td>
    <th>작성일자</th>
    <td><fmt:formatDate pattern = "yyyy-MM-dd HH:mm:ss" value = "${board_info.creationDate }" /></td>
  </tr>
  <tr>
  	<th>첨부파일명</th>
  	<td colspan = '2'> 
  		<c:out value="${board_info.image }"></c:out>
  	</td>
  	<td rowspan = '2' align = 'center'>
    	<c:choose>
    		<c:when test="${!empty board_info.image }">
    			<img width = "130px" src = 'upload/${board_info.image }'>
    		</c:when>
    		<c:otherwise>
    			<img src = 'https://dummyimage.com/130X130/000/2bb364.jpg&text=No+Image'>
    		</c:otherwise>
    	</c:choose>
    </td>
  </tr>


  <tr>
  	<td colspan ="4" align="center">
  		<input type="submit" value="수정" class="btn btn-success">
  		<button type="button"  onclick ="location.href='remove.do?bno=${board_info.boardNo}' " class="btn btn-danger" ${logId eq board_info.writer ? '': 'disabled'}>삭제</button>
  		<button type="button" onclick = "location.href='boardList.do?page=${page}'" class="btn btn-secondary">목록</button>
  	</td>
  </tr>
  
  	<c:if test="${!empty msg }">
  		<tr>
  			<td colspan ="4" align = "center">
				<div style="color : red;">${msg }</div>
			</td>
  		</tr>
	</c:if>	
  	
</table>
</form>

<!-- 댓글. -->










<script src = "js/board.js"></script>
