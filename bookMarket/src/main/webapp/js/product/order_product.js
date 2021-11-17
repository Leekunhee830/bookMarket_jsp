$(document).ready(function(){

	var order_count=$('#order_count').text();
	var order_price=$('#order_price').text();
	
	
	
	$('#count_plus').click(function(){
		var total_price=0;
		order_count++;
		total_price=order_count*order_price;
		
		
		$('#order_count').text(order_count);
	});
	
	$('#count_minus').click(function(){
		var total_price=0;
		
		if(order_count>1){
			order_count--;	
			total_price=order_count*order_price;		
			
		}
		
		$('#order_count').text(order_count);
	});
	
	$('#order_btn').click(function(){
		var phone_rule = /^\d{3}-\d{3,4}-\d{4}$/;
		var home_phone_rule=/^\d{2,3}-\d{3,4}-\d{4}$/;
		var order_name=$('#order_name').val();
		var order_zipcode=$('#order_zipcode').val();
		var order_detail_address=$('#order_detail_address').val();
		var order_phone=$('#order_phone1').val()+"-"+$('#order_phone2').val()+"-"+$('#order_phone3').val();
		var order_home_phone=$('#order_home_phone1').val()+"-"+$('#order_home_phone2').val()+"-"+$('#order_home_phone3').val();
		var user_id=$('#user_id').val();
		var user_email=$('#user_email').val();
		
		if(order_name==""){
			alert('받으시는 분의 성함을 입력해주세요.');
			return false;
		}
		if(order_zipcode==""){
			alert('주소를 입력해주세요.');
			return false;
		}
		if(order_detail_address==""){
			alert('상세주소를 입력해주세요.');
			return false;
		}
		if(!phone_rule.test(order_phone)){
			alert('전화번호를 다시 확인해주세요');
			return false;
		}
		if(!home_phone_rule.test(order_home_phone)){
			alert('유선전화번호를 다시 확인해주세요.');
			return false;
		}
		
		$('input[name=order_amount]').attr('value',order_count);
		$('input[name=order_price]').attr('value',order_price*order_count);
		
		request_to_check(user_id,order_price*order_count,user_email,order_name,order_phone,order_zipcode+""+order_detail_address);
		
	});
	
	
});


function request_to_check(user_id,allPrice,email,name,phone,address){
	var IMP=window.IMP;
	IMP.init('imp21199080');
	
	IMP.request_pay({
		pg:'inicis',
		pay_method:'card',
		merchant_uid:user_id+'_'+new Date().getTime(),
		name:'주문명:결제테스트',
		amount:allPrice,
		buyer_email:email,
		buyer_name:name,
		buyer_tel:phone,
		buyer_addr:address
	},function(rsp){
		if(rsp.success){
			alert("결제 완료되었습니다.");
			window.location.href ='/bookMarket/index.jsp';
		}else{
			alert("결제 실패하였습니다.");
		}
	})
};