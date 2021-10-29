$(document).ready(function() {
	
	var email_check=0;
	var email_check_num;

	//$(document).on('click','#send_email_btn',function(){
	//이메일 인증번호 전송
	$('#send_email_btn_k').click(function(){	
		var email1=$('#user_email1').val();
		var email2 =$('#user_email2').val();
		var email=email1+"@"+email2;
   		$.ajax({
			url:'${pageContext.request.contextPath}/join/emailCheck.do',
			type:'post',
			data:{user_email:email},
			success:function(result){
				if(result==0){
					alert('에러');
				}else{
					alert("인증번호가 발송되었습니다.");
					email_check_num=result;
				}
				
			},error:function(){
				alert("에러");
			}
		});	
	});
	
	//인증번호 체크
	$('#send_email_check_k').click(function(){
		var num=$('#user_email_checkNum').val();
		
		if(num==email_check_num){
			$('#email_check').text('인증이 완료되었습니다.');
			$('#email_check').css("color","green");
			email_check=1;
		}
		else{
			$('#email_check').text('인증번호가 올바르지 않습니다.');
			$('#email_check').css("color","red");
		}
	});
	

	
	$("#join_button_k").click(function(){
		var email_rule =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var phone_rule = /^\d{3}-\d{3,4}-\d{4}$/;
		var email1=$('#user_email1').val();
		var email2 =$('#user_email2').val();
		var email=email1+"@"+email2;
		var phone=$('#user_phone1').val()+"-"+$('#user_phone2').val()+"-"+$('#user_phone3').val();
		
		
		if($('#user_phone2,#user_phone3').val()==""){
			alert('전화번호를 입력해주세요.');
			return false;
		}
		
		if(!phone_rule.test(phone)){
			alert('전화번호를 잘못 입력하셨습니다.');
			return false;
		}
		
		if($('#user_email1').val()==""){
			alert('이메일을 입력해주세요.');
			return false;
		}
		
		if(!email_rule.test(email)){
			alert('이메일을 형식에 맞게 입력해주세요.');
			return false;
		}
		
		
		if(email_check==0){
			alert('이메일 인증을 해주세요.');
		}
		
		if(email_check==1){
			$('#join_submit').submit();
		}
		
	});	
	
	
});

