<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<head>
<meta charset="UTF-8">
<title>Main Page</title>
</head>

<header style= "border:solid; background-color:grey">
<h1 style=" text-align:center">Main page</h1>
<nav class="navbar fixed-top navbar-light bg-light">

<div class="headerNav" style="padding-left:30px">
 <button type="button" class="btn btn-default" aria-label="Left Align">
 <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
 </button>
  <button type="button" class="btn btn-default" aria-label="Left Align">
  <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
 </button>
 <button type="button" class="btn btn-default" aria-label="Left Align">
  <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
 </button>
 <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"><button class="btn btn-outline-success my-2 my-sm-0"  type="submit" >Search</button>
 </div>
 <div class="headerNavB">
      
      
  </div>
 </nav>
 </header>
 

 <body style="backgroud-color:grey">
 <div class= "menu" style="padding:1%;width: 40%; height: 100%;color: #999; display: block;float: left;width: 246px; border-top: 3px solid #373737;border-right: 1px solid #1A1A1A;">
 <br><br><ul class="nav nav-pills nav-stacked" >
  <li class="nav-item" style="list-style:none; border:solid; height:30px; width:120px; padding:10%;background-color:grey">
    <a class="nav-link active" href="#"><font color="white"; >Sucess Predition</font></a>
  </li>
  <li class="nav-item" style="list-style:none; border:solid; height:30px; width:120px; padding:10%;background-color:grey">
    <a class="nav-link" href="#"><font color="white">Search Talent</font></a>
  </li>
  <li class="nav-item" style="list-style:none; border:solid; height:30px; width:120px; padding:10%;background-color:grey">
    <a class="nav-link" href="#"><font color="white">Money Movement</font></a>
  </li>
  <li class="nav-item" style="list-style:none; border:solid; height:30px; width:120px; padding:10%;background-color:grey;font-align: center">
    <a class="nav-link disabled" href="#"><font color="white">Location</font></a>
  </li>
</ul>
</div><script async defer src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&amp;callback=initMap">
    </script><script>
      function initMap() {
        var uluru = {lat: -25.363, lng: 131.044};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 4,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script><div id="map" style="width: 840px; "></div>
    

</body>
</html>