function fetchTemplate(tplName, callback){
	$.get('js/templates/'+tplName, callback);
}

function cacheTemplates(){
	$('script[type="text/templates"]').each(function(_, template){
		Mustache.parse($(template).html());
	});
}