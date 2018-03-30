package org.dbms.ks.util;

import java.sql.ResultSet;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.dbms.ks.util.DBUtil.DBConnection;

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
		String cookie = getCookie(request, "auth");
		DBConnection con = null;
		try {
			con = DBUtil.getConnection();
			ResultSet rs = con.prepareQuery("auth.user")
							  .setQueryParam(1, cookie)
							  .executeQuery();
			return rs.next();
		} catch(Exception e) {
			//TODO log
		} finally {
			con.safeClose();
		}
		return false;
	}
	
	private static String getCookie(HttpServletRequest request, String key) {
		for(Cookie c : request.getCookies()) {
			if(c.getSecure() && c.isHttpOnly() && c.getDomain().equals(request.getServerName()) && c.getName().equals(key)) {
				return c.getValue();
			}
		}
		return null;
	}
}
