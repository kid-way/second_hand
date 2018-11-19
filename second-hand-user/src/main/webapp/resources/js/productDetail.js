$(document).ready(function(){
	$("#fc").on("change",function(){
		var fcid = $("#fc").val();
		if(fcid==null){
			console.log('fcid:'+fcid);
		}else{
			$.ajax({
				type:"post",
				url:"/second-hand-user/"+fcid+"/getSecondCategory",
				dataType:"json",
				success:function(data){
					$("#sc").html("");
					for(var i = 0;i<data.length;i++){
						var str = "<option value='"+data[i].scid+"'>"+data[i].scname+"</option>";
						$("#sc").append(str);
					}
				}
			});
		}
	});
})