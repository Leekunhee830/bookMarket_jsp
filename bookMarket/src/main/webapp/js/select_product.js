function order_view(user_num,product_num){
	if(user_num==""){
			alert('로그인을 해주세요.');
			return false;
	}else{		
			window.location.href ='/bookMarket/product/OrderProductView.pd?pd_num='+product_num+'&user_num='+user_num;
	}
}

function addCart(pd_num){
	$.ajax({
		url:'${pageContext.request.contextPath}/product/AddCart.ct',
		type:'post',
		data:{pd_num:pd_num},
		success:function(result){
			if(result==1){
				alert('장바구니에 등록 되었습니다.');
				location.reload();
			}else{
				alert('장바구니에 등록이 되지 않았습니다.');
			}
		},error:function(){
			alert("에러");
		}					
	});
}

