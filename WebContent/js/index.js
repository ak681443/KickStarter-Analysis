//fetchTemplate('project_tile.tpl', function(template){
//	$.getJSON('api/recommend/projects', function(data){
//	    var rendered = Mustache.render(template, {'data':data});
//	    $('#top_project').html(rendered);
//		console.log(data);
//	});
//});

$.getJSON('api/recommend/projects', function(data){
	var template = $('#proj_tpl').html();
	var rendered = Mustache.render(template, {'data': data});
    $('#top_project').html(rendered);
});
