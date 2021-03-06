Kakao.init('a470205e2a6ed8679fe593b38a6d5cd2');
console.log(Kakao.isInitialized());
function kakaoLogin(){
	Kakao.Auth.login({
		
		success: function(authObj){
			Kakao.API.request({
				url:'/v2/user/me',
				success: function(res){
					var user_id=res.id;
					var user_name=res.properties.nickname;
					
					//db에 카카오 아이디 확인
					$.ajax({
						url:'${pageContext.request.contextPath}/login/KakaoIdCheck.do',
						type:'post',
						data:{user_id:user_id,user_name:user_name},
						success:function(result){
							if(result==1){
								alert(user_name+'님 환영합니다.');
								window.location.replace("/bookMarket/index.jsp");
							}else{
								//db에 카카오아이디 추가
								$.ajax({
									url:'${pageContext.request.contextPath}/login/KakaoLoginView.do',
									type:'post',
									data:{user_id:user_id,user_name:user_name},
									success:function(result){
										if(result==0){
											alert('에러1');
										}else{
											window.location.replace("/bookMarket/login/kakaoLoginView.jsp");
										}	
									},error:function(){
										alert("에러");
									}
								});	
							}
						}
					});	
				},
				fail: function(error){
					console.log(erroe)
				},
			})
		},
		fail: function(error){
			console.log(error)
		},
	})
}

function kakaoLogout(){
	if(Kakao.Auth.getAccessToken()){
		Kakao.API.request({
			url:'/v1/user/unlink',
			success:function(response){
				console.log(response)
			},
			fail:function(error){
				console.log(error)
			},
		})
		Kakao.Auth.setAccessToken(undefined)
	}
}