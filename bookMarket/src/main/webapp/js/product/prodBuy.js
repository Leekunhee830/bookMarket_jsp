
function order_check(user_id,user_name,user_email,user_phone,AllPrice){
	var order_zipcode=$('#order_zipcode').val();
	var order_address=$('#order_address').val();
	var order_detail_address=$('#order_detail_address').val();	
	
	if(order_zipcode==""){
		alert('주소를 입력해주세요.');
		return false;
	}
	if(order_detail_address==""){
		alert('상세주소를 입력해주세요.');
		return false;
	}
	
	request_to_check(user_id,AllPrice,user_email,user_name,user_phone,order_zipcode+""+order_address+""+order_detail_address)
}


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