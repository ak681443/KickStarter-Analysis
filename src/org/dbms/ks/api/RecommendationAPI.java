package org.dbms.ks.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dbms.ks.models.Project;
import org.dbms.ks.util.DBUtil;
import org.dbms.ks.util.DBUtil.DBConnection;
import org.json.JSONArray;

@Path("/recommend")
public class RecommendationAPI {
	
	@Path("/projects")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response getProjectRecommendations() {
		JSONArray response = new JSONArray();
		DBConnection con = null;
		try {
			con = DBUtil.getConnection();
			con.prepareQuery("recommend.top_projects").executeQuery();
			Project project;
			while(con.hasNext()){
				project = con.getNext(Project.class);
				response.put(project._getRaw());
			}
		} catch(Exception e) {
			//LOG
			e.printStackTrace();
		} finally {
			if(con!=null) con.safeClose();
		}
		return Response.ok(response.toString()).build();
	}
}
