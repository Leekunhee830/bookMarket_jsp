$(document).ready(function(){
	
	$('#order_btn').click(function(){
		var user_id=$('#user_id').val();
		var product_num=$('#product_num').val();
		
		if(user_id==""){
			alert('로그인을 해주세요.');
			return false;
		}else{		
			window.location.href = 'order_productView.jsp?product_num='+product_num;
		}
	});
});