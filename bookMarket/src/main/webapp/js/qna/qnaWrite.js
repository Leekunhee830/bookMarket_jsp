$(document).ready(function() {
	$('#qna_contents').summernote({
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
		option_num:$('#qna_option').val(),
		contents:$('#qna_contents').val(),
		qna_password:$('#qna_password').val()
	};
	
	$.ajax({
		type:"POST",
		url:"/bookMarket/qna/qnaWrite.qna",
		data:JSON.stringify(data),
		contentType:"application/json; charset=utf-8",
		dataType:"text"
	}).done(function(result){
		if(result==1){
			alert('Q&A가 등록되었습니다.');
			location.href = document.referrer;
		}else{
			alert('Q&A 등록 중 오류가 발생하였습니다.');
			location.href = document.referrer;
		}
	});
	
}

function qna_delete(qna_num){
	$.ajax({
		type:"GET",
		url:"/bookMarket/qna/qnaDelete.qna?qna_num="+qna_num
	}).done(function(result){
		if(result==1){
			alert('해당 문의가 삭제되었습니다.');
			location.href = '/bookMarket/index.jsp';
		}else{
			alert('해당 문의 삭제 중 오류가 발생하였습니다.');
			location.href = document.referrer;
		}
	});
}

