Kakao.init('a470205e2a6ed8679fe593b38a6d5cd2');
console.log(Kakao.isInitialized());
function kakaoLogin(){
	Kakao.Auth.login({
	success: function(response){
			Kakao.API.request({
				url:'/v2/user/me',
				success: function(response){
					console.log(response)
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