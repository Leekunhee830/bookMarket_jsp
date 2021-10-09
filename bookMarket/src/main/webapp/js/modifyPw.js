$(document).ready(function(){
	$('#modify_button').click(function(){
		window.location.href = "passwordCheck.jsp";
	});
	
	$('#checkPw_btn').click(function(){
		console.log("들어옴");
		var user_password= $('#user_password').val();
		var user_id=$('#user_id').val();
		console.log(user_password);
		
		$.ajax({
			url:'${pageContext.request.contextPath}/login/PwCheck.do',
			type:'post',
			data:{user_id:user_id,user_password:user_password},
			success:function(result){
				console.log(result);
				if(result==1){
					window.location.replace("modifyPwView.jsp");
				}else{
					alert('비밀번호를 다시 확인해주세요.');
				}
			},error:function(){
				alert('에러');
			}
		})
	});
	
	
	$('#modify_button2').click(function(){
		var user_password=$('#user_password').val();
		var password_rule = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
		
		if(!password_rule.test(user_password)){
			alert('숫자와 문자,특수 문자포함 8자리 이상으로 입력해주세요.');
			return false;
		}else{
			$('#modify_submit').submit();
		}
		
	});
});
