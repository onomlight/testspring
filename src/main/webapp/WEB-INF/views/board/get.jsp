<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <%@include file="/resources/includes/link.jsp" %>
    <script type="text/javascript" src="resources/js/reply.js"></script>
</head>
<body>

	<script>
		console.log(replyService);
	</script>

<%@page import="java.util.*,com.korea.domain.*" %>
	<%
		BoardVO board = (BoardVO)request.getAttribute("board");
		out.println("board :" +board);
	%>
 
	<div id="wrpper" class="container-md">
		<div id="top-header"></div>
		
		<div id="nav">
			<%@include file="/resources/includes/nav.jsp" %>
		</div>
		<div id="contents">
			<!-- 글보기 화면 처리 -->
			<h1>Board Read PAge</h1>
				<input class="form-control mt-2" name="title" placeholder="title">
				<textarea name="content" class="form-control mt-2 " readonly>${board.content }</textarea>
				<input class="form-control mt-2" name="writer" placeholder="writer">
		</div>
	</div>
	<script >
		console.log(replySerivce);
		
		var bnoValue = ${board.bno};
		
		replyService.getList(
				{bno:bnoValue,page:1},
				function (list) {
					for (i=0,len=list.length||0;i<len;i++){
						console.log(list[i]);
					}
				}
					
					
				)
		
		//fir replySerivce add test
		
		/*replyService.add(
				{reply:"JS TEST",replyer:"tester", bno:bnoValue}
				,
				function (result) {
					alert("RESULT : " + result); 
			}
			
		})
		*/
	</script>
</body>
</html>