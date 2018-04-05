package org.dbms.ks.api;

import java.net.URI;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

import org.dbms.ks.util.SecurityUtil;

@Path("/login")
public class AuthAPI {
	
	private Response redirectToLogin = Response.seeOther(URI.create("../login.jsp")).build();
	
	@POST
	@Path("/")
	public Response doLogin(@FormParam("username") String username, @FormParam("password") String password) {
		Response res = redirectToLogin;
		try {
			NewCookie authCookie = SecurityUtil.authenticate(username, password);
			if(authCookie!=null) {
				res = Response.seeOther(URI.create("../index.jsp"))
					.cookie(authCookie)
					.build();
			}
		} catch(Exception e) {
			
		}
		return res;
	}
}
