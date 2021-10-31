function product_delete(pd_code,pd_img){
	
	$.ajax({
		url:'${pageContext.request.contextPath}/prodcut/ProductDelete.pd',
		type:'post',
		data:{pd_code:pd_code,pd_img:pd_img},
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