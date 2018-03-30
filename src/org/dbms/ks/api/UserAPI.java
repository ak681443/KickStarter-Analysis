package org.dbms.ks.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("/user")
public class UserAPI {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getUser(@PathParam("id") int id) {
		JSONObject json = new JSONObject();
		json.put("id", id);
		return Response.ok(json.toString()).build();
	}
}
