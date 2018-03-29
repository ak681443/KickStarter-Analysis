package org.dbms.ks.util;

import static org.dbms.ks.util.ConfigUtil.get;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	
	//TODO move to a connection pool
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(get("C_STR"),get("UNAME"), get("PASS"));  
	}
	
	public static PreparedStatement getQuery(Connection c, String key) throws SQLException {
		return c.prepareStatement(QueryUtil.get(key));
	}
	
	//TODO make it return to pool
	public static void safeClose(AutoCloseable ...resources) {
		for(AutoCloseable c : resources) {
			_safeClose(c);
		}
	}
	
	private static void _safeClose(AutoCloseable resource) {
		try {
			if(resource!=null) {
				resource.close();
			}
		}catch(Exception e) {
			//NO OP
		}
	}
}
