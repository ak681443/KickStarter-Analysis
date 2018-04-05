<%@page import="java.util.Set"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.dbms.ks.models.Continent"%>
<%@page import="org.dbms.ks.util.DBUtil.DBConnection"%>
<%@page import="org.dbms.ks.util.QueryUtil"%>
<%@page import="org.dbms.ks.util.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<body>
<%
DBConnection c = DBUtil.getConnection();
c.prepareQuery("fetch.continents").executeQuery();
%>

<h2>Hello World!</h2>
<table>
<% for(Continent con :  c.getAll(Continent.class)){ %>
	<tr>
		<%  
			JSONObject obj = con._getRaw();
			for(String key : (Set<String>) obj.keySet()){ %>
			<td> <%=obj.get(key)%></td>
		<% } %>
	</tr>
<%}

c.safeClose();
%>
</table>

</body>
</html>
