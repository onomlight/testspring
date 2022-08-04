<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	
	<%@include file="/resources/includes/link.jsp" %>
	

</head>
<body>
	<div id="wrapper" class="container-md">
		<div id="top-header">
		
		</div>
		<div id="nav">
			<%@include file="/resources/includes/nav.jsp" %>
		</div>
	<!-- 	33p <div id="contents">
			<div class=mt-3 style=text-align:right;>
				<a class="btn btn-secondary" href="/board/register">글등록</a>
			</div> -->
		<!-- 목록 화면 처리  -->
			<table class="table table-striped table-hover table-bordered mt-3">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>수정일</th>
				</tr>
				
				
				<c:forEach items="${list}" var="board">
				<tr>
					<td><c:out value="${board.bno }"/></td>
					<td><a href="/board/get?bno=${board.bno }"></a><c:out value="${board.title }"/></td>
					<td><c:out value="${board.writer }"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}"/></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"/></td>
					
				</tr>
				</c:forEach>
			</table>
			
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
				  Launch static backdrop modal
				</button>
				

				<!-- Modal 시작 -->
				<div class="modal" tabindex="-1" id=myModal>
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
				        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				      </div>
				      <div class="modal-body">
				        <p>Modal body text goes here. </p>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				        <button type="button" class="btn btn-primary">Save changes</button>
				      </div>
				    </div>
				  </div>
				</div>
				<!-- 모달끝 -->
				
		</div>
	</div>

</body>
<script >
	$(document).ready(function () {
		var result = '<c:out value="${result}"/>';
		checkModal(result);
		//추가
		history.replaceState({},null,null);
		function checkModal(result){
			if(result===' '||history.state){
				return ;
			}
			if(parseInt(result)>0){
				$(".modal-body").html("게시물 : " + parseInt(result)+" 번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}
	})
</script>
</html>