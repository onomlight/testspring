<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@page import="java.util.*,com.korea.domain.*" %>
	<%
		BoardVO board = (BoardVO)request.getAttribute("board");
		out.println("board :" +board);
	%>

</body>
</html>