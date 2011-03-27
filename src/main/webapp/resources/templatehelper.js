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
			  url: url,
			  data: {'domainId':domainId,'divId':currentDiv,'content':content},
			  success: function(data){doSomething(data);},
			  dataType: 'json'
			});
	});
});

var doSomething = function(data){
	$(currentDiv).html(data.content);
}