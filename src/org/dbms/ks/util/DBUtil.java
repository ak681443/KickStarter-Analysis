package org.dbms.ks.util;

import static org.dbms.ks.util.ConfigUtil.get;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dbms.ks.models.BaseModel;
import org.json.JSONObject;

public class DBUtil {
	
	//TODO move to a connection pool
	public static DBConnection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(get("C_STR"), get("UNAME"), get("PASS"));
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
			rs = pstm.executeQuery();
			return rs;
		}
		
		public int executeUpdate() throws SQLException {
			return pstm.executeUpdate();
		}
		
		@SuppressWarnings("unchecked")
		public <T extends BaseModel>T getNext(Class<T> schema) throws SQLException {
			return (T) getModelObject(rs, schema);	
		}
		
		public <T extends BaseModel> List<T> getAll(Class<T> schema) throws SQLException {
			ArrayList<T> list = new ArrayList<>();
			while(hasNext()) {
				list.add(getNext(schema));
			}
			return list;
		}
		
		public boolean hasNext() throws SQLException {
			return rs.next();
		}
		
		//TODO make it return to pool
		public void safeClose() {
			_safeClose(rs);
			_safeClose(pstm);
			_safeClose(con);
		}
	}
	
	private static BaseModel getModelObject(ResultSet rs, Class<? extends BaseModel> schema) throws SQLException {
		try {
			Method m = schema.getMethod("load", String.class);
			return (BaseModel) m.invoke(null, toJSON(rs));
		}catch(Exception e) {
			throw new SQLException(e);
		}
	}

	private static String toJSON(ResultSet rs) throws SQLException {
		JSONObject json = new JSONObject();
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			json.put(rs.getMetaData().getColumnName(i).toLowerCase(), rs.getObject(i));
		}
		return json.toString();
	}
}
