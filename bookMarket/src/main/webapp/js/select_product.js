$(document).ready(function(){
	
	$('#order_btn').click(function(){
		var user_id=$('#user_id').val();
		var pd_num=$('#product_num').val();
		var pd_imgName=$('#product_imgName').val();
		var pd_name=$('#product_name').val();
		var pd_price=$('#product_price').val();
		console.log(pd_name);
		
		if(user_id==""){
			alert('로그인을 해주세요.');
			return false;
		}else{		
			window.location.href = 'order_productView.jsp?pd_num='+pd_num+'&pd_imgName='+pd_imgName+'&pd_name='+pd_name+'&pd_price='+pd_price;
		}
	});
});

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
				alert('장바구니에 등록이 되지 않았습니다.')
			}
		},error:function(){
			alert("에러");
		}					
	});
}