<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="static/css/bootstrap.min.css">
    <meta charset="utf-8">
    <style type="text/css">
        body {
            color: #5d5d5d;
            font-family: Helvetica, Arial, sans-serif;
			overflow: hidden;
        }

        h1 {
            font-size: 30px;
            margin: 0px;
            width: 100vw;
            text-align: center;
            margin-top: 0px;
        }

        .container {
        	width: 100vw;
        	height: 100vh;
            margin: 0px;
        	padding: 0px;
        }

        .mapael .map {
            margin: 0px;
            position: relative;
        	max-height : 90vh;
        }
        
        .swappable .active {
        	disabled: true;
        }
        
        svg{
        	max-height: 80vh;
        	min-width: 100vw;
        	align: center;
        	display: block;
  			background-color: #eee;
  			margin-left: auto;
  			margin-right: auto;
        }
        
        text{
        	transform:"rotate(10 0,0)"
        }
        
        button{
        	
        }
    </style>
 	
 	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js" charset="utf-8"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-mousewheel/3.1.13/jquery.mousewheel.min.js" charset="utf-8"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.2.7/raphael.min.js" charset="utf-8"></script>
    <script src="static/js/jquery.mapael.min.js" charset="utf-8"></script>
    <script src="static/js/maps/world_countries.js" charset="utf-8"></script>
    <script src="static/js/maps/usa_states.js" charset="utf-8"></script>

    <script type="text/javascript">
       	mapType = 'world_countries';
       	mapData = null;
       	
       	function swapType(thisR){
       		mapType = mapType == 'world_countries' ? 'usa_states' : 'world_countries';
       		$('.swappable').attr('disabled', false);
       		$(thisR).attr('disabled', true);
       		loadMap();
       	}
       	
       	function loadMap(){
           	$(".mapcontainer").mapael({
                   map: {
                       name: mapType,
                       zoom: {
                    		controls : false,
                       		enabled: true,
                       },
                       defaultArea: {
                           attrs: {
                               fill: "#f4f4e8",
                               stroke: "#ced8d0"
                           },
                           atrsHover:{
                        	   fill: '#f4f4e8',
                        		   stroke: "#ced8d0"
                           }
                       },
                       defaultLink: {
                           factor: 0.4,
                           attrs:{
                              "stroke-width": 1
                           },
                           attrsHover: {
                               stroke: "#a4e100"
                           }
                       	
                       },
                       defaultPlot: {
                       	size: 4,
                           text: {
                        	   "position": 'inner',
                               attrs: {
                            	   "font-size": 2,
                            	    fill: "black",
                             	   "font-weight": "normal",
                            	    transform: "r-5"
                               },
                               attrsHover: {
                            	   "font-size": 8,
                            	   "font-weight": "bolder",
                                   fill: "#aa00ff",
                               	   transform: "r10"
                               }
                           }
                       }
                   },
                  "links" : mapData['links'],
                  "plots" : mapData['plots']
              });
       	}
       	
    	$(function () {
    		$.getJSON('api/project/<%=request.getParameter("pid")%>/moneymovement', function(data){
    			mapData = data;
                loadMap();
    		});
        });
    </script>

	</head>

	<body>
		<div class="container">
    		<h1>Money Movement for <%=request.getParameter("pname") != null ? request.getParameter("pname") : request.getParameter("pid")%></h1>

    		<div class="mapcontainer">
        		<div class="map">
            		<span>Loading Map!</span>
        		</div>
        		<div style='width:100%;text-align: center;'> <button class='swappable' onclick='swapType(this);' disabled='disabled'>World</button> <button class='swappable' onclick='swapType(this);'>USA</button></div>
    		</div>
		</div>
	</body>

</html>