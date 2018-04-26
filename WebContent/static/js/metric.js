var rankBys = ['money_pledged_percentage'];
var tableIds = ['show_rank'];

$.getJSON('api/metric/rank/money_pledged_percentage', function(data) {
	var text = $('#metric').html();
	var template = Handlebars.compile(text);
	var rendered = template({'data': data});
    $('#show_rank').html(rendered);
});

$.getJSON('api/metric/rank/money_pledged_ca', function(data) {
	var text = $('#metric1').html();
	var template = Handlebars.compile(text);
	var rendered = template({'data': data});
    $('#show_rank1').html(rendered);
});

$.getJSON('api/metric/rank/backer_us_art', function(data) {
	var text = $('#metric2').html();
	var template = Handlebars.compile(text);
	var rendered = template({'data': data});
    $('#show_rank2').html(rendered);
});

$.getJSON('api/metric/rank/backer_country_art', function(data) {
	var text = $('#metric3').html();
	var template = Handlebars.compile(text);
	var rendered = template({'data': data});
    $('#show_rank3').html(rendered);
});

$.getJSON('api/metric/rank/creator_country_art', function(data) {
	var text = $('#metric4').html();
	var template = Handlebars.compile(text);
	var rendered = template({'data': data});
    $('#show_rank4').html(rendered);
});

$.getJSON('api/metric/rank/sum_money_us_category', function(data) {
	var text = $('#metric5').html();
	var template = Handlebars.compile(text);
	var rendered = template({'data': data});
    $('#show_rank5').html(rendered);
});