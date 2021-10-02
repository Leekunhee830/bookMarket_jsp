$(document).ready(function() {
	
	var id_check=0;
	var pw_check=0;
	var email1 = $('#user_email1').val();
	var email2 =$('#user_email2').val();
	var email=email1+"@"+email2;
	
	
	
	$('#user_password1 , #user_password2').blur(function(){
		var password1=$("#user_password1").val();
		var password2=$("#user_password2").val();
		var password_rule = /^[A-Za-z0-9]{6,12}$/;

		
		if(password1!="" && password2!=""){
			
			if(password1!=password2){
				$('#password_check').text('두 비밀번호가 일치하지 않습니다.');
				$("#password_check").css("color", "red");
				pw_check=0;
			}
			else if(!password_rule.test(password1)){
				$('#password_check').text('숫자와 문자포함 6~12자리 이내로 입력해주세요.');
				$("#password_check").css("color", "red");
				pw_check=0;
			}
		    else if(password1==password2){
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
	
	$('#id_check_btn').click(function(){
		user_id=$('#user_id').val();
		
		for(var i=0;i<user_id.length;i++){
			ch=user_id.charAt(i);
			if(!(ch>='0' && ch<='9') && !(ch>='a' && ch<='z') && !(ch>='A' && ch<='Z')){
				$('#id_check').text('아이디는 영문 대소문자, 숫자만 입력가능합니다.');
				$("#id_check").css("color", "red");
				id_check=0;
				return false;
			}
		}
		
		if (user_id.length<4 || user_id.length>12) {
			$('#id_check').text('아이디를 4~12자까지 입력해주세요.');
			$("#id_check").css("color", "red");
			id_check=0;
			return false;
        }
		
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
	
	
	$("#join_button").click(function(){
		var email_rule =  /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var phone_rule = /^\d{3}-\d{3,4}-\d{4}$/;

		var phone=$('#user_phone1').val()+"-"+$('#user_phone2').val()+"-"+$('#user_phone3').val();
		if($('#user_name').val()==""){
			alert('이름을 입력해주세요');
			return false;
		}
		
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
		
		if(id_check==0){
			alert('아이디 중복체크를 해주세요.');
			return false;
		}
		if(pw_check==0){
			alert('비밀번호를 확인해주세요.');
			return false;
		}
		
		if(id_check==1 && pw_check==1){
			$('#join_submit').submit();
		}
		
	});	
});

$(document).on('click','#send_email_btn',function(){
		alert('dd');
   		$.ajax({
			url:'${pageContext.request.contextPath}/join/emailCheck.do',
			type:'post',
			data:{user_email:email},
			success:function(result){
				if(result==1){
					alert("인증번호가 발송되었습니다.")
				}else{
					alert("오류");
				}
			},error:function(){
				alert("에러");
			}
		});	
});