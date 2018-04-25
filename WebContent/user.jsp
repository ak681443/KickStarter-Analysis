<%@ include file="WEB-INF/templates/header.jsp" %>

<script id='userCreator_content_tpl' type='text/x-handlebars-template'>
	{{#this}}
		<div class='col-md-3'>
				<h3>{{user_id}}</h3>
				<div class='card-body'>
					<div class='row'>
						// owner info, category, location
					</div>
					
				</div>
		
		</div>
		
	{{/this}}
</script>




<div class="container-fluid">
	<div class="row mt-5" id='userCreator' style='min-height:100vh;'>
		<!-- generated -->
	</div>
</div>

<%@ include file="WEB-INF/templates/footer.jsp" %>
<script src="static/js/user.js" type="text/javascript"> </script>