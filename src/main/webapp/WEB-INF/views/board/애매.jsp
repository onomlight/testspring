<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
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
		<div id="contents">
			<!-- 글보기 화면 처리  -->
			<h1>Board Read Page</h1>
			<input class = "form-control mt-2" name="title" placeholder="title" value=${board.title } readonly>
			
			<textarea name="content" class="form-control mt-2" readonly>${board.content }</textarea>
			<input class="form-control mt-2" name="writer" placeholder="writer" value=${board.writer } readonly>
			<input type="submit" value="글수정" class="btn btn-primary mt-2">
			<input type="reset" value="리스트 이동" class="btn btn-primary mt-2">
		</div>
	
	</div>
</body>
</html>