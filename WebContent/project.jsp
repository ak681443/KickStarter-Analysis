<%@ include file="WEB-INF/templates/header.jsp" %>

<script id='project_content_tpl' type='text/x-handlebars-template'>
	{{#this}}
		<div class='col-md-8'>
			<div class='card'>
				<img class='card-img-top' src="{{photo}}" />
				<div class='card-body'>
					<div class='row'>
						// owner info, category, location
					</div>
					<div class='row'>
						<div class='col-md-6'>
							// similar projects
						</div>
						<div class='col-md-6'>
							// backers
						</div>
					</div>

					<div class='row'>
						<iframe class='m-3' src="/dbms_ks/moneymovement.jsp?pid={{project_id}}" height=400 width="100%" style='border:none;'/>
					</div>
				</div>
			</div>
		</div>
		
		<div class='col-md-4'>
			<h3 class='card-title mt-3'>{{name}}</h3>
			<p class='card-sub-title'>{{blurb}}</p>
			<div class="progress mt-2" style="height: 20px; background-color: #e0e0e0">
  				<div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="{{percentage}}" aria-valuemin="0" aria-valuemax="100" style="width:{{percentage}}%; background-color: #5ECE65; color: #1a237e">
					<span>{{percentage}}% Funded</span>
				</div>
			</div>
			<p> pledge info </p>
			<h2 class='card-title mt-3'>Owner Information</h2>
			
		</div>
	{{/this}}
</script>

<script id='project_creator_tpl' type='text/x-handlebars-template'>
{{data}}
<p>
		{{data/name}}
</p>
{{/data}}
</script>

<script>
	cacheTemplates();
</script>

<div id='owner_data'>
				
			</div>

<div class="container-fluid">
	<div class="row mt-5" id='project' style='min-height:100vh;'>
		<!-- generated -->
	</div>
</div>

<%@ include file="WEB-INF/templates/footer.jsp" %>
<script src="static/js/project.js" type="text/javascript"> </script>