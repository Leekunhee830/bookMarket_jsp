$(document).ready(function(){
	
	$('#modify_button').click(function(){
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