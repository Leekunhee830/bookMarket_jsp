$(document).ready(function(){
	
	$('#find_pw_btn').click(function(){
		var email_rule =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		var email=$('#user_email').val();
		var id=$('#user_id').val();
		
		if(!email_rule.test(email)){
			alert('이메일 형식에 맞게 입력해주세요.');
			return false;
		}
		
		if(email==null){
			alert('이메일을 입력해주세요.');
			return false;
		}
		
		if(id==null){
			alert('아이디를 입력해주세요.');
			return false;
		}
		
		$.ajax({
			url:'${pageContext.request.contextPath}/login/MemberFindPw.do',
			type:'post',
			data:{user_id:id,user_email:email},
			success:function(result){
				console.log(result);
				if(result==1){
					alert('이메일로 임시비밀번호가 전송되었습니다.');
					window.location.replace("/bookMarket/login/loginView.jsp");
				}else{
					alert('아이디 혹은 이메일을 다시 확인해주세요.');
				}
			},error:function(){
				alert('에러');
			}
		})
		
	});
	
});