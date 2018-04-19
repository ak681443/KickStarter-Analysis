function fetchTemplate(tplName, callback){
	$.get('js/templates/'+tplName, callback);
}

function cacheTemplates(){
	$('script[type="text/templates"]').each(function(_, template){
		Handlebars.compile($(template).html());
	});
}