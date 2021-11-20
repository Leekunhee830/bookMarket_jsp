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
		prod_num:prod_num,
		review_contents:$('#review_contents').val()
	}
	
	console.log(data);
}