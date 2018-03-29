<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<body>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection(  
"jdbc:oracle:thin:@oracle.cise.ufl.edu:1521:orcl","asugumar", System.getProperty("pass"));  

PreparedStatement pstm = con.prepareStatement("select * from CONTINENT");
ResultSet rs = pstm.executeQuery();

%>

<h2>Hello World!</h2>
<table>
<% while(rs.next()){ %>
	<tr>
		<% for(int i=0; i<rs.getMetaData().getColumnCount(); i++){ %>
			<td> <%=rs.getObject(i+1).toString()%></td>
		<% } %>
	</tr>
<%} %>
</table>

</body>
</html>
