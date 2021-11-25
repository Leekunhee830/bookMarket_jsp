$(document).ready(function() {
	$('#review_contents').summernote({
		  height: 300,                 // 에디터 높이
		  lang: "ko-KR",			   // 한글 설정
		  toolbar: [
    ['style', ['bold', 'italic', 'underline', 'clear']],
    ['font', ['strikethrough', 'superscript', 'subscript']],
    ['fontsize', ['fontsize']],
    ['color', ['color']],
    ['para', ['ul', 'ol', 'paragraph']],
    ['height', ['height']]
    ]     
	});
});

function upload(user_num,prod_num){
	var data={
		user_num:user_num,
		product_num:prod_num,
		contents:$('#review_contents').val()
	}
	
	
	$.ajax({
		type:"POST",
		url:"/bookMarket/review/reviewWrite.rv",
		data:JSON.stringify(data),
		contentType:"application/json; charset=utf-8",
		dataType:"text"
	}).done(function(result){
		if(result==1){
			alert('리뷰가 등록되었습니다.');
			location.href = document.referrer;
		}else{
			alert('리뷰 등록 중 오류가 발생하였습니다.');
			location.href = document.referrer;
		}
	})
	
}

function review_delete(review_num){
	$.ajax({
		type:"GET",
		url:"/bookMarket/review/reviewDelete.rv?review_num="+review_num
	}).done(function(result){
		if(result==1){
			alert('해당 리뷰가 삭제되었습니다.');
			location.href = document.referrer;
		}else{
			alert('리뷰 삭제 중 오류가 발생하였습니다.');
			location.href = document.referrer;
		}
	})
}