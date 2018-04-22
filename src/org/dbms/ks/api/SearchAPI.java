package org.dbms.ks.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.dbms.ks.models.Project;
import org.dbms.ks.models.Owner;
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
		keyWords = preProcessKeys(keyWords);
		
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
	
	@Path("/users/{key_words}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response searchUsers(@PathParam("key_words") String keyWords) {
		JSONArray response = new JSONArray();
		DBConnection con = null;
		keyWords = preProcessKeys(keyWords);
		
		try {
			con = DBUtil.getConnection();
			con.prepareQuery("search.users")
				.setQueryParam(1, keyWords)
				.executeQuery();
			Owner owner;
			while(con.hasNext()){
				owner = con.getNext(Owner.class);
				response.put(owner._getRaw());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			if(con != null) con.safeClose();
		}
		
		return Response.ok(response.toString()).build();
	}
	
	/* Preprocess key words by separate each word with comma */
	private String preProcessKeys(String keyWords) {
		String res = "";
		keyWords = keyWords.trim();
		for (int i = 0; i < keyWords.length(); i++) {
			if (keyWords.charAt(i) == ' ') continue;
			int j = i;
			while (i < keyWords.length()) {
				i++;
				if (i == keyWords.length() || keyWords.charAt(i) == ' ')
					break;
			}
			if (res.length() != 0) res += ",";
			res += keyWords.substring(j, i);
		}
		return res;
	}
	
}
