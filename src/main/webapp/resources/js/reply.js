


	console.log("reply Module .....");

	var replySerivce = (function(){
		
		function add(reply,callback,error){
		
		console.log("add reply....");
		
		$.ajax({
		
		type : 'post',
		url : '/replies/new',
		data : JSON.stringify(reply),
		contentType : "application/json;charset=UTF-8",
		success : function(result,status,xhr){
			
			if(callback){
				callback(result);
			}
		},
		error : function(xhr,status,er){
			if(error){
				error(er);
			}
		}
			
			
			
			
		}) // ajax 끝
	} //add함수 끝
	
	
	//모든 댓글 가져오기
	
	function getList(param,callback,error){
		
		var bno = param.bno;
		var page = param.page || 1;
		
		$.getJSON(
			"/replies/pages/" + bno + "/" + page + ".json",
			
			function(data){
				if(callback){
					callback(data);
				}
			}
		).fail(function(xhr,status,err){
			if(error){
				error();
			}
		}) // getJSON끝
		
	}// getList 끝
		
		return{add : add,
			getList : getList
		};
		
		// 14번 66번 부터 해야함
		
	})(); // replyservice 끝
	
	


	


	









