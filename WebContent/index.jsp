<%@ include file="WEB-INF/templates/header.jsp" %>

<script id='proj_tpl' type="text/templates">
	{{#data}}
		<div class='col-md-3'>
			<div class='card' style="width: 16rem; height:18rem; margin: 1rem; z-index:100;">
 				<a href="#">
					<img class="card-img-top row-md-6" src="{{photo}}" style="width: 100%;  box-shadow:1px 4px 6px #eceff1;" alt="Card image cap">
					<p class='card-subtitle mt-1 ml-1 text-center' style='height:5vh;'>{{name}}</p>
					<div class="card-body row-md-4">
						<div class="progress" style="height: 15px; background-color: #e0e0e0">
  							<div class="progress-bar progress-bar-striped" role="progressbar" aria-valuenow="{{percentage}}" aria-valuemin="0" aria-valuemax="100" style="width:{{percentage}}%; background-color: #76ff03; color: #1a237e">
    							{{percentage}}% Funded
  							</div>
						</div>
					</div>
 				</a>
			</div>
		</div>
	{{/data}}
</script>

<script id='tab_head_tpl' type="text/templates">
	{{#data}}
		<li class='nav-item'><a class='nav-link sidebar_link' id='{{category_id}}' href="#main_category_{{category_id}}" onclick='loadTop5(this);' data-toggle="tab">{{name}}</a></li>
	{{/data}}
</script>

<script id='tab_content_tpl' type='text/templates'>
	<div class="tab-pane active" id="main_category_{{id}}">
   			<div class="row" style="padding:1%;">
   				<div class="col-md-6">
   					<h3>{{name}}</h3>
   					<img src="{{photo}}" style="width: 100%">
					<p>{{blurb}}</p>
					<button type="button" class="btn btn-outline-primary">Learn more</button>
   				</div>

   				<div class="col-md-6">
					{{#topfive}}
	   					<div class="row">
   							<div class="col-md-4">
   								<img src="{{photo}}" style="width: 100%">
 	  						</div>
   							<div class="col-md-8">
   								<a href="#">{{name}}</a>
   								<div class="progress" style="height: 15px; background-color: #e0e0e0">
  									<div class="progress-bar" role="progressbar" aria-valuenow="{{percentage}}" aria-valuemin="0" aria-valuemax="100" style="width:{{percentage}}%; background-color: #76ff03; color: #1a237e">
    									{{percentage}}%
									</div>
								</div>
   							</div>
   						</div>
   						<hr>
					{{/topfive}}
   				</div>
   			</div>
	   </div>
</script>

<script>
	cacheTemplates();
</script>

<!-- Top projects, launched most recently but have a good probability to success -->
<div class="container">
	<h4 class='glyph glyph-fire'>Top Projects</h4>
	<hr/>
	<div class="row" id='top_project' style='min-height:100vh;'>
		<!-- generated -->
	</div>
</div>

<hr>

<!-- View projects by main category, display top projects within this category -->
<div class="container" style='min-height:80vh;'>
	<h4 class='glyph glyph-filter'>View by Category</h4>
	<hr/>
	<div class='row'>
		<ul class="col-md-3 nav nav-pills nav-stacked" id='tab_head' style='height:30vh;'>
			<!-- generated -->
		</ul>
		
		<div class="col-md-9 tab-content" id='tab_content'>	
		</div>
	</div>
</div>

<%@ include file="WEB-INF/templates/footer.jsp" %>
<script src="static/js/index.js" type="text/javascript"> </script>