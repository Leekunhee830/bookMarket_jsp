function delete_cart(user_num,pd_num){
	$.ajax({
		type:'POST',
		url:'/bookMarket/cart/DeleteCart.ct',
		data:{user_num:user_num,pd_num:pd_num},
	})
	.done(function(result){
		if(result==1){
			alert('장바구니에서 삭제되었습니다.');
			location.reload();
		}else{
			alert('오류');
		}
	});
}