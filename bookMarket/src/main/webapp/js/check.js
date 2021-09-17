$(document).ready(function() {

	var id_check=0;
	var pw_check=0;

	$('#user_password1 , #user_password2').blur(function(){
		var password1=$("#user_password1").val();
		var password2=$("#user_password2").val();
		
		if(password1!="" && password2!=""){
			if(password1!=password2){
				$('#password_check').text('두 비밀번호가 일치하지 않습니다.');
				$("#password_check").css("color", "red");
				pw_check=0;
			}else{
				$('#password_check').text('사용 가능합니다.');
				$("#password_check").css("color", "green");
				pw_check=1;
			}
		}else{
			$('#password_check').text('비밀번호를 입력해주세요.');
			$("#password_check").css("color", "red");
			pw_check=0;
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
					id_check=0;
				}
				else{
					if(user_id==""){
						$('#id_check').text('아이디를 입력해주세요.');
						$("#id_check").css("color", "red");
						id_check=0;
					}else{
						$('#id_check').text('사용가능한 아이디입니다.');
						$("#id_check").css("color", "green");
						id_check=1;	
					}
				}
					
			},
			error:function(){
				alert("에러");
			}		
		});
	});
	
	$('#join_button').click(function(){
		if($('#user_name').val()==""){
			alert('이름을 입력해주세요');
			return;
		}
		else if($('#user_phone2,#user_phone3').val()==""){
			alert('전화번호를 입력해주세요.');
			return;
		}
		else if($('#user_email1').val()==""){
			alert('이메일을 입력해주세요.');
			return;
		}
		console.log(id_check);
		console.log(pw_check);
		if(id_check==1 && pw_check==1){
			console.log('들어옴');
			$('#join_submit').submit();
		}
	});
	
});