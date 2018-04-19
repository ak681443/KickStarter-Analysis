<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>KickStarter Analysis</title>

	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="static/css/bootstrap.min.css">
	
	<!-- Glyphicon CSS -->
	<link rel="stylesheet" href="static/css/glyph.css">
	
	<!-- suboptimal loading of js here to make loading cleaner - remove after async loading is done -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script> 
	<script src="https://cdnjs.cloudflare.com/ajax/libs/mustache.js/2.3.0/mustache.min.js" type="text/javascript"></script>
	<script src="static/js/util.js" type="text/javascript"></script>
	<script src="static/js/handlebars-v4.0.11.js" type="text/javascript"></script>
</head>
<body style='background-color:#fafafa;'>

<nav class="navbar navbar-expand-md navbar-light" style='border-bottom:1px solid #e1e1e1;' >
    <a class="navbar-brand" href="/index" style='font-weight:bold; color:#6e4cbb;'>KickStarter</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    	<span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
     	<ul class="navbar-nav mr-auto">
      		<li class="nav-item active">
        		<a class="nav-link" href="#">TalentSearch</a>
        	</li>
        	<li class="nav-item">
        		<a class="nav-link" href="#">LocationSearch</a>
        	</li>
        	<li class="nav-item">
        		<a class="nav-link" href="#">SignUp</a>
        	</li>
    	</ul>

    	<form class="form-inline my-2 my-lg-0">
        	<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        	<button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
    	</form>
    </div>
</nav>
