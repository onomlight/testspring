<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>Reply Test Form</h1>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>
	function requestreply(){
		
		var info = {
				"bno" : $("#bno").val(),
				"reply" : $("#reply").val(),
				"replyer" : $("#replyer").val()
		};
		
		$.ajax({
			type :"POST",
			url : "/replies/new"
		    async: true,
		    data : JSON.stringify(info),
		    dataType : "json",
		    contentType:"application/json;charset=UTF-8",
		    success : function(data){
		    	;
		    },
		    error : function(error){
		    	console.log(error);
		    }
		    
			
		})
	}

</script>
				<input type="text" name="tno" id="bno" placeholder="bno">
				<input type="text" name="owner" id="reply" placeholder="reply">
				<input type="text" name="grade" id="replyer" placeholder="replyer">
				<button onclick="requestreply()">전송</button>
				
</body>
</html>