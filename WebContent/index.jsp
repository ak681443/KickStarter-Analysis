<%@ include file="WEB-INF/templates/header.jsp" %>

<!-- Welcome statement, can also display some statistical data -->
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Welcome to KickStarter projects gallery!</h1>
		<p>Projects have a life of their own. You make something, but it'll tell you what it is.</p>
	</div>
</div>

<!-- Top projects, lauched most recently but have a good probability to success -->
<div class="container">
	<h2>Top Projects</h2>

	<div class="row">
		<div class="col-md-3">
			<a href="#">
				<img src="https://ksr-ugc.imgix.net/assets/020/238/637/ef3ddd2779577b0652f19b36deedb5df_original.jpg?crop=faces&w=352&h=198&fit=crop&v=1519861769&auto=format&q=92&s=f40c51f5401a0ad419c7f291e5d31485" style="width: 100%">
				<p>There's a word for girls like you... International ensemble brings this unique, sell-out show to London.</p>
			</a>
		</div>
		<div class="col-md-3">
			<a href="#">
				<img src="https://ksr-ugc.imgix.net/assets/020/238/637/ef3ddd2779577b0652f19b36deedb5df_original.jpg?crop=faces&w=352&h=198&fit=crop&v=1519861769&auto=format&q=92&s=f40c51f5401a0ad419c7f291e5d31485" style="width: 100%">
				<p>There's a word for girls like you... International ensemble brings this unique, sell-out show to London.</p>
			</a>
		</div>
		<div class="col-md-3">
			<a href="#">
				<img src="https://ksr-ugc.imgix.net/assets/020/238/637/ef3ddd2779577b0652f19b36deedb5df_original.jpg?crop=faces&w=352&h=198&fit=crop&v=1519861769&auto=format&q=92&s=f40c51f5401a0ad419c7f291e5d31485" style="width: 100%">
				<p>There's a word for girls like you... International ensemble brings this unique, sell-out show to London.</p>
			</a>
		</div>
		<div class="col-md-3">
			<a href="#">
				<img src="https://ksr-ugc.imgix.net/assets/020/238/637/ef3ddd2779577b0652f19b36deedb5df_original.jpg?crop=faces&w=352&h=198&fit=crop&v=1519861769&auto=format&q=92&s=f40c51f5401a0ad419c7f291e5d31485" style="width: 100%">
				<p>There's a word for girls like you... International ensemble brings this unique, sell-out show to London.</p>
			</a>
		</div>
		
		
	</div>
</div>

<hr>

<!-- View projects by main category, display top projects within this category -->
<div class="container">
	<h2>View by Category</h2>

	<ul class="nav nav-tabs">
	   <li><a href="#a" data-toggle="tab">a</a></li>
	   <li><a href="#b" data-toggle="tab">b</a></li>
	   <li><a href="#c" data-toggle="tab">c</a></li>
	   <li><a href="#d" data-toggle="tab">d</a></li>
	</ul>

	<div class="tab-content">
	   <div class="tab-pane active" id="a">
	   		<h3>Top Projects from Category</h3>
	   		
   			<div class="row">
   				<div class="col-md-6">
   					<img src="https://ksr-ugc.imgix.net/assets/020/238/637/ef3ddd2779577b0652f19b36deedb5df_original.jpg?crop=faces&w=352&h=198&fit=crop&v=1519861769&auto=format&q=92&s=f40c51f5401a0ad419c7f291e5d31485" style="width: 100%">
					<p>There's a word for girls like you... International ensemble brings this unique, sell-out show to London.</p>
					<button type="button" class="btn btn-outline-primary">Learn more</button>
   				</div>
   				<div class="col-md-6">
   					<div class="row">
   						<div class="col-md-4">
   							<img src="https://ksr-ugc.imgix.net/assets/020/238/637/ef3ddd2779577b0652f19b36deedb5df_original.jpg?crop=faces&w=352&h=198&fit=crop&v=1519861769&auto=format&q=92&s=f40c51f5401a0ad419c7f291e5d31485" style="width: 100%">
   						</div>
   						<div class="col-md-8">
   							<a href="#">Sample project</a>
   							<p>88% funded</p>
   						</div>
   					</div>

   					<hr>

   					<div class="row">
   						<div class="col-md-4">
   							<img src="https://ksr-ugc.imgix.net/assets/020/238/637/ef3ddd2779577b0652f19b36deedb5df_original.jpg?crop=faces&w=352&h=198&fit=crop&v=1519861769&auto=format&q=92&s=f40c51f5401a0ad419c7f291e5d31485" style="width: 100%">
   						</div>
   						<div class="col-md-8">
   							<a href="#">Sample project</a>
   							<p>88% funded</p>
   						</div>
   					</div>

   					<hr>

   					<div class="row">
   						<div class="col-md-4">
   							<img src="https://ksr-ugc.imgix.net/assets/020/238/637/ef3ddd2779577b0652f19b36deedb5df_original.jpg?crop=faces&w=352&h=198&fit=crop&v=1519861769&auto=format&q=92&s=f40c51f5401a0ad419c7f291e5d31485" style="width: 100%">
   						</div>
   						<div class="col-md-8">
   							<a href="#">Sample project</a>
   							<p>88% funded</p>
   						</div>
   					</div>

   					<hr>

   					<div class="row">
   						<div class="col-md-4">
   							<img src="https://ksr-ugc.imgix.net/assets/020/238/637/ef3ddd2779577b0652f19b36deedb5df_original.jpg?crop=faces&w=352&h=198&fit=crop&v=1519861769&auto=format&q=92&s=f40c51f5401a0ad419c7f291e5d31485" style="width: 100%">
   						</div>
   						<div class="col-md-8">
   							<a href="#">Sample project</a>
   							<p>88% funded</p>
   						</div>
   					</div>
   				</div>
   			</div>
	   		
	   </div>
	   <div class="tab-pane" id="b">BBB</div>
	   <div class="tab-pane" id="c">CCC</div>
	   <div class="tab-pane" id="d">DDD</div>
	</div>
</div>


<%@ include file="WEB-INF/templates/footer.jsp" %>
