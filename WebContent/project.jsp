<%@ include file="WEB-INF/templates/header.jsp" %>

<script id='project_content_tpl' type='text/x-handlebars-template'>
	{{#this}}
		<div class='col-md-8'>
			<div class='card'>
				<img class='card-img-top' src="{{photo}}" />
				<div class='card-body'>
					<div class='container   p-0 m-0'>
						<div class='row'>
							<img class='col-md-2 rounded-circle' style='max-width:6vw; height:4vw;' src='{{j_owner.j_profilepic.url}}'/>
							<h5 class='col-md-3 pt-3 pl-0'>{{j_owner.name}}</h5>
							<div class='col-md-7'>
								sdasd
							</div>
						</div>
						<div class='row' id='similar-projects'>
								<!-- similar projects-->
						</div>
	<div class='col-md-6'>
								<!-- backers -->
							</div>
						<div class='row m-0 p-0'>
							<iframe class='m-0 p-0' src="/dbms_ks/moneymovement.jsp?pid={{project_id}}" height=400 width="100%" style='border:none;'/>
						</div>
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
		</div>
	{{/this}}
</script>

<script type="text/x-handlebars-template" id='similar-projects-tpl'>
	{{#this}}
		<div class='col-md-6'>
		<div class='card mb-3 mr-0'>
							<a href="project.jsp?p_id={{project_id}}">
							<div class="row mr-1 pr-2">
   								<div class="col-md-5">
   									<img class='card-img-left' src="{{photo}}" style="width: 100%; height: 100%;">
 	  							</div>
   								<div class="col-md-7 p-2">
									<div class='h5'>{{name}}</div>
									<div class="progress mt-2" style="height: 20px; background-color: #e0e0e0">
  										<div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="{{percentage}}" aria-valuemin="0" aria-valuemax="100" style="width:{{percentage}}%; background-color: #5ECE65; color: #1a237e">
											<span>{{percentage}}% Funded</span>
										</div>
									</div>
   								</div>
							</div>
							</a>
						</div>
</div>
	{{/this}}
</script>
<script>
	cacheTemplates();
</script>

<div class="container">
	<div class="row mt-5" id='project' style='min-height:100vh;'>
		<!-- generated -->
	</div>
</div>

<%@ include file="WEB-INF/templates/footer.jsp" %>
<script src="static/js/project.js" type="text/javascript"> </script>