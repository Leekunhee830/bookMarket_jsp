function product_delete(pd_num,pd_img){
	
	$.ajax({
		url:'${pageContext.request.contextPath}/product/ProductDelete.pd',
		type:'post',
		data:{pd_num:pd_num,pd_img:pd_img},
		success:function(result){
			if(result==1){
				alert('상품삭제가 완료되었습니다.');
				location.reload();
			}else{
				alert('상품삭제가 완료되지 않았습니다. ')
			}
		},error:function(){
			alert("에러");
		}					
	});	
}

function product_modifyView(pd_num){
	location.href = 'ModifyProductView.pd?pd_num='+pd_num;
}

function product_Check(){
	var pd_code=$('#pd_code').val();
	var pd_name=$('#pd_name').val();
	var pd_contents=$('#pd_contents').val();
	var pd_price=$('#pd_price').val();
	var pd_amount=$('#pd_amount').val();
	var pd_category=$('#pd_category').val();
	var pd_manufacturer=$('#pd_manufacturer').val();
	
	
	if(pd_code==""){
		alert('상품 코드를 입력해주세요.');
		return false;
	}
	else if(pd_name==""){
		alert('상품 이름를 입력해주세요.');
		return false;
	}
	else if(pd_contents==""){
		alert('상품 설명을 입력해주세요.');
		return false;
	}
	else if(pd_price==""){
		alert('상품 가격을 입력해주세요.');
		return false;
	}
	else if(pd_amount==""){
		alert('상품 수량을 입력해주세요.');
		return false;
	}
	else if(pd_category==""){
		alert('상품 분류를 선택해주세요.');
		return false;
	}
	else if(pd_manufacturer==""){
		alert('상품 출판사를 입력해주세요.');
		return false;
	}
	else{
		$('#modifyPd_submit').submit();
	}
	
	
	
	
}