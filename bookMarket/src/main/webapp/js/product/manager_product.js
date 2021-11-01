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