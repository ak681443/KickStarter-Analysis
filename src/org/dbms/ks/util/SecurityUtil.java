package org.dbms.ks.util;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class SecurityUtil {
		
	public static boolean isAuthenticated(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest) request;
		// The only unauthenticated URL is the login url so excluding by default
		if(req.getServletPath().equals("/login.jsp")) {
			return true;
		}
		
		return isAuthenticated(req);
	}
	

	//TODO authenticate from DB
	public static boolean isAuthenticated(HttpServletRequest request) {
		return false;
	}
}
