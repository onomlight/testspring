<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TEST9.JSP PAGE</h1>
<%-- <%@page import = "com.korea.domain.*" %>

<%
	SampleDTO dto = (SampleDTO)request.getAttribute("dto");
%> --%>
<%-- name : <%=dto.getName() %><br>
age : <%=dto.getAge() %><br> --%>


name : ${dto.name}<br>
age : ${dto.age }


</body>
</html>