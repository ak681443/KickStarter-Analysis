<%@page import="org.dbms.ks.util.QueryUtil"%>
<%@page import="org.dbms.ks.util.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<html>
<body>
<%
Connection c = DBUtil.getConnection();
PreparedStatement pstm = DBUtil.getQuery(c, "fetch.continents");
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
<%}

DBUtil.safeClose(rs, pstm, c);
%>
</table>

</body>
</html>
