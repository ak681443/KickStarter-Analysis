package org.dbms.ks.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dbms.ks.models.Project;
import org.dbms.ks.util.DBUtil;
import org.dbms.ks.util.DBUtil.DBConnection;
import org.json.JSONArray;

@Path("/search")
public class SearchAPI {
	
	@Path("/projects/{key_words}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response searchProjects(@PathParam("key_words") String keyWords) {
		JSONArray response = new JSONArray();
		DBConnection con = null;
		
		try {
			con = DBUtil.getConnection();
			con.prepareQuery("search.projects")
				.setQueryParam(1, keyWords)
				.executeQuery();
			Project project;
			while(con.hasNext()){
				project = con.getNext(Project.class);
				response.put(project._getRaw());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if(con != null) con.safeClose();
		}
		
		return Response.ok(response.toString()).build();
	}
	
}
