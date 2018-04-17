//fetchTemplate('project_tile.tpl', function(template){
//	$.getJSON('api/recommend/projects', function(data){
//	    var rendered = Mustache.render(template, {'data':data});
//	    $('#top_project').html(rendered);
//		console.log(data);
//	});
//});
$.getJSON('api/recommend/projects', function(data) {
	var template = $('#proj_tpl').html();
	var rendered = Mustache.render(template, {'data': data});
    $('#top_project').html(rendered);
});

$.getJSON('api/recommend/categories', function(data) {
	var template = $('#tab_head_tpl').html();
	var rendered = Mustache.render(template, {'data': data});
    $('#tab_head').html(rendered);
    $($('.sidebar_link')[0]).click();
});

function loadTop5(thisR){
	$.getJSON('api/recommend/category/' + thisR.id + '/topfive', function(data) {
		var template = $('#tab_content_tpl').html();
		var rendered = Mustache.render(template,  data);
		$('#tab_content').html(rendered);
	});
	return true;
}