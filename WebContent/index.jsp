<%@page import="org.dbms.ks.util.DBUtil"%>
<%@page import="org.dbms.ks.util.DBUtil.DBConnection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.HashSet"%>
<% DBConnection con = DBUtil.getConnection(); %>

<%@ include file="WEB-INF/templates/header.jsp" %>

<!-- Welcome statement, can also display some statistical data -->
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>Welcome to KickStarter projects gallery!</h1>
		<p>Projects have a life of their own. You make something, but it'll tell you what it is.</p>
	</div>
</div>

<script id='proj_tpl' type="text/templates">
{{#data}}
<div class='col-md-4'>
	<div class='card'>
 		<a href="#">
			<div class="card-body">
				<img class="card-img-top" src="{{photo}}" style="width: 100%" alt="Card image cap">
				<p class='card-text'>{{name}}</p>
  			</div>
 		</a>
	</div>
</div>
{{/data}}
</script>

<!-- Top projects, launched most recently but have a good probability to success -->
<div class="container">
	<h2>Top Projects</h2>

	<div class="row" id='top_project'>
		<!-- generated -->
	</div>
</div>

<hr>

<!-- View projects by main category, display top projects within this category -->
<div class="container">
	<h2>View by Category</h2>

	<ul class="nav nav-tabs">
	<%
	ResultSet rs;
	rs = con.prepareQuery("view.by_maincategory").executeQuery();
	
	// main categories that contain projects
	int[] categories = new int[] {1,3,6,7,10,11,12,13,14,15};
	HashSet<Integer> cateSet = new HashSet<Integer>();
	for (int id : categories) cateSet.add(id);
	
	while (rs.next()) {
		int id = rs.getInt("category_id");
		if (cateSet.contains(id)) {
	%>
	   	   <li class='nav-item'><a class='nav-link' href="#main_category<%= id %>" data-toggle="tab"><%= rs.getString("name") %></a></li>
	    <% } %>
	<% } %>
	</ul>

	<div class="tab-content">
	<%
	for (int id : categories) {
		rs = con.prepareQuery("recommend.proj_maincategory").setQueryParam(1, id).executeQuery();
		rs.next();

		// set ART to be active
		String activeLabel = "";
		if (id == 1) activeLabel = " active";;
	%>
	   	<div class="tab-pane<%= activeLabel %>" id="main_category<%= id %>">
   			<div class="row" style="padding:1%;">
   				<div class="col-md-6">
   					<h3><%= rs.getString("name") %></h3>
   					<img src=<%= rs.getString("photo") %> style="width: 100%">
					<p><%= rs.getString("blurb") %></p>
					<button type="button" class="btn btn-outline-primary">Learn more</button>
   				</div>

   				<div class="col-md-6">
   				<% for (int i = 0; i < 4 && rs.next(); i++) { %>
   					<div class="row">
   						<div class="col-md-4">
   							<img src=<%= rs.getString("photo") %> style="width: 100%">
   						</div>
   						<div class="col-md-8">
   							<a href="#"><%= rs.getString("name") %></a>
   							<p>88% funded</p>
   						</div>
   					</div>
   					<% if (i != 3) { %>
   					<hr>
   					<% } %>
   				<% } %>	
   				</div>
   			</div>
	   </div>
	<% } %>
	</div>
</div>

<%@ include file="WEB-INF/templates/footer.jsp" %>
<script src="js/index.js" type="text/javascript"> </script>
<!--

//-->
</script>
<% con.safeClose(); %>
