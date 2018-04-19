var urlParams = new URLSearchParams(window.location.search);
projectId = urlParams.get('p_id');
/*
$.getJSON('api/recommend/categories', function(data) {
	var text = $('#tab_head_tpl').html();
	var template = Handlebars.compile(text);
	var rendered = template({'data': data});
    $('#tab_head').html(rendered);
    $($('.sidebar_link')[0]).click();
});

function loadTop5(thisR){
	$.getJSON('api/recommend/category/' + thisR.id + '/topfive', function(data) {
		var text = $('#tab_content_tpl').html();
		var template = Handlebars.compile(text);
		var rendered = template(data);
		$('#tab_content').html(rendered);
	});
	return true;
}

*/
Handlebars.registerHelper('pp', function (text) {
	  num = Number.parseInt(text)
	  return num > 999 ? (num/1000).toFixed(1) + 'k' : num
});

Handlebars.registerHelper('percentage', function () {
	return Number.parseInt((Number.parseInt(this.money_pledged)/ Number.parseFloat(this.goal)));
});


$.getJSON('api/project/' + projectId , function(data) {
	var text = $('#project_content_tpl').html();
	var template = Handlebars.compile(text);
	var rendered = template(data);
    $('#project').html(rendered);
});