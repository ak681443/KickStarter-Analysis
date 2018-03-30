package org.dbms.ks.util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.HexUtils;
import org.dbms.ks.util.DBUtil.DBConnection;

public class SecurityUtil {
	// The only unauthenticated URL is the login url so excluding by default
	@SuppressWarnings("serial")
	private static ArrayList<String> EXCLUDED_SERVLETS = new ArrayList<String>() { {
		add("/login.jsp");
		add("/login");
	}};
	
	public static boolean isAuthenticated(ServletRequest request) {
		
		HttpServletRequest req = (HttpServletRequest) request;
		if(EXCLUDED_SERVLETS.contains(req.getServletPath())) {
			return true;
		}
		
		return isAuthenticated(req);
	}
	

	//TODO authenticate from DB
	public static boolean isAuthenticated(HttpServletRequest request) {
		String cookie = getCookie(request, "_KSID");
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
			if(c.getName().equals(key)) {
				return c.getValue();
			}
		}
		return null;
	}


	public static void generateToken(HttpServletResponse res, int uid) throws Exception {
		DBConnection con = DBUtil.getConnection();
		try {
			byte[] bytes = new byte[100];
			SecureRandom.getInstance("sha1prng").nextBytes(bytes);
			String token = HexUtils.toHexString(bytes);
			int rowCnt = con.prepareQuery("insert.token")
							.setQueryParam(1, token)
							.setQueryParam(2, uid)
							.executeUpdate();
			if(rowCnt == 1) {
				Cookie cookie = new Cookie("_KSID", token);
				//cookie.setSecure(true); dont have https yet :(
				cookie.setHttpOnly(true);
				res.addCookie(cookie);
			}
		} finally {
			con.safeClose();
		}
	}

	public static void authenticate(HttpServletResponse res, String username, String password) throws Exception{
		DBConnection con = DBUtil.getConnection();
		try {
			String passwordHash = HexUtils.toHexString(MessageDigest.getInstance("SHA-256").digest(password.getBytes()));
			ResultSet rs = con.prepareQuery("verify.password")
							  .setQueryParam(1, username)
							  .setQueryParam(2, passwordHash)
							  .executeQuery();
			
			if(rs.next()) {
				generateToken(res, rs.getInt(1));
			}
		}finally {
			con.safeClose();
		}
	}
}
