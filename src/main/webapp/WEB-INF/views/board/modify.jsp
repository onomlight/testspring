<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div id="wrapper" class="container-md">
		<div id="top-header">
		</div> 
		<div id="nav">
			<%@include file="/resources/includes/nav.jsp" %>
		</div>
		<div id="contents">
			
			<h1>Board Modify Page</h1>
			<form role="form" action="/board/modify" method="post">
				<input class = "form-control mt-2" name="title" placeholder="title" value=${board.title } readonly>
				
				<textarea name="content" class="form-control mt-2" readonly>${board.content }</textarea>
				<input class="form-control mt-2" name="writer" placeholder="writer" value=${board.writer } readonly>
				<input type="submit" value="글수정" class="btn btn-primary mt-2">
				<input type="reset" value="리스트 이동" class="btn btn-primary mt-2">
			</form>
		</div>
	
	</div>
</body>
</html>