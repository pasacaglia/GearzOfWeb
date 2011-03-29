$(document).ready(function() {
	//register edit button
	var currentDiv;
	$('#div1_editbutton_id').click(function(){
		$('#contentDialog').dialog();
		currentDiv = '#template1_div1';
	});
	//post on click of dialog button
	$('#dialogbutton').click(function(){
		var content = $('#contentTextId').val();
		$.ajax({
			  type: 'POST',
			  url: '/WebGearz/storeDivContent',
			  data: {'domainId':domainId,'divId':currentDiv,'content':content},
			  success: function(data){doSomething(data,content,currentDiv);},
			  dataType: 'json'
			});
	});
});

var doSomething = function(data,content,currentDiv){
	
	$('#contentDialog').dialog('close');
	if(data.success==true){
		$(currentDiv).html(content);
	}
	
}