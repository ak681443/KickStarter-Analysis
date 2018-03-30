package org.dbms.ks.util;

import static org.dbms.ks.util.ConfigUtil.get;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	
	//TODO move to a connection pool
	public static DBConnection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(get("C_STR"),get("UNAME"), get("PASS"));
		return new DBConnection(con);  
	}
	
	public static void _safeClose(AutoCloseable resource) {
		try {
			if(resource!=null) {
				resource.close();
			}
		}catch(Exception e) {
			//NO OP
		}
	}
	
	public static class DBConnection {
		private Connection con;
		private PreparedStatement pstm;
		private ResultSet rs;
		
		public DBConnection(Connection con) {
			this.con = con;
		}
	
		public DBConnection prepareQuery(String key) throws SQLException {
			_safeClose(pstm);
			pstm = con.prepareStatement(QueryUtil.get(key));
			return this;
		}
		
		public DBConnection setQueryParam(int idx, Object value) throws SQLException {
			if(pstm!=null) {
				pstm.setObject(idx, value);
			}
			return this;
		}
		
		public ResultSet executeQuery() throws SQLException {
			return pstm.executeQuery();
		}
		
		public int executeUpdate() throws SQLException {
			return pstm.executeUpdate();
		}
		
		//TODO make it return to pool
		public void safeClose() {
			_safeClose(rs);
			_safeClose(pstm);
			_safeClose(con);
		}
	}
}
