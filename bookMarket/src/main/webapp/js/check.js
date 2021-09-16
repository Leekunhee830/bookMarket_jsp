$(document).ready(function() {
	
	$('#user_password1 , #user_password2').blur(function(){
		var password1=$("#user_password1").val();
		var password2=$("#user_password2").val();
		
		if(password1!=password2){
			$('#password_check').text('두 비밀번호가 일치하지 않습니다.');
			$("#password_check").css("color", "red");
		}else{
			$('#password_check').text('사용 가능합니다.');
			$("#password_check").css("color", "green");
		}
	});
	
	$('#user_id').blur(function(){
		user_id=$('#user_id').val();
		$.ajax({
			url:'${pageContext.request.contextPath}/join/idCheck.do',
			type:'post',
			data:{user_id:user_id},
			success:function(result){
				if(result>=1){
					$('#id_check').text('중복된 아이디입니다.');
					$("#id_check").css("color", "red");
				}else{
					$('#id_check').text('사용가능한 아이디입니다.');
					$("#id_check").css("color", "green");
				}
			},
			error:function(){
				alert("에러");
			}		
		});
	});
	
});