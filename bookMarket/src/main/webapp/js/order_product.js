$(document).ready(function(){
	
	var order_count=$('#order_count').text();
	var order_price=$('#order_price').text();
	
	$('#count_plus').click(function(){
		var total_price=0;
		order_count++;
		total_price=order_count*order_price;
		
		$('#order_price').text(comma(total_price));
		$('#order_count').text(order_count);
	});
	
	$('#count_minus').click(function(){
		var total_price=0;
		
		if(order_count>1){
			order_count--;	
			total_price=order_count*order_price;		
			$('#order_price').text(comma(total_price));
		}
		
		$('#order_count').text(order_count);
	});
	
	
});

function comma(num){
	var len,point,str;
		
	num=num+"";
	point=num.length%3;
	len=num.length;
		
	str=num.substring(0,point);
	while(point<len){
		if(str!="") str+=",";
		str+=num.substring(point,point+3);
		point+=3;
	}
	return str;
}